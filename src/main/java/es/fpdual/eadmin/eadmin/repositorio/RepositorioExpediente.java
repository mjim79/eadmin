package es.fpdual.eadmin.eadmin.repositorio;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	void altaExpediente(Expediente expediente);

	void modificarExpediente(Expediente expediente);

	void eliminarExpediente(Integer codigoExpediente);
	
	void asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento);
	
	void desasociarDocumentoDelExpediente (Integer codigoExpediente, Integer codigoDocumento);
}
