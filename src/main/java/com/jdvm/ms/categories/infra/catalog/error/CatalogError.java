package com.jdvm.ms.categories.infra.catalog.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * 
 */
@Getter
@AllArgsConstructor
public enum CatalogError {

  CATEGORY_NOT_FOUND("Category not found"),
  MISSING_PARAM("The parameter '%s' is mandatory");

  private String message;
}
