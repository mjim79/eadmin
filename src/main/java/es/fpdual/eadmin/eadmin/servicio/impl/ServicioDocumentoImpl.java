package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	
	@Override
	public void altaDocumento(Documento documento) {
		
		repositorioDocumento.altaDocumento(documento);
		
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		
		final Documento documentoModificado = 
				obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.modificarDocumento(documentoModificado);
		
		return documentoModificado;
	}

	
	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
		
	}

	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento) {		
		
		return new DocumentoBuilder().clonar(documento).
				conFechaCreacion(dameFechaActual()).
				construir();
	}

	protected Date dameFechaActual() {

		return new Date();
	}

	
}
