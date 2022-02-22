package com.andevs.springdoc.controller.impl;

import com.andevs.springdoc.controller.IExampleController;
import com.andevs.springdoc.model.dto.ExampleDto;
import com.andevs.springdoc.model.enums.TypeEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class ExampleController implements IExampleController {

  @PostMapping("/examples")
  public ResponseEntity<ExampleDto> postExample(@RequestBody ExampleDto exampleDto) {

    return ResponseEntity.ok(exampleDto);
  }

  @PutMapping("/examples/{exampleId}")
  public ResponseEntity<ExampleDto> putExample(
      @RequestBody ExampleDto exampleDto, @PathVariable String exampleId) {

    return ResponseEntity.ok(exampleDto);
  }

  @DeleteMapping("/examples/{exampleId}")
  public ResponseEntity<ExampleDto> deleteExample(
      @RequestBody ExampleDto exampleDto, @PathVariable String exampleId) {

    return ResponseEntity.ok(exampleDto);
  }

  @GetMapping("/examples")
  public ResponseEntity<List<ExampleDto>> getExamples(
      @RequestParam(name = "page") Integer page,
      @RequestParam(name = "pageSize") Integer pageSize) {

    return ResponseEntity.ok(new ArrayList<>());
  }

  @Override
  @GetMapping("/examples/name/{typeEnum}")
  public ResponseEntity<ExampleDto> findByName(TypeEnum typeEnum) {
    return ResponseEntity.ok(new ExampleDto());
  }
}
