package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import java.util.List;

public class Expediente {
	
	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaArchivado;
	private Boolean publico;
	private EstadoExpediente estado;
	
	private List<Documento> documentos;

	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Date fechaArchivado, Boolean publico,
			EstadoExpediente estado, List<Documento> documentos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaArchivado = fechaArchivado;
		this.publico = publico;
		this.estado = estado;
		this.documentos = documentos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public int hashCode() {
		return codigo.hashCode() + nombre.hashCode() + fechaCreacion.hashCode() + fechaArchivado.hashCode() + publico.hashCode() + estado.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Expediente) {
			final Expediente expediente = (Expediente) obj;
			return expediente.getCodigo().equals(this.codigo) && expediente.getNombre().equals(this.nombre)
						&& expediente.getFechaCreacion().equals(this.fechaCreacion) && expediente.getFechaArchivado().equals(this.fechaArchivado)
						&& expediente.getPublico().equals(this.publico) && expediente.getEstado().equals(this.estado);
		}

		return false;

	}
}
