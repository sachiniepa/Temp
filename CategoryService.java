package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class CategoryService {
	private final String FILE_PATH = "C:/Users/sachi/OneDrive/Desktop/Douglas/Fall_24/SE/Project/proj/proj/src/main/resources/Categories.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Category> getCategories() throws IOException {
        return objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Category>>() {});
    }

    public void saveCategories(List<Category> categories) throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), categories);
    }

    public void addCategory(Category category) throws IOException {
        List<Category> categories = getCategories();
        categories.add(category);
        saveCategories(categories);
    }

    public void updateCategory(Category category) throws IOException {
        List<Category> categories = getCategories();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryId() == category.getCategoryId()) {
                categories.set(i, category);
                break;
            }
        }
        saveCategories(categories);
    }

    public void deleteCategory(int id) throws IOException {
        List<Category> categories = getCategories();
        categories.removeIf(category -> category.getCategoryId() == id);
        saveCategories(categories);
    }
}
