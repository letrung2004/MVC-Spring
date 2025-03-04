package com.lqt.mvcspring.repository.Impl;

import com.lqt.mvcspring.pojo.Category;
import com.lqt.mvcspring.pojo.Product;
import com.lqt.mvcspring.repository.StatsRepository;
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
import java.util.Objects;

@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public StatsRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Objects[]> countProByCate() {
        try(Session session = this.sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
            Root rP = q.from(Product.class);
            Root rC = q.from(Category.class);

            q.multiselect(rC.get("id"), rC.get("name"), builder.count(rP));
            q.where(builder.equal(rP.get("category").get("id"), rC.get("id")));
            q.groupBy(rC.get("id"));

            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }
}
