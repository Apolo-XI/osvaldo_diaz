package io.swagger.model;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;



/**
 * JsonApiBodyRequest4
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-25T19:46:33.644Z")

public class JsonApiBodyRequest4   {
  @JsonProperty("persona")
  @Valid
  private List<RegistrarRequest> persona;

  public JsonApiBodyRequest4 persona(List<RegistrarRequest> persona) {
    this.persona = persona;
    return this;
  }

  public JsonApiBodyRequest4 addPersonaItem(RegistrarRequest personaItem) {
    this.persona.add(personaItem);
    return this;
  }

  /**
   * Get persona
   * @return persona
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<RegistrarRequest> getPersona() {
    return persona;
  }

  public void setPersona(List<RegistrarRequest> persona) {
    this.persona = persona;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonApiBodyRequest4 JsonApiBodyRequest4 = (JsonApiBodyRequest4) o;
    return Objects.equals(this.persona, JsonApiBodyRequest4.persona);
  }

  @Override
  public int hashCode() {
    return Objects.hash(persona);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonApiBodyRequest4 {\n");
    
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
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
