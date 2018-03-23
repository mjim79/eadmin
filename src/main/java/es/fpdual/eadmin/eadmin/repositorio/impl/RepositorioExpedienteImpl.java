package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class RepositorioExpedienteImpl implements RepositorioExpediente {

	private List<Expediente> expedientes = new ArrayList<>();
	
	@Override
	public void altaExpediente(Expediente expediente) {
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya existe");
		}
		
		expedientes.add(expediente);
		
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}
		
		expedientes.set(expedientes.indexOf(expediente), expediente);
	}

	@Override
	public void eliminarExpediente(Integer codigoExpediente) {
		Optional<Expediente> expedienteEncontrado = 
				expedientes.stream().
					filter(d -> tieneIgualCodigo(d, codigoExpediente)).
					findFirst();

		if (expedienteEncontrado.isPresent()) {
			expedientes.remove(expedienteEncontrado.get());
		}
		
	}

	
	@Override
	public void asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		
	}

	@Override
	public void desasociarDocumentoDelExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		
	}

	protected boolean tieneIgualCodigo(Expediente expediente, Integer codigoExpediente) {
		return expediente.getCodigo().equals(codigoExpediente);
	}

}
