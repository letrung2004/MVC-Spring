package com.lqt.mvcspring.repository.Impl;

import com.lqt.mvcspring.pojo.Category;
import com.lqt.mvcspring.repository.CategoryRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    private final SessionFactory sessionFactory;

    public CategoryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> getCategories() {
        try(Session session = this.sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Category> q = builder.createQuery(Category.class);
            Root<Category> root = q.from(Category.class);
            q.select(root);
            List<Category> categories = session.createQuery(q).getResultList();
            return categories;
        }
    }
}
