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
 * RegistrarRequestOfertas
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-17T22:23:09.345Z")

public class RegistrarRequestOfertas   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("detalle")
  private String detalle = null;

  @JsonProperty("idnegocio")
  private String idnegocio = null;

  @JsonProperty("producto")
  private String producto = null;

  @JsonProperty("foto")
  private String foto = null;

  @JsonProperty("valor")
  private String valor = null;

  @JsonProperty("descuento")
  private String descuento = null;

  @JsonProperty("fechainicio")
  private String fechainicio = null;

  @JsonProperty("fechafinal")
  private String fechafinal = null;

  public RegistrarRequestOfertas id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RegistrarRequestOfertas detalle(String detalle) {
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

  public RegistrarRequestOfertas idnegocio(String idnegocio) {
    this.idnegocio = idnegocio;
    return this;
  }

  /**
   * Get idnegocio
   * @return idnegocio
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIdnegocio() {
    return idnegocio;
  }

  public void setIdnegocio(String idnegocio) {
    this.idnegocio = idnegocio;
  }

  public RegistrarRequestOfertas producto(String producto) {
    this.producto = producto;
    return this;
  }

  /**
   * Get producto
   * @return producto
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getProducto() {
    return producto;
  }

  public void setProducto(String producto) {
    this.producto = producto;
  }

  public RegistrarRequestOfertas foto(String foto) {
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

  public RegistrarRequestOfertas valor(String valor) {
    this.valor = valor;
    return this;
  }

  /**
   * Get valor
   * @return valor
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public RegistrarRequestOfertas descuento(String descuento) {
    this.descuento = descuento;
    return this;
  }

  /**
   * Get descuento
   * @return descuento
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDescuento() {
    return descuento;
  }

  public void setDescuento(String descuento) {
    this.descuento = descuento;
  }

  public RegistrarRequestOfertas fechainicio(String fechainicio) {
    this.fechainicio = fechainicio;
    return this;
  }

  /**
   * Get fechainicio
   * @return fechainicio
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFechainicio() {
    return fechainicio;
  }

  public void setFechainicio(String fechainicio) {
    this.fechainicio = fechainicio;
  }

  public RegistrarRequestOfertas fechafinal(String fechafinal) {
    this.fechafinal = fechafinal;
    return this;
  }

  /**
   * Get fechafinal
   * @return fechafinal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFechafinal() {
    return fechafinal;
  }

  public void setFechafinal(String fechafinal) {
    this.fechafinal = fechafinal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrarRequestOfertas registrarRequestOfertas = (RegistrarRequestOfertas) o;
    return Objects.equals(this.id, registrarRequestOfertas.id) &&
        Objects.equals(this.detalle, registrarRequestOfertas.detalle) &&
        Objects.equals(this.idnegocio, registrarRequestOfertas.idnegocio) &&
        Objects.equals(this.producto, registrarRequestOfertas.producto) &&
        Objects.equals(this.foto, registrarRequestOfertas.foto) &&
        Objects.equals(this.valor, registrarRequestOfertas.valor) &&
        Objects.equals(this.descuento, registrarRequestOfertas.descuento) &&
        Objects.equals(this.fechainicio, registrarRequestOfertas.fechainicio) &&
        Objects.equals(this.fechafinal, registrarRequestOfertas.fechafinal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, detalle, idnegocio, producto, foto, valor, descuento, fechainicio, fechafinal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrarRequestOfertas {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    detalle: ").append(toIndentedString(detalle)).append("\n");
    sb.append("    idnegocio: ").append(toIndentedString(idnegocio)).append("\n");
    sb.append("    producto: ").append(toIndentedString(producto)).append("\n");
    sb.append("    foto: ").append(toIndentedString(foto)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    descuento: ").append(toIndentedString(descuento)).append("\n");
    sb.append("    fechainicio: ").append(toIndentedString(fechainicio)).append("\n");
    sb.append("    fechafinal: ").append(toIndentedString(fechafinal)).append("\n");
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

