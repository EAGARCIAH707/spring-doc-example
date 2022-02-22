package com.andevs.springdoc.controller;

import com.andevs.springdoc.model.dto.ExampleDto;
import com.andevs.springdoc.model.enums.TypeEnum;
import com.andevs.springdoc.model.error.NotFoundResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IExampleController {

  @Tag(name = "Create example", description = "Servicio utilizado para crear un ejemplo")
  @ApiResponses(
      value = {
        @ApiResponse(
            description = "Cuando fue creado el recurso exitosamente",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = ExampleDto.class))),
        @ApiResponse(
            description = "Cuando no encuentra el recurso",
            responseCode = "404",
            content = @Content(schema = @Schema(implementation = NotFoundResponse.class)))
      })
  ResponseEntity<ExampleDto> postExample(@RequestBody ExampleDto exampleDto);

  @Tag(name = "Update example", description = "Servicio utilizado para actualizar un ejemplo")
  @ApiResponses(
      value = {
        @ApiResponse(
            description = "Cuando fue actualizado exitosamente",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ExampleDto.class))),
        @ApiResponse(
            description = "Cuando no encuentra el recurso",
            responseCode = "404",
            content = @Content(schema = @Schema(implementation = NotFoundResponse.class)))
      })
  ResponseEntity<ExampleDto> putExample(
      @RequestBody ExampleDto exampleDto,
      @Parameter(description = "Id del recurso") @PathVariable String exampleId);

  @Tag(name = "Delete example", description = "Servicio utilizado para eliminar un ejemplo")
  @ApiResponses(
      value = {
        @ApiResponse(
            description = "Cuando fue eliminado exitosamente",
            responseCode = "204",
            content = @Content(schema = @Schema())),
        @ApiResponse(
            description = "Cuando no encuentra el recurso",
            responseCode = "404",
            content = @Content(schema = @Schema(implementation = NotFoundResponse.class)))
      })
  ResponseEntity<ExampleDto> deleteExample(
      @RequestBody ExampleDto exampleDto,
      @Parameter(description = "Id del recurso", example = "ABADABA") @PathVariable
          String exampleId);

  @Tag(
      name = "Get All Examples",
      description = "Servicio utilizado para obtener todos los examples")
  @ApiResponses(
      value = {
        @ApiResponse(
            description = "Cuando fue fueron listados correctamente",
            responseCode = "200",
            content =
                @Content(
                    array = @ArraySchema(schema = @Schema(implementation = ExampleDto.class)))),
        @ApiResponse(
            description = "Cuando no encuentra ningun recurso",
            responseCode = "404",
            content = @Content(schema = @Schema(implementation = NotFoundResponse.class)))
      })
  ResponseEntity<List<ExampleDto>> getExamples(
      @Parameter(description = "Numero de pagina", example = "1") @RequestParam(name = "page")
          Integer page,
      @Parameter(description = "Cantidad de items por pagina", example = "100")
          @RequestParam(name = "pageSize")
          Integer pageSize);

  @Tag(
      name = "Find example by name",
      description = "Servicio utilizado para buscar un example por nombre")
  @ApiResponses(
      value = {
        @ApiResponse(
            description = "Cuando un example coincide con el nombre ingresado",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ExampleDto.class))),
        @ApiResponse(
            description = "Cuando no encuentra ningun recurso",
            responseCode = "404",
            content = @Content(schema = @Schema(implementation = NotFoundResponse.class)))
      })
  ResponseEntity<ExampleDto> findByName(@PathVariable TypeEnum typeEnum);
}
