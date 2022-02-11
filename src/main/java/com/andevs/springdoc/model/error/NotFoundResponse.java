package com.andevs.springdoc.model.error;

import lombok.Data;

@Data
public class NotFoundResponse {
  private Integer status;
  private String message;
}
