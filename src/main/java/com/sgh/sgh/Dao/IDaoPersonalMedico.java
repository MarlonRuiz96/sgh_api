package com.sgh.sgh.Dao;

import java.util.List;
import com.sgh.sgh.Entity.PersonalMedico;

public interface IDaoPersonalMedico {
    public List<PersonalMedico> findAll();
    public PersonalMedico findById(int id);
    public PersonalMedico agregarRegistro(PersonalMedico personalMedico);
    //public PersonalMedico actualizarRegistro(PersonalMedico personalMedico);
    //public void eliminarRegistro(int id);
}
