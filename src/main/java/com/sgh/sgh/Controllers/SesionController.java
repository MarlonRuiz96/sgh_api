package com.sgh.sgh.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sgh.sgh.Dao.IDaoSesion;
import com.sgh.sgh.Entity.Sesion;

@RestController
@RequestMapping(value = "/sgh")
public class SesionController {
    @Autowired
    private IDaoSesion daoSesion;

    @GetMapping("/sesion")
    public List<Sesion> listar() {
        return daoSesion.findAll();
    }

    @GetMapping("/sesion/{id}")
    public Sesion obtenerPorId(@PathVariable int id) {
        return daoSesion.findById(id);
    }

    @PostMapping("/sesion")
    public Sesion guardar(@RequestBody Sesion sesion) {
        return daoSesion.save(sesion);
    }

    @PutMapping("/sesion")
    public Sesion actualizar(@RequestBody Sesion sesion) {
        return daoSesion.update(sesion);
    }
}
