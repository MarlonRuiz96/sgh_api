package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.IDaoPermiso;
import com.sgh.sgh.Entity.Bitacora;
import com.sgh.sgh.Entity.Permiso;

@RestController

@CrossOrigin(origins = "*")
@RequestMapping(value = ("/sgh"))
public class PermisoController {
	
	@Autowired
	public IDaoPermiso daoPermiso;
	
	@GetMapping(value = "/perimso", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Permiso> getPermiso(){
		return daoPermiso.findAll();
	}
	
	
	

}
