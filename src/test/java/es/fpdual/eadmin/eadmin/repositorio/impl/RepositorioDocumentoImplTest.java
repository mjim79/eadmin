package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.*;

import es.fpdual.eadmin.eadmin.mapper.*;
import es.fpdual.eadmin.eadmin.modelo.*;

public class RepositorioDocumentoImplTest {

    private static final Date FECHA_CREACION = new Date();

    private static final Date FECHA_ULTIMA_MODIFICACION = new Date();

    private static final String NOMBRE_DOCUMENTO = "nombre";

    private static final boolean DOCUMENTO_PUBLICO = true;

    private static final Integer CODIGO_DOCUMENTO = 1;

    private RepositorioDocumentoImpl repositorioDocumento;

    private DocumentoMapper mapper;

    private final Documento documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,
            FECHA_ULTIMA_MODIFICACION, DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);

    @Before
    public void inicializarEnCadaTest() {
        this.mapper = mock(DocumentoMapper.class);

        this.repositorioDocumento = new RepositorioDocumentoImpl(this.mapper);
    }

    @Test
    public void deberiaAlmacenarUnDocumento() {
        this.repositorioDocumento.altaDocumento(this.documento);

        verify(this.mapper).insertarDocumento(this.documento);
    }

    @Test
    public void deberiaModificarUnDocumento() {
        when(this.mapper.modificarDocumento(this.documento)).thenReturn(1);

        this.repositorioDocumento.modificarDocumento(this.documento);

        verify(this.mapper).modificarDocumento(this.documento);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deberiaLanzarExcepcionSiIntentamosModificarUnDocumentoQueNoExiste() {
        when(this.mapper.modificarDocumento(this.documento)).thenReturn(0);

        this.repositorioDocumento.modificarDocumento(this.documento);
    }

    @Test
    public void deberiaEliminarUnDocumento() {
        this.repositorioDocumento.eliminarDocumento(CODIGO_DOCUMENTO);

        verify(this.mapper).eliminarDocumento(CODIGO_DOCUMENTO);
    }

    @Test
    public void deberiaObtenerDocumentoPorCodigo() {
        when(this.mapper.seleccionarDocumento(CODIGO_DOCUMENTO)).thenReturn(this.documento);

        final Documento resultado = this.repositorioDocumento.obtenerDocumentoPorCodigo(CODIGO_DOCUMENTO);

        assertThat(resultado, is(this.documento));
    }

    @Test
    public void deberiaObtenerTodosLosDocumentos() throws Exception {
        // DECLARACION
        final List<Documento> todosLosDocumentos = Arrays.asList(this.documento);

        // ENTRENAMIENTO
        when(this.mapper.seleccionarTodosLosDocumentos()).thenReturn(todosLosDocumentos);

        // PRUEBA
        final List<Documento> resultado = this.repositorioDocumento.obtenerTodosLosDocumentos();

        // VERIFICACION
        assertThat(resultado, hasSize(1));
        assertThat(resultado, hasItem(this.documento));
    }

}
