package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RegistrarRequest2
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-25T19:46:33.644Z")


public class RegistrarRequest2 {

	 @JsonProperty("id")
	 private String id = null;
	
	 @JsonProperty("rol")
	 private String rol = null;

	 @JsonProperty("estado")
	 private String estado = null;
	 
	 @JsonProperty("correo")
	 private String correo = null;
	  
	 @JsonProperty("token")
	 private String token = null;
	 
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

	  public RegistrarRequest2 rol(String rol) {
		    this.rol = rol;
		    return this;
		  }

		  /**
		   * Get rol
		   * @return rol
		  **/
		  @ApiModelProperty(required = true, value = "")
		  @NotNull

		  
		  public String getRol() {
		    return rol;
		  }

		  public void setRol(String rol) {
		    this.rol = rol;
		  }

		  public RegistrarRequest2 estado(String estado) {
		    this.estado = estado;
		    return this;
		  }

		  /**
		   * Get estado
		   * @return estado
		  **/
		  @ApiModelProperty(required = true, value = "")

		
		  public String getEstado() {
		    return estado;
		  }

		  public void setEstado(String estado) {
		    this.estado = estado;
		  }
		  
		  public RegistrarRequest2 token(String token) {
			    this.token = token;
			    return this;
			  }

		  /**
		   * Get token
		   * @return token
		  **/
		  @ApiModelProperty(value = "")

		 
		  public String gettoken() {
		    return token;
		  }

		  public void settoken(String token) {
		    this.token = token;
		  }
		  
		  public RegistrarRequest2 correo(String correo) {
			    this.correo = correo;
			    return this;
			  }
		  
		  /**
		   * Get correo
		   * @return correo
		  **/
		  @ApiModelProperty(value = "")

		 
		  public String getcorreo() {
		    return correo;
		  }

		  public void setcorreo(String correo) {
		    this.correo = correo;
		  }
		  
		  @Override
		  public boolean equals(java.lang.Object o) {
		    if (this == o) {
		      return true;
		    }
		    if (o == null || getClass() != o.getClass()) {
		      return false;
		    }
		    RegistrarRequest2 registrarRequest = (RegistrarRequest2) o;
		    return Objects.equals(this.id, registrarRequest.id) &&
		        Objects.equals(this.rol, registrarRequest.rol) &&
		        Objects.equals(this.estado, registrarRequest.estado) &&
		        Objects.equals(this.correo, registrarRequest.correo) &&
		        Objects.equals(this.token, registrarRequest.token);
		  }

		  @Override
		  public int hashCode() {
		    return Objects.hash(id, rol, estado, correo, token);
		  }

		  @Override
		  public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append("class RegistrarRequest {\n");		    
		    sb.append("    id: ").append(toIndentedString(id)).append("\n");
		    sb.append("    rol: ").append(toIndentedString(rol)).append("\n");
		    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
		    sb.append("    token: ").append(toIndentedString(token)).append("\n");
		    sb.append("    correo: ").append(toIndentedString(correo)).append("\n");
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
