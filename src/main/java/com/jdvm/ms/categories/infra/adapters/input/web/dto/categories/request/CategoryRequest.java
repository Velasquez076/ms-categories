package com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

  private Long id;
  private String name;
}
