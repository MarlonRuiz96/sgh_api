package dao;

import java.util.Date;
import java.util.List;

import entity.Bitacora;

public interface IDaoBitacora {
	public List<Bitacora> findAll();
	public List<Bitacora> SelectBitacora(String accion, 
										 int modulo, 
										 int usuario, 
										 Date fechaIni, 
										 Date fechaFin);
	public Bitacora agregarRegistro(Bitacora bitacora);
}
