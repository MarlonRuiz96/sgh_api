package com.sgh.sgh.Dao;

import java.util.List;

import com.sgh.sgh.Entity.HistorialMedico;

public interface IDaoHistorialMedico {
	List<HistorialMedico> listAll();
	HistorialMedico findById(int id);
	HistorialMedico save(HistorialMedico historialMedico);
	HistorialMedico update(HistorialMedico historialMedico);
}
