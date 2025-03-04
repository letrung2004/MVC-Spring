package com.lqt.mvcspring.repository.Impl;

import com.lqt.mvcspring.pojo.Product;
import com.lqt.mvcspring.repository.ProductRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getProducts() {
        try(Session session = this.sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> q = builder.createQuery(Product.class);
            Root<Product> root = q.from(Product.class);
            q.select(root);

            Query query = session.createQuery(q);
            return query.getResultList();
        }

    }
}
