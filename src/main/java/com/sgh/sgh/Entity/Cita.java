package com.sgh.sgh.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    public Date fecha_cita;
    public String estado;
    public Integer paciente_id;
    public Integer personal_medico_id;
    public Integer usuario_creacion;
    public Date fecha_creacion;
    public Integer usuario_modificacion; 
    public Date fecha_modificacion; 
}
