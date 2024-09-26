package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sgh.sgh.Dao.IDaoModulo;
import com.sgh.sgh.Entity.Modulo;

@RestController
@RequestMapping(value = "/sgh")
public class ModuloController {

    @Autowired
    private IDaoModulo daoModulo;

    @GetMapping("/modulo")
    public List<Modulo> listar() {
        return daoModulo.findAll();
    }

    @GetMapping("/modulo/{id}")
    public Modulo obtenerPorId(@PathVariable int id) {
        return daoModulo.findById(id);
    }

    @PostMapping("/modulo")
    public Modulo guardar(@RequestBody Modulo modulo) {
        return daoModulo.save(modulo);
    }

    @PutMapping("/modulo")
    public Modulo actualizar(@RequestBody Modulo modulo) {
        return daoModulo.update(modulo);
    }
}
