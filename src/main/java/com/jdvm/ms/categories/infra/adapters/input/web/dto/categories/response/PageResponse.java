package com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/*
 * 
 */
@Setter
@Getter
public class PageResponse<T> {

  private List<T> content;
  private Integer pageNumber;
  private Integer pageSize;
  private Long totalElements;
  private Integer totalPages;
  private Integer offset;
  private Boolean paged;
  private Boolean unpaged;
  private Boolean last;
  private Integer size;
  private Integer number;
  private Boolean first;
  private Integer numberOfElements;
  private Boolean empty;
}
