package com.jdvm.ms.categories.infra.adapters.input.handler.dto;

import lombok.Builder;
import lombok.Getter;

/*
 * 
 */
@Getter
@Builder
public class ErrorDto {

  private int status;
  private String message;
}
