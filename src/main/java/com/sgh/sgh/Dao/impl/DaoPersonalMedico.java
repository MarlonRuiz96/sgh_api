package com.sgh.sgh.Dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sgh.sgh.Dao.IDaoPersonalMedico;
import com.sgh.sgh.Entity.PersonalMedico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class DaoPersonalMedico implements IDaoPersonalMedico {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<PersonalMedico> findAll() {
        return em.createQuery("FROM PersonalMedico", PersonalMedico.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalMedico findById(int id) {
        return em.find(PersonalMedico.class, id);
    }
    
    @Override
    @Transactional
    public PersonalMedico agregarRegistro(PersonalMedico personalMedico) {
        em.persist(personalMedico);  // Insertar un nuevo registro
        return personalMedico;
    }

    @Override
    @Transactional
    public PersonalMedico actualizarRegistro(PersonalMedico personalMedico) {
        return em.merge(personalMedico);
    }

    @Override
    @Transactional
    public void eliminarRegistro(int id) {
        PersonalMedico personalMedico = findById(id);
        if (personalMedico != null) {
            em.remove(personalMedico);
        }
    }
}
