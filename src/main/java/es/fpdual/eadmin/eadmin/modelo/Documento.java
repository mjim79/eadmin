package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends ElementoBaseAdministracionElectronica {

	private final EstadoDocumento estado;
	
	
	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, publico);
		this.estado = estado;
	}
	
	public EstadoDocumento getEstado() {
		return estado;
	}
	
	@Override
	public String toString() {
		return "Documento con código " + codigo;
	}
	
	
	
}
