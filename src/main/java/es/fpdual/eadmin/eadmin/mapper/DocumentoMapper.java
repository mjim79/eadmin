package es.fpdual.eadmin.eadmin.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import es.fpdual.eadmin.eadmin.modelo.*;

public interface DocumentoMapper {

    int insertarDocumento(@Param("documento") Documento documento);

    int eliminarDocumento(@Param("codigo") int codigo);

    int modificarDocumento(@Param("documento") Documento documento);

    Documento seleccionarDocumento(@Param("codigo") int codigo);

    List<Documento> seleccionarTodosLosDocumentos();

    int obtenerSiguienteIdentificador();

}
