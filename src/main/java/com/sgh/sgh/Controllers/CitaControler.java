package com.sgh.sgh.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.IDaoCita;
import com.sgh.sgh.Entity.Cita;

@RestController
@RequestMapping(value = ("/sgh"))
public class CitaControler {

	 	@Autowired
	    private IDaoCita daoCitas;

	    @GetMapping(value = "/citas", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Cita> getCitas() {
			return daoCitas.findAll();
		}

	    @GetMapping(value = "/citas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Cita> getCitasById(@PathVariable int id) {
	        Optional<Cita> optionalCita = daoCitas.findById(id);
	        
	        if (optionalCita.isPresent()) {
	            return ResponseEntity.ok(optionalCita.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }


		
		@PostMapping(value = "/citas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Cita save(@RequestBody Cita cita) {
			return daoCitas.save(cita);
		}

		@PutMapping(value = "/citas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Cita> update(@RequestBody @Validated Cita cita) {
		    Optional<Cita> existingCita = daoCitas.findById(cita.getId());
		    
		    if (existingCita.isPresent()) {
		        Cita updatedCita = daoCitas.update(cita);
		        return ResponseEntity.ok(updatedCita);
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		    }
		}
		
		@PutMapping(value = "/citas/cancelar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Cita> delete(@RequestBody @Validated Cita cita) {
		    Optional<Cita> existingCita = daoCitas.findById(cita.getId());
		    
		    if (existingCita.isPresent()) {
		        Cita updatedCita = daoCitas.update(cita);
		        return ResponseEntity.ok(updatedCita);
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		    }
		}

		
}
