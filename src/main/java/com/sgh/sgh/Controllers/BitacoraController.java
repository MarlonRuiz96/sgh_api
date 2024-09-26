package com.sgh.sgh.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.IDaoBitacora;
import com.sgh.sgh.Entity.Bitacora;

@RestController

@CrossOrigin(origins = "*")
@RequestMapping(value = ("/sgh"))
public class BitacoraController {
	@Autowired
	public IDaoBitacora daoBitacora;
	
	@GetMapping(value = "/bitacora", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bitacora> getBitacora(){
		return daoBitacora.findAll();
	}
	

	@GetMapping(value ="/bitacora/buscarPorParametro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bitacora>> buscarBitacora(
            @RequestParam(required = false) String accion,
            @RequestParam(required = false) Integer modulo,
            @RequestParam(required = false) Integer usuario,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        try {
            List<Bitacora> resultados = daoBitacora.SelectBitacora(accion, modulo, usuario, fechaIni, fechaFin);
            if (resultados.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(resultados, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping(value = "/bitacora/agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bitacora> agregarRegistro(@RequestBody Bitacora bitacora) {
        try {
            Bitacora nuevoRegistro = daoBitacora.agregarRegistro(bitacora);
            if (nuevoRegistro == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(nuevoRegistro, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}