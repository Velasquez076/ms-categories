package com.jdvm.ms.categories.infra.catalog.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 */
@Getter
@AllArgsConstructor
public enum MessagesEnum {

  CREATE_SUCCESS(9201, "Create Successfuly"), 
  QUERY_SUCCESS(9200, "Successful query"),
  QUERY_PAGEABLE_SUCCESS(9200, "Successful query pageable");

  private int statusCode;
  private String message;
}
