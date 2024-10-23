package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	
	private static final String FILE_PATH = "C:\\Users\\sachi\\OneDrive\\Desktop\\Douglas\\Fall_24\\SE\\Project\\proj\\proj\\src\\main\\resources\\Users.json"; // Path to your JSON file
    ObjectMapper objectMapper = new ObjectMapper();

    public List<User> getUsers(){
    	
        File file = new File("C:/Users/sachi/OneDrive/Desktop/Douglas/Fall_24/SE/Project/proj/proj/src/main/resources/Users.json");
        List<User> users = new ArrayList<User>();
        try {
        	users = objectMapper.readValue(file, List.class);
        }
        catch(Exception e) {
        	System.out.println("test3");
        	e.printStackTrace();
        }
        return users;
    }

    private void saveUsers(List<User> users) throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), users);
    }

    public List<User> findAll() throws IOException {
        return getUsers();
    }

    public User findById(int userId) throws IOException {
        return getUsers().stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    public void createUser(User newUser) throws IOException {
        List<User> users = getUsers();
        users.add(newUser);
        saveUsers(users);
    }

    public void updateUser(User updatedUser) throws IOException {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getUserId() == updatedUser.getUserId()) {
                user.setUsername(updatedUser.getUsername());
                user.setPassword(updatedUser.getPassword());
                user.setName(updatedUser.getName());
                user.setCollege(updatedUser.getCollege());
                user.setEdited(updatedUser.isEdited());
                user.setDeleted(updatedUser.isDeleted());
                user.setUserTypeId(updatedUser.getUserTypeId());
                break;
            }
        }
        saveUsers(users);
    }

    public void deleteUser(int userId) throws IOException {
        List<User> users = getUsers();
        users.removeIf(user -> user.getUserId() == userId);
        saveUsers(users);
    }

}
