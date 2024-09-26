package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.impl.DaoEspecialidad;
import com.sgh.sgh.Entity.Especialidad;

@RestController
@RequestMapping(value = "/sgh")
public class EspecialidadController {
	@Autowired
	public DaoEspecialidad especialidadDao;
	
	@GetMapping(value = "/especialidad/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Especialidad> listarEspecialidad(){
		return especialidadDao.listar();
	}
	
	@PostMapping(value = "/especialidad/agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Especialidad crearEspecialidad(@RequestBody Especialidad espcldad) {
		return especialidadDao.crearEspecialidad(espcldad);
	}
}
