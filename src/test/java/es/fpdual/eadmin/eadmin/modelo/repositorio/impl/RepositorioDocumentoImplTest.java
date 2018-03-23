package es.fpdual.eadmin.eadmin.modelo.repositorio.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import org.junit.Assert.*;

public class RepositorioDocumentoImplTest {

	private RepositorioDocumentoImpl repositorioDocumento;
	
	private static final Documento DOCUMENTO = new Documento(1,"nombre", new Date(), true, EstadoDocumento.ACTIVO);
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioDocumento = new RepositorioDocumentoImpl();
	}
	
	
	@Test
	public void deberiaEliminarUnDocumento() {
		
		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	
	@Test
	public void deberiaNoEliminarDocumentoSiNoExiste() {
		
		
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
}
