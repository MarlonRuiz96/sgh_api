package com.sgh.sgh.Dao;

import java.util.List;
import java.util.Optional;

import com.sgh.sgh.Entity.Cita;

public interface IDaoCita {
	public List<Cita> findAll();
	public Optional<Cita> findById(int id);
    public Cita save(Cita cita);
    public Cita update(Cita cita);
    public Cita delete(Cita cita);
	

}
