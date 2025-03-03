package com.lqt.mvcspring.controllers;

import com.lqt.mvcspring.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @GetMapping("/")
    @Transactional
    public String getHomePage(Model model) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("From Product", Product.class);
        List<Product> products = query.getResultList();

        model.addAttribute("products", products);
        return "home";
    }
}