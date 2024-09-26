package com.sgh.sgh.Dao;

import java.util.List;
import com.sgh.sgh.Entity.Sesion;

public interface IDaoSesion {
    List<Sesion> findAll();
    Sesion findById(int id);
    Sesion save(Sesion sesion);
    Sesion update(Sesion sesion);
}
