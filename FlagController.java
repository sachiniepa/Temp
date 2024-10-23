package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flags")
public class FlagController {
    private static final String FILE_PATH = "C:/Users/sachi/OneDrive/Desktop/Douglas/Fall_24/SE/Project/proj/proj/src/main/resources/flags.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<Flag> readFlagsFromFile() throws IOException {
        return objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Flag>>() {});
    }

    private void writeFlagsToFile(List<Flag> flags) throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), flags);
    }

    @GetMapping
    public ResponseEntity<List<Flag>> getAllFlags() {
        try {
            List<Flag> flags = readFlagsFromFile();
            return ResponseEntity.ok(flags);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{flag_id}")
    public ResponseEntity<Flag> getFlagById(@PathVariable int flag_id) {
        try {
            List<Flag> flags = readFlagsFromFile();
            Optional<Flag> flag = flags.stream().filter(f -> f.getFlagId() == flag_id).findFirst();
            return flag.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Flag> createFlag(@RequestBody Flag newFlag) {
        try {
            List<Flag> flags = readFlagsFromFile();
            newFlag.setFlagId(flags.size() + 1); // Simple ID assignment
            flags.add(newFlag);
            writeFlagsToFile(flags);
            return ResponseEntity.status(201).body(newFlag);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{flag_id}")
    public ResponseEntity<Flag> updateFlag(@PathVariable int flag_id, @RequestBody Flag updatedFlag) {
        try {
            List<Flag> flags = readFlagsFromFile();
            for (int i = 0; i < flags.size(); i++) {
                if (flags.get(i).getFlagId() == flag_id) {
                    flags.set(i, updatedFlag);
                    updatedFlag.setFlagId(flag_id); // Maintain the original ID
                    writeFlagsToFile(flags);
                    return ResponseEntity.ok(updatedFlag);
                }
            }
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{flag_id}")
    public ResponseEntity<Void> deleteFlag(@PathVariable int flag_id) {
        try {
            List<Flag> flags = readFlagsFromFile();
            flags.removeIf(flag -> flag.getFlagId() == flag_id);
            writeFlagsToFile(flags);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
