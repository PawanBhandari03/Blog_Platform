package com.pawan.blog.Services.Impl;

import com.pawan.blog.Services.CategoryService;
import com.pawan.blog.domain.entities.Category;
import com.pawan.blog.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        String categoryName = category.getName();
            if(categoryRepository.existsByNameIgnoreCase(categoryName)){
                throw new IllegalArgumentException("category already exists with name : " + categoryName);
        }
            return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            if(!category.get().getPosts().isEmpty()){
                throw new IllegalArgumentException("Category has posts associated with it");
            }
            categoryRepository.deleteById(id);
        }
    }
}
