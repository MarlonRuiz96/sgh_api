package com.sgh.sgh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgh.sgh.Dao.IDaoEspecialidad;
import com.sgh.sgh.Entity.Especialidad;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DaoEspecialidad implements IDaoEspecialidad{
	@PersistenceContext
	public EntityManager em;

	@Transactional
	@Override
	public List<Especialidad> listar() {
		try {
			List<Especialidad> listadoEspecialidad = em.createQuery("FROM Especialidad", Especialidad.class).getResultList();
			return listadoEspecialidad;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public Especialidad crearEspecialidad(Especialidad especialidad) {
		try {
			em.persist(especialidad);
			return especialidad;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
