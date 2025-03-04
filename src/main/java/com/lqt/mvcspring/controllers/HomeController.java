package com.lqt.mvcspring.controllers;

import com.lqt.mvcspring.pojo.Category;
import com.lqt.mvcspring.pojo.Product;
import com.lqt.mvcspring.service.CategoryService;
import com.lqt.mvcspring.service.ProductService;
import com.lqt.mvcspring.service.StatsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {

    private ProductService productService;
    private StatsService statsService;
    private CategoryService categoryService;

    @Autowired
    public void setSessionFactory(ProductService productService,
                                  StatsService statsService,
                                  CategoryService categoryService) {
        this.categoryService=categoryService;
        this.productService = productService;
        this.statsService = statsService;
    }

    @GetMapping("/")
    @Transactional
    public String getHomePage(Model model) {

        List<Product> products = productService.getAllProduct();

        List<Objects[]> productStats = statsService.countProByCate();
        List<Category> categories = categoryService.getAllCate();

        model.addAttribute("products", products);
        model.addAttribute("productStats", productStats);
        model.addAttribute("categories", categories);
        return "home";
    }


}