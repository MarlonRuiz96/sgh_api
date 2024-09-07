package com.sgh.sgh.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgh.sgh.Dao.IDaoPersonalMedico;
import com.sgh.sgh.Entity.PersonalMedico;

@RestController
@RequestMapping("/api/personal_medico")
public class PersonalMedicoController {

    @Autowired
    private IDaoPersonalMedico personalMedicoDao;

    // Obtener todos los registros de personal médico (GET)
    @GetMapping
    public List<PersonalMedico> getAllPersonalMedico() {
        return personalMedicoDao.findAll();
    }

    // Obtener un registro de personal médico por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<PersonalMedico> getPersonalMedicoById(@PathVariable int id) {
        PersonalMedico personalMedico = personalMedicoDao.findById(id);
        if (personalMedico == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personalMedico, HttpStatus.OK);
    }

   
    // Crear un nuevo registro de personal médico (POST)
    @PostMapping
    public ResponseEntity<PersonalMedico> createPersonalMedico(@RequestBody PersonalMedico personalMedico) {
        PersonalMedico createdPersonalMedico = personalMedicoDao.agregarRegistro(personalMedico);
        return new ResponseEntity<>(createdPersonalMedico, HttpStatus.CREATED);
    }
    /*
    // Actualizar un registro de personal médico existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<PersonalMedico> updatePersonalMedico(@PathVariable int id, @RequestBody PersonalMedico personalMedico) {
        PersonalMedico existingPersonalMedico = personalMedicoDao.findById(id);
        if (existingPersonalMedico == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personalMedico.setId(id);
        personalMedicoDao.actualizarRegistro(personalMedico);
        return new ResponseEntity<>(personalMedico, HttpStatus.OK);
    }

    // Eliminar un registro de personal médico por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalMedico(@PathVariable int id) {
        PersonalMedico personalMedico = personalMedicoDao.findById(id);
        if (personalMedico == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personalMedicoDao.eliminarRegistro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    */
}
