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

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "genero", length = 45)
    private String genero;

    @Column(name = "especialidad")
    private Integer especialidad;

    @Column(name = "departamento", length = 45)
    private String departamento;

    @Column(name = "telefono", length = 45)
    private String telefono;

    @Column(name = "correo", length = 45)
    private String correo;

    @Column(name = "fecha_contratacion", nullable = false)
    private Date fechaContratacion;

    // Elimina nullable = false para permitir null
    @Column(name = "departamento_id")
    private Integer departamentoId;

    @Column(name = "especialidad_id")
    private Integer especialidadId;

    @Column(name = "usuario_creacion")
    private Integer usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
}
