package com.sgh.sgh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgh.sgh.Dao.IDaoModulo;
import com.sgh.sgh.Entity.Modulo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DaoModulo implements IDaoModulo {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Modulo> findAll() {
        return em.createQuery("FROM Modulo", Modulo.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Modulo findById(int id) {
        return em.find(Modulo.class, id);
    }

    @Override
    @Transactional
    public Modulo save(Modulo modulo) {
        em.persist(modulo);
        return modulo;
    }

    @Override
    @Transactional
    public Modulo update(Modulo modulo) {
        return em.merge(modulo);
    }
}
