package com.lqt.mvcspring.repository;

import com.lqt.mvcspring.pojo.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getCategories();
}
