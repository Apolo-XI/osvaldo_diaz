package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RegistrarRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-17T21:36:33.675Z")

@DynamoDBTable(tableName="Ofertas")
public class RegistrarRequest   {
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
  
  //
	@JsonProperty("latitud")
	private String latitud = null;
	
	@JsonProperty("longitud")
	private String longitud = null;
	
	@JsonProperty("tipo")
	private String tipo = null;
//

  @JsonProperty("valor")
  private String valor = null;

  @JsonProperty("descuento")
  private String descuento = null;

  @JsonProperty("fechainicio")
  private String fechainicio = null;

  @JsonProperty("fechafinal")
  private String fechafinal = null;

  public RegistrarRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @DynamoDBHashKey
  @DynamoDBAutoGeneratedKey
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RegistrarRequest detalle(String detalle) {
    this.detalle = detalle;
    return this;
  }

  /**
   * Get detalle
   * @return detalle
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public RegistrarRequest idnegocio(String idnegocio) {
    this.idnegocio = idnegocio;
    return this;
  }

  /**
   * Get idnegocio
   * @return idnegocio
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getIdnegocio() {
    return idnegocio;
  }

  public void setIdnegocio(String idnegocio) {
    this.idnegocio = idnegocio;
  }

  public RegistrarRequest producto(String producto) {
    this.producto = producto;
    return this;
  }

  /**
   * Get producto
   * @return producto
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getProducto() {
    return producto;
  }

  public void setProducto(String producto) {
    this.producto = producto;
  }

  public RegistrarRequest foto(String foto) {
    this.foto = foto;
    return this;
  }

  /**
   * Get foto
   * @return foto
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

//  public RegistrarRequest valor(String valor) {
//    this.valor = valor;
//    return this;
//  }
  
  
   
   public RegistrarRequest latitud(String latitud) {
    this.latitud = latitud;
    return this;
  }

   /**
   * Get latitud
   * @return latitud
   **/
   
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public RegistrarRequest longitud(String longitud) {
    this.longitud = longitud;
    return this;
  }
  
   /**
  *Get Longitud
  *@return longitud
   **/
  
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }
  
  public RegistrarRequest tipo (String tipo) {
	    this.tipo = tipo;
	    return this;
	  }
  
  /**
   *Get Tipo
   *@return tipo
    **/
   
   @ApiModelProperty(required = true, value = "")
   @NotNull

   @DynamoDBAttribute
   public String getTipo() {
     return tipo;
   }

   public void setTipo(String tipo) {
     this.tipo = tipo;
   }

  public RegistrarRequest valor(String valor) {
    this.valor = valor;
    return this;
  }
  
  /**
   * Get valor
   * @return valor
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public RegistrarRequest descuento(String descuento) {
    this.descuento = descuento;
    return this;
  }

  /**
   * Get descuento
   * @return descuento
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getDescuento() {
    return descuento;
  }

  public void setDescuento(String descuento) {
    this.descuento = descuento;
  }

  public RegistrarRequest fechainicio(String fechainicio) {
    this.fechainicio = fechainicio;
    return this;
  }

  /**
   * Get fechainicio
   * @return fechainicio
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getFechainicio() {
    return fechainicio;
  }

  public void setFechainicio(String fechainicio) {
    this.fechainicio = fechainicio;
  }

  public RegistrarRequest fechafinal(String fechafinal) {
    this.fechafinal = fechafinal;
    return this;
  }

  /**
   * Get fechafinal
   * @return fechafinal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
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
    RegistrarRequest registrarRequest = (RegistrarRequest) o;
    return Objects.equals(this.id, registrarRequest.id) &&
        Objects.equals(this.detalle, registrarRequest.detalle) &&
        Objects.equals(this.idnegocio, registrarRequest.idnegocio) &&
        Objects.equals(this.producto, registrarRequest.producto) &&
        Objects.equals(this.foto, registrarRequest.foto) &&
        Objects.equals(this.latitud, registrarRequest.latitud) &&
        Objects.equals(this.longitud, registrarRequest.longitud) &&
        Objects.equals(this.valor, registrarRequest.valor) &&
        Objects.equals(this.descuento, registrarRequest.descuento) &&
        Objects.equals(this.fechainicio, registrarRequest.fechainicio) &&
        Objects.equals(this.fechafinal, registrarRequest.fechafinal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, detalle, idnegocio, producto, foto, latitud, longitud, valor, descuento, fechainicio, fechafinal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrarRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    detalle: ").append(toIndentedString(detalle)).append("\n");
    sb.append("    idnegocio: ").append(toIndentedString(idnegocio)).append("\n");
    sb.append("    producto: ").append(toIndentedString(producto)).append("\n");
    sb.append("    foto: ").append(toIndentedString(foto)).append("\n");
    sb.append("    latitud: ").append(toIndentedString(latitud)).append("\n");
    sb.append("    longitud: ").append(toIndentedString(longitud)).append("\n");
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

