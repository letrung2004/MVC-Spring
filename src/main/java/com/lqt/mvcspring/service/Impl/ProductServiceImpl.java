package com.lqt.mvcspring.service.Impl;

import com.lqt.mvcspring.pojo.Product;
import com.lqt.mvcspring.repository.ProductRepository;
import com.lqt.mvcspring.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getProducts();
    }
}
