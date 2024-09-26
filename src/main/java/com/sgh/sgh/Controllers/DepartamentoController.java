package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.IDaoDepartamento;
import com.sgh.sgh.Entity.Departamento;

@RestController
@RequestMapping(value = "/sgh")
public class DepartamentoController {
	@Autowired
	public IDaoDepartamento deptoDao;
	
	@GetMapping(value = "/departamento/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Departamento> listarDepto(){
		return deptoDao.listar();
	}
	
	@PostMapping(value = "/departamento/agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Departamento crearDepto(@RequestBody Departamento depto) {
		return deptoDao.crearDepa(depto);
	}
}
