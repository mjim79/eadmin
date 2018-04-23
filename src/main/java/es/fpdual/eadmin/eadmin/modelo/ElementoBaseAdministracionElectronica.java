package es.fpdual.eadmin.eadmin.modelo;

import java.util.*;

import org.apache.commons.lang3.builder.*;

public abstract class ElementoBaseAdministracionElectronica {

    protected final Integer codigo;

    protected final String nombre;

    protected final Date fechaCreacion;

    protected final Date fechaUltimaActualizacion;

    protected final Boolean publico;

    public ElementoBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion,
            Date fechaUltimaActualizacion, Boolean publico) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.publico = publico;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public Date getFechaUltimaActualizacion() {
        return this.fechaUltimaActualizacion;
    }

    public Boolean getPublico() {
        return this.publico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ElementoBaseAdministracionElectronica) {
            final ElementoBaseAdministracionElectronica param = (ElementoBaseAdministracionElectronica)obj;
            final EqualsBuilder equalsBuilder = new EqualsBuilder();

            equalsBuilder.append(this.codigo, param.codigo);
            equalsBuilder.append(this.nombre, param.nombre);
            equalsBuilder.append(this.fechaCreacion, param.fechaCreacion);
            equalsBuilder.append(this.fechaUltimaActualizacion, param.fechaUltimaActualizacion);
            equalsBuilder.append(this.publico, param.publico);

            return equalsBuilder.isEquals();
        }
        return false;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder.append(this.codigo);
        hashCodeBuilder.append(this.nombre);
        hashCodeBuilder.append(this.fechaCreacion);
        hashCodeBuilder.append(this.fechaUltimaActualizacion);
        hashCodeBuilder.append(this.publico);

        return hashCodeBuilder.toHashCode();
    }

}
