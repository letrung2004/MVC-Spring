package com.lqt.mvcspring.repository;

import com.lqt.mvcspring.pojo.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
}
