package com.sgh.sgh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sgh.sgh.Dao.IDaoHistorialMedico;
import com.sgh.sgh.Entity.HistorialMedico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class DaoHistorialMedico implements IDaoHistorialMedico {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<HistorialMedico> listAll() {
		return entityManager.createQuery("from HistorialMedico", HistorialMedico.class).getResultList();
	}

	@Override
	@Transactional
	public HistorialMedico findById(int id) {
		return entityManager.find(HistorialMedico.class, id);
	}

	@Override
	@Transactional
	public HistorialMedico save(HistorialMedico historialMedico) {
		entityManager.persist(historialMedico);
		return historialMedico;
	}

	@Override
	@Transactional
	public HistorialMedico update(HistorialMedico historialMedico) {
		entityManager.merge(historialMedico);
		return historialMedico;
	}
}
