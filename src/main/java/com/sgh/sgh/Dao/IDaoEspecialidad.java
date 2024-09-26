package com.sgh.sgh.Dao;

import java.util.List;

import com.sgh.sgh.Entity.Especialidad;

public interface IDaoEspecialidad {
	public List<Especialidad> listar();
	public Especialidad crearEspecialidad(Especialidad especialidad);
}
