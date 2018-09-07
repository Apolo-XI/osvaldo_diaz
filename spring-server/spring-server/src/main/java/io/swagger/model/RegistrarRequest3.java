package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RegistrarRequest3
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-25T19:46:33.644Z")

@DynamoDBTable(tableName="Personas")
public class RegistrarRequest3 {

	 @JsonProperty("correo")
	 private String correo = null;
	  
	 @JsonProperty("contrasena")
	 private String contrasena = null;
	 
		  /**
		   * Get contrasena
		   * @return contrasena
		  **/
		  @ApiModelProperty(required = true, value = "")

		  @DynamoDBAttribute
		  public String getcontrasena() {
		    return contrasena;
		  }

		  public void setcontrasena(String contrasena) {
		    this.contrasena = contrasena;
		  }
		  
		  public RegistrarRequest3 correo(String correo) {
			    this.correo = correo;
			    return this;
			  }
		  
		  /**
		   * Get correo
		   * @return correo
		  **/
		  @ApiModelProperty(value = "")

		  @DynamoDBAttribute
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
		    RegistrarRequest3 registrarRequest = (RegistrarRequest3) o;
		    return   Objects.equals(this.correo, registrarRequest.correo) &&
		        Objects.equals(this.contrasena, registrarRequest.contrasena);
		  }

		  @Override
		  public int hashCode() {
		    return Objects.hash(correo, contrasena);
		  }

		  @Override
		  public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append("class RegistrarRequest {\n");		    
		    sb.append("    contrasena: ").append(toIndentedString(contrasena)).append("\n");
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
