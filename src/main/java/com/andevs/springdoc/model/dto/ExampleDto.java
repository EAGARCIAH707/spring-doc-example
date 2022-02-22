package com.andevs.springdoc.model.dto;

import com.andevs.springdoc.model.enums.TypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
public class ExampleDto {

  private String name;

  @Schema(description = "Esto es una descripcion de campo", required = true)
  private String lastName;

  @Schema(minLength = 1, maxLength = 100)
  private Integer age;

  @Schema(example = "eagarciah@707@gmail.com", format = "xxxxx@xxx.com")
  private String email;

  @Schema(nullable = true, description = "Este campo puede ser nulo")
  private Map<String, Object> optional;

  @Schema(deprecated = true, description = "Este campo pronto dejará de usarse")
  private String deprecatedField;

  private TypeEnum typeDoc;
}
