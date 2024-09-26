package com.sgh.sgh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgh.sgh.Dao.IDaoRol;
import com.sgh.sgh.Entity.Rol;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DaoRol implements IDaoRol{
	
	@PersistenceContext
	public EntityManager em;
	
	@Transactional
	@Override
	public List<Rol> listar() {
		try {
			List<Rol> listaRoles = em.createQuery("FROM Rol", Rol.class).getResultList();
			return listaRoles;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

}
