package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import es.fpdual.eadmin.eadmin.mapper.*;
import es.fpdual.eadmin.eadmin.modelo.*;
import es.fpdual.eadmin.eadmin.repositorio.*;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

    private DocumentoMapper mapper;

    @Autowired
    public RepositorioDocumentoImpl(DocumentoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void altaDocumento(Documento documento) {
        this.mapper.insertarDocumento(documento);
    }

    @Override
    public void modificarDocumento(Documento documento) {
        final int modificado = this.mapper.modificarDocumento(documento);

        if (modificado == 0) {
            throw new IllegalArgumentException("No se encuentra el documento");
        }
    }

    @Override
    public void eliminarDocumento(Integer codigo) {
        this.mapper.eliminarDocumento(codigo);
    }

    @Override
    public Documento obtenerDocumentoPorCodigo(Integer codigo) {
        return this.mapper.seleccionarDocumento(codigo);
    }

    @Override
    public List<Documento> obtenerTodosLosDocumentos() {
        return this.mapper.seleccionarTodosLosDocumentos();
    }

}
