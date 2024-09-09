package com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

  private String uuid;
  private String status;
  private String message;
  private T content;
}
