package com.sgh.sgh.Dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sgh.sgh.Dao.IDaoBitacora;
import com.sgh.sgh.Entity.Bitacora;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

@Repository
@Transactional
public class DaoBitacora implements IDaoBitacora{
	
	@PersistenceContext
	public EntityManager em;

	@Transactional(readOnly=true)
	@Override
	public List<Bitacora> findAll() {
		try {
			List<Bitacora> listaBitacora = em.createQuery("FROM Bitacora", Bitacora.class).getResultList();
			return listaBitacora;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Bitacora> SelectBitacora(String accion, int modulo, int usuario, Date fechaIni, Date fechaFin) {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
	        CriteriaQuery<Bitacora> criteria = builder.createQuery(Bitacora.class);
	        Root<Bitacora> root = criteria.from(Bitacora.class);
	        
	        Predicate accionCondition = builder.and(
	        		builder.equal(root.get("accion"), accion),
	        		builder.between(root.get("fecha"), fechaIni, fechaFin)
	        );

	        Predicate moduloCondition = builder.and(
	        		builder.equal(root.get("modulo"), modulo),
	        		builder.between(root.get("fecha"), fechaIni, fechaFin)
	        );

	        Predicate usuarioCondition = builder.and(
	        		builder.equal(root.get("usuario"), usuario),
	        		builder.between(root.get("fecha"), fechaIni, fechaFin)
	        );

	        criteria.where(builder.or(accionCondition, moduloCondition, usuarioCondition));
	        
	        return em.createQuery(criteria).getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

/*	@Override
	public Bitacora agregarRegistro(Bitacora bitacora) {
		try {
			em.persist(bitacora);
			return bitacora;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}*/
	
	@Override
	public Bitacora agregarRegistro(Bitacora bitacora) {
	    try {
	        // Captura la IP del cliente
	        String ipAddress = getClientIp();
	        
	        // Asigna la IP al objeto Bitacora
	        bitacora.setIp(ipAddress);
	        
	        em.persist(bitacora);
	        return bitacora;
	    } catch(Exception ex) {
	        ex.printStackTrace();
	        return null;
	    }
	}

	// Método para capturar la IP del cliente
	private String getClientIp() {
	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    String ipAddress = request.getHeader("X-Forwarded-For");
	    if (ipAddress == null || ipAddress.isEmpty()) {
	        ipAddress = request.getRemoteAddr();
	    }
	    return ipAddress;
	}

}
