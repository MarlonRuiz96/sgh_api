package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.IDaoHistorialMedico;
import com.sgh.sgh.Entity.HistorialMedico;

@RestController
@RequestMapping(value = "/sgh")
public class HistorialMedicoController {
	@Autowired
    private IDaoHistorialMedico historialMedicoDao;

    @GetMapping("/historial_medico")
    public List<HistorialMedico> listar() {
        return historialMedicoDao.listAll();
    }

    @GetMapping("/historial_medico/{id}")
    public HistorialMedico obtenerPorId(@PathVariable int id) {
        return historialMedicoDao.findById(id);
    }

    @PostMapping("/historial_medico")
    public void guardar(@RequestBody HistorialMedico historialMedico) {
        historialMedicoDao.save(historialMedico);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody HistorialMedico historialMedico) {
        historialMedicoDao.update(historialMedico);
    }
}
