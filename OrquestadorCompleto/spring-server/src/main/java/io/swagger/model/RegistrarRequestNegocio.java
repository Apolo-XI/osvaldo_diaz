package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RegistrarRequestNegocio
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-17T22:23:09.345Z")

public class RegistrarRequestNegocio   {
  @JsonProperty("idnegocio")
  private String idnegocio = null;

  @JsonProperty("idadmin")
  private String idadmin = null;

  @JsonProperty("nombre_negocio")
  private String nombreNegocio = null;

  @JsonProperty("nit")
  private String nit = null;

  @JsonProperty("telefono")
  private String telefono = null;

  @JsonProperty("correo")
  private String correo = null;

  @JsonProperty("tipo")
  private String tipo = null;

  @JsonProperty("foto")
  private String foto = null;

  @JsonProperty("ubicacion")
  private String ubicacion = null;

  @JsonProperty("detalle")
  private String detalle = null;

  public RegistrarRequestNegocio idnegocio(String idnegocio) {
    this.idnegocio = idnegocio;
    return this;
  }

  /**
   * Get idnegocio
   * @return idnegocio
  **/
  @ApiModelProperty(required = true, value = "")
  @Null


  public String getIdnegocio() {
    return idnegocio;
  }

  public void setIdnegocio(String idnegocio) {
    this.idnegocio = idnegocio;
  }

  public RegistrarRequestNegocio idadmin(String idadmin) {
    this.idadmin = idadmin;
    return this;
  }

  /**
   * Get idadmin
   * @return idadmin
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIdadmin() {
    return idadmin;
  }

  public void setIdadmin(String idadmin) {
    this.idadmin = idadmin;
  }

  public RegistrarRequestNegocio nombreNegocio(String nombreNegocio) {
    this.nombreNegocio = nombreNegocio;
    return this;
  }

  /**
   * Get nombreNegocio
   * @return nombreNegocio
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNombreNegocio() {
    return nombreNegocio;
  }

  public void setNombreNegocio(String nombreNegocio) {
    this.nombreNegocio = nombreNegocio;
  }

  public RegistrarRequestNegocio nit(String nit) {
    this.nit = nit;
    return this;
  }

  /**
   * Get nit
   * @return nit
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNit() {
    return nit;
  }

  public void setNit(String nit) {
    this.nit = nit;
  }

  public RegistrarRequestNegocio telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public RegistrarRequestNegocio correo(String correo) {
    this.correo = correo;
    return this;
  }

  /**
   * Get correo
   * @return correo
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public RegistrarRequestNegocio tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public RegistrarRequestNegocio foto(String foto) {
    this.foto = foto;
    return this;
  }

  /**
   * Get foto
   * @return foto
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public RegistrarRequestNegocio ubicacion(String ubicacion) {
    this.ubicacion = ubicacion;
    return this;
  }

  /**
   * Get ubicacion
   * @return ubicacion
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public RegistrarRequestNegocio detalle(String detalle) {
    this.detalle = detalle;
    return this;
  }

  /**
   * Get detalle
   * @return detalle
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrarRequestNegocio registrarRequestNegocio = (RegistrarRequestNegocio) o;
    return Objects.equals(this.idnegocio, registrarRequestNegocio.idnegocio) &&
        Objects.equals(this.idadmin, registrarRequestNegocio.idadmin) &&
        Objects.equals(this.nombreNegocio, registrarRequestNegocio.nombreNegocio) &&
        Objects.equals(this.nit, registrarRequestNegocio.nit) &&
        Objects.equals(this.telefono, registrarRequestNegocio.telefono) &&
        Objects.equals(this.correo, registrarRequestNegocio.correo) &&
        Objects.equals(this.tipo, registrarRequestNegocio.tipo) &&
        Objects.equals(this.foto, registrarRequestNegocio.foto) &&
        Objects.equals(this.ubicacion, registrarRequestNegocio.ubicacion) &&
        Objects.equals(this.detalle, registrarRequestNegocio.detalle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idnegocio, idadmin, nombreNegocio, nit, telefono, correo, tipo, foto, ubicacion, detalle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrarRequestNegocio {\n");
    
    sb.append("    idnegocio: ").append(toIndentedString(idnegocio)).append("\n");
    sb.append("    idadmin: ").append(toIndentedString(idadmin)).append("\n");
    sb.append("    nombreNegocio: ").append(toIndentedString(nombreNegocio)).append("\n");
    sb.append("    nit: ").append(toIndentedString(nit)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    correo: ").append(toIndentedString(correo)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    foto: ").append(toIndentedString(foto)).append("\n");
    sb.append("    ubicacion: ").append(toIndentedString(ubicacion)).append("\n");
    sb.append("    detalle: ").append(toIndentedString(detalle)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

