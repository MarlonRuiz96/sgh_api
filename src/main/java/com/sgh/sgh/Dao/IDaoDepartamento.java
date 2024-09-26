package com.sgh.sgh.Dao;

import java.util.List;

import com.sgh.sgh.Entity.Departamento;

public interface IDaoDepartamento {
	public List<Departamento> listar();
	public Departamento crearDepa(Departamento depto);
}
