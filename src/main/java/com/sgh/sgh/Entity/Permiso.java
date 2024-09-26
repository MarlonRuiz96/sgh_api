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
@Table(name = "permiso")
public class Permiso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	public String disponible;
	public String rol_id;
	public int modulo_id;
	public int usuario_creador;
	public String fecha_creacion;
	public Date usuario_modificacion;
	public Date fecha_modificacion;
}