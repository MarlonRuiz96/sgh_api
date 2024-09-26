package com.sgh.sgh.Dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sgh.sgh.Dao.IDaoSesion;
import com.sgh.sgh.Entity.Sesion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DaoSesion implements IDaoSesion {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Sesion> findAll() {
        return em.createQuery("FROM Sesion", Sesion.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Sesion findById(int id) {
        return em.find(Sesion.class, id);
    }

    @Override
    @Transactional
    public Sesion save(Sesion sesion) {
        em.persist(sesion);
        return sesion;
    }

    @Override
    @Transactional
    public Sesion update(Sesion sesion) {
        return em.merge(sesion);
    }
}
