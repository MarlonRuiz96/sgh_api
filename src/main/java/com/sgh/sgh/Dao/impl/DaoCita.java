package com.sgh.sgh.Dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sgh.sgh.Dao.IDaoCita;
import com.sgh.sgh.Entity.Cita;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class DaoCita implements IDaoCita{
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
    @Override
	public List<Cita> findAll() {
		try {
            List<Cita> listaCitas = em.createQuery("FROM Cita", Cita.class).getResultList();
            return listaCitas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cita> findById(int id) {
	    try {
	        Cita cita = em.find(Cita.class, id);
	        return Optional.ofNullable(cita);  
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Optional.empty();  
	    }
	}

	@Override
	public Cita save(Cita cita) {
		try {
            em.persist(cita);
            return cita;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Cita update(Cita cita) {
		 try {
	            em.merge(cita);
	            return cita;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public Cita delete(Cita cita) {
		 try {
	            em.merge(cita);
	            return cita;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}

}
