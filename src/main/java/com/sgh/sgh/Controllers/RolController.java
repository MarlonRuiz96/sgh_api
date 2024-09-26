package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.IDaoRol;
import com.sgh.sgh.Entity.Rol;

@RestController
@RequestMapping(value = "/sgh")
public class RolController {
	@Autowired
	public IDaoRol rolDao;
	
	@GetMapping(value = "/listarRol", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Rol> listar(){
		return rolDao.listar();
	}
	
}
