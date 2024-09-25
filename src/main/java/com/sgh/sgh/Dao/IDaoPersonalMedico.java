package com.sgh.sgh.Dao;

import java.util.List;
import com.sgh.sgh.Entity.PersonalMedico;

public interface IDaoPersonalMedico {
    List<PersonalMedico> findAll();
    PersonalMedico findById(int id);
    PersonalMedico agregarRegistro(PersonalMedico personalMedico);
    PersonalMedico actualizarRegistro(PersonalMedico personalMedico);
    void eliminarRegistro(int id);
}

