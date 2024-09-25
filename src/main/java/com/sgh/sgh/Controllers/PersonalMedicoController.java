package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgh.sgh.Dao.IDaoPersonalMedico;
import com.sgh.sgh.Entity.PersonalMedico;

@RestController
@RequestMapping("/sgh")
public class PersonalMedicoController {

    @Autowired
    private IDaoPersonalMedico personalMedicoDao;

    @GetMapping(value = "/PersonalMedico", produces = "application/json")
    public ResponseEntity<List<PersonalMedico>> getAllPersonalMedico() {
        List<PersonalMedico> lista = personalMedicoDao.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/PersonalMedico/{id}")
    public ResponseEntity<PersonalMedico> getPersonalMedicoById(@PathVariable int id) {
        PersonalMedico personalMedico = personalMedicoDao.findById(id);
        if (personalMedico == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personalMedico, HttpStatus.OK);
    }

    @PostMapping("/PersonalMedico")
    public ResponseEntity<PersonalMedico> createPersonalMedico(@RequestBody PersonalMedico personalMedico) {
        if (personalMedico.getEstado() == null) {
            personalMedico.setEstado(1); // Estado activo por defecto
        }
        PersonalMedico createdPersonalMedico = personalMedicoDao.agregarRegistro(personalMedico);
        return new ResponseEntity<>(createdPersonalMedico, HttpStatus.CREATED);
    }

    /**
     * Actualiza el PersonalMedico completo usando PUT.
     * Si solo deseas actualizar 'estado', asegúrate de enviar los demás campos sin cambios.
     */
    @PutMapping("/PersonalMedico/{id}")
    public ResponseEntity<PersonalMedico> updatePersonalMedico(@PathVariable int id, @RequestBody PersonalMedico personalMedico) {
        PersonalMedico existente = personalMedicoDao.findById(id);
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Asegurar que el ID del objeto enviado coincide con el ID de la ruta
        personalMedico.setId(id);
        PersonalMedico actualizado = personalMedicoDao.actualizarRegistro(personalMedico);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    /**
     * Baja lógica: Actualiza solo el estado usando PATCH.
     * 
     * @param id El ID del PersonalMedico a actualizar.
     * @param estadoRequest Objeto que contiene el nuevo estado.
     * @return ResponseEntity con el estado actualizado o un error si no se encuentra.
     */
    @PatchMapping("/PersonalMedico/{id}")
    public ResponseEntity<String> updateEstadoPatch(@PathVariable int id, @RequestBody EstadoRequest estadoRequest) {
        // Validar el nuevo estado
        if (estadoRequest.getEstado() == null || (estadoRequest.getEstado() != 0 && estadoRequest.getEstado() != 1)) {
            return new ResponseEntity<>("Estado inválido. Debe ser 0 o 1.", HttpStatus.BAD_REQUEST);
        }

        // Buscar el registro por ID
        PersonalMedico personalMedico = personalMedicoDao.findById(id);
        if (personalMedico == null) {
            return new ResponseEntity<>("PersonalMedico no encontrado", HttpStatus.NOT_FOUND);
        }

        // Actualizar el estado
        personalMedico.setEstado(estadoRequest.getEstado());
        personalMedicoDao.actualizarRegistro(personalMedico);

        return new ResponseEntity<>("Estado actualizado a " + estadoRequest.getEstado(), HttpStatus.OK);
    }

    /**
     * Clase interna para manejar la solicitud de actualización de estado.
     */
    public static class EstadoRequest {
        private Integer estado;

        public Integer getEstado() {
            return estado;
        }

        public void setEstado(Integer estado) {
            this.estado = estado;
        }
    }

    // Otros endpoints y métodos...
}
