package com.sgh.sgh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgh.sgh.Dao.IDaoDepartamento;
import com.sgh.sgh.Entity.Departamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DaoDepartamento implements IDaoDepartamento{

	@PersistenceContext
	public EntityManager em;
	
	@Transactional
	@Override
	public List<Departamento> listar() {
		try {
			List<Departamento> listadoDepto = em.createQuery("FROM Departamento", Departamento.class).getResultList();
			return listadoDepto;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public Departamento crearDepa(Departamento depto) {
		try {
			em.persist(depto);
			return depto;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
