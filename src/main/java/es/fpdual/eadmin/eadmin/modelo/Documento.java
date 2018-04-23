package es.fpdual.eadmin.eadmin.modelo;

import java.util.*;

import org.apache.commons.lang3.builder.*;

public class Documento extends ElementoBaseAdministracionElectronica {

    private final EstadoDocumento estado;

    public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
            EstadoDocumento estado) {
        super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion, publico);
        this.estado = estado;
    }

    public EstadoDocumento getEstado() {
        return this.estado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Documento) {
            final Documento param = (Documento)obj;
            final EqualsBuilder equalsBuilder = new EqualsBuilder();

            equalsBuilder.appendSuper(super.equals(param));
            equalsBuilder.append(this.estado, param.estado);

            return equalsBuilder.isEquals();
        }
        return false;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder.appendSuper(super.hashCode());
        hashCodeBuilder.append(this.estado);

        return hashCodeBuilder.toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
