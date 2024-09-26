package com.sgh.sgh.Dao;

import java.util.List;
import com.sgh.sgh.Entity.Modulo;

public interface IDaoModulo {
    List<Modulo> findAll();
    Modulo findById(int id);
    Modulo save(Modulo modulo);
    Modulo update(Modulo modulo);
}
