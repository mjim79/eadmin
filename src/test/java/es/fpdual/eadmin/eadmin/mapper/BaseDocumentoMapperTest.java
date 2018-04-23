package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.*;
import java.util.*;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

import es.fpdual.eadmin.eadmin.modelo.*;
import es.fpdual.eadmin.eadmin.util.*;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

    private Documento documento;

    @Autowired
    private DocumentoMapper mapper;

    @Before
    public void inicializarEnCadaTest() {
        this.documento = new Documento(1, "Documento 1", Utilidades.asDate(LocalDate.of(2015, 1, 1)),
                Utilidades.asDate(LocalDate.of(2015, 1, 2)), true, EstadoDocumento.ACTIVO);
    }

    @Test
    public void deberiaInsertarUnDocumento() throws Exception {
        final int resultado = this.mapper.insertarDocumento(this.documento);

        assertThat(resultado, is(1));
    }

    @Test
    public void deberiaEliminarUnDocumento() throws Exception {
        // DECLARACION

        // ENTRENAMIENTO
        this.mapper.insertarDocumento(this.documento);

        // PRUEBA
        final int resultado = this.mapper.eliminarDocumento(1);

        // VERIFICACIÓN
        assertThat(resultado, is(1));
    }

    @Test
    public void deberiaRecuperarUnDocumentoPorCodigo() throws Exception {
        // DECLARACION

        // ENTRENAMIENTO
        this.mapper.insertarDocumento(this.documento);

        // PRUEBA
        final Documento resultado = this.mapper.seleccionarDocumento(1);

        // VERIFICACIÓN
        assertThat(resultado, is(this.documento));
    }

    @Test
    public void deberiaActualizarTodosLosCamposDeUnDocumento() throws Exception {
        // DECLARACION
        final Documento documentoActualizado = new Documento(1, "Documento mod",
                Utilidades.asDate(LocalDate.of(2015, 2, 1)), Utilidades.asDate(LocalDate.of(2015, 2, 2)), false,
                EstadoDocumento.APROBADO);

        // ENTRENAMIENTO
        this.mapper.insertarDocumento(this.documento);

        // PRUEBA
        final int resultado = this.mapper.modificarDocumento(documentoActualizado);

        // VERIFICACIÓN
        assertThat(resultado, is(1));

        final Documento documentoModificado = this.mapper.seleccionarDocumento(1);
        assertThat(documentoModificado, is(documentoActualizado));
    }

    @Test
    public void deberiaRecuperarTodosLosDocumentos() throws Exception {
        // DECLARACION
        final Documento documento2 = new Documento(2, "Documento 2", Utilidades.asDate(LocalDate.of(2015, 2, 1)),
                Utilidades.asDate(LocalDate.of(2015, 2, 2)), false, EstadoDocumento.APROBADO);

        // ENTRENAMIENTO
        this.mapper.insertarDocumento(this.documento);
        this.mapper.insertarDocumento(documento2);

        // PRUEBA
        final List<Documento> resultado = this.mapper.seleccionarTodosLosDocumentos();

        // VERIFICACIÓN
        assertThat(resultado, hasSize(2));
        assertThat(resultado, hasItems(this.documento, documento2));
    }

    @Test
    public void deberiaObtener1CuandoNoHayElementosAlCalcularElMaximoCodigo() throws Exception {
        final int resultado = this.mapper.obtenerSiguienteIdentificador();

        assertThat(resultado, is(1));
    }

    @Test
    public void deberiaDevolverElSiguienteIdentificador() throws Exception {
        this.mapper.insertarDocumento(this.documento);

        final int resultado = this.mapper.obtenerSiguienteIdentificador();

        assertThat(resultado, is(2));
    }
}
