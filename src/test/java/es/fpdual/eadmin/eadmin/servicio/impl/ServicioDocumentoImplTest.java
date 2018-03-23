package es.fpdual.eadmin.eadmin.servicio.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;


public class ServicioDocumentoImplTest {
	
	private ServicioDocumento servicioDocumento;
	
	private static final Documento DOCUMENTO = mock(Documento.class);
	
	private final RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	
	@Before
	public void inicializarEnCadaTest() {
		
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento() {
		
		this.servicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(DOCUMENTO);
		
	
	}
	
	@Test
	public void deberiaModificarDocumento() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(1/1/2018));
		when(DOCUMENTO.getNombre()).thenReturn("nombre");
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).modificarDocumento(any());
		assertEquals(Integer.valueOf(1), resultado.getCodigo());
		assertEquals("nombre", resultado.getNombre());
		assertNotEquals(resultado.getFechaCreacion(), DOCUMENTO.getFechaCreacion());
	}
	
	@Test
	public void deberiaEliminarDocumento() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}

}
