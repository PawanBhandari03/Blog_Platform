package com.pawan.blog.Services.Impl;

import com.pawan.blog.Services.CategoryService;
import com.pawan.blog.domain.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> listCategories() {
        return List.of();
    }
}
