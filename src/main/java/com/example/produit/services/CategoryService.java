package com.example.produit.services;

import java.util.List;

import com.example.produit.entities.Category;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    

}
