package com.lqt.mvcspring.service.Impl;

import com.lqt.mvcspring.pojo.Category;
import com.lqt.mvcspring.repository.CategoryRepository;
import com.lqt.mvcspring.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCate() {
        return categoryRepository.getCategories();
    }
}
