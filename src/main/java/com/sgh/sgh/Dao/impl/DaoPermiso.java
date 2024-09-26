package com.sgh.sgh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgh.sgh.Dao.IDaoPermiso;
import com.sgh.sgh.Entity.Permiso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DaoPermiso implements IDaoPermiso {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Permiso> findAll() {
        try {
            return em.createQuery("FROM Permiso", Permiso.class).getResultList();
        } catch (Exception ex) {
            // Manejo de excepciones mejorado
            System.err.println("Error al obtener permisos: " + ex.getMessage());
            ex.printStackTrace();
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }
}
