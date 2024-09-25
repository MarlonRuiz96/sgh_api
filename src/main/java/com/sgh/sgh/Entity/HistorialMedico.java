package com.sgh.sgh.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "historial_medico")
public class HistorialMedico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historial")
	private Integer idHistorial;

	@Column(name = "fecha_consulta", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaConsulta;

	@Column(name = "tratamiento", columnDefinition = "TEXT")
	private String tratamiento;

	@Column(name = "notas", columnDefinition = "TEXT")
	private String notas;

	@Column(name = "paciente_id", nullable = false)
	private Integer pacienteId;

	@Column(name = "personal_medico_id", nullable = false)
	private Integer personalMedicoId;

	@Column(name = "usuario_creacion", nullable = false)
	private Integer usuarioCreacion;

	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Column(name = "usuario_modificacion")
	private Integer usuarioModificacion;

	@Column(name = "fecha_modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

}
