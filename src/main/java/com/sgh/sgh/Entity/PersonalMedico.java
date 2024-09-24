package com.sgh.sgh.Entity;

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
@Table(name = "personal_medico")
public class PersonalMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // 'nombre' ahora permite nulos si lo has configurado así en la DB
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;

    // 'apellido' ahora permite nulos
    @Column(name = "apellido", nullable = true, length = 45)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = true)
    private Date fechaNacimiento;

    @Column(name = "genero", length = 45, nullable = true)
    private String genero;

    @Column(name = "especialidad", nullable = true)
    private Integer especialidad;

    @Column(name = "departamento", length = 45, nullable = true)
    private String departamento;

    @Column(name = "telefono", length = 45, nullable = true)
    private String telefono;

    @Column(name = "correo", length = 45, nullable = true)
    private String correo;

    @Column(name = "fecha_contratacion", nullable = true)
    private Date fechaContratacion;

    @Column(name = "departamento_id", nullable = true)
    private Integer departamentoId;

    @Column(name = "especialidad_id", nullable = true)
    private Integer especialidadId;

    @Column(name = "usuario_creacion", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = true)
    private Date fechaCreacion;

    @Column(name = "usuario_modificacion", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "fecha_modificacion", nullable = true)
    private Date fechaModificacion;

    @Column(name = "estado", nullable = true)
    private Integer estado;
}
