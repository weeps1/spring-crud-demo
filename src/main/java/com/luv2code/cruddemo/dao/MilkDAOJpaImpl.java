package com.luv2code.cruddemo.dao;


import com.luv2code.cruddemo.entity.Milk;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public class MilkDAOJpaImpl implements MilkDAO {

    private final EntityManager entityManager;

    @Autowired
    public MilkDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Milk> findAll() {

        TypedQuery<Milk> query = entityManager.createQuery("from Milk", Milk.class);

        var list = query.getResultList();

        return list;

    }

}
