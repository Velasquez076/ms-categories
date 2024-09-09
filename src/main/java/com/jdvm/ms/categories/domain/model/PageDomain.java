package com.jdvm.ms.categories.domain.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Object type of content
 * 
 * @param <T>
 */
@Setter
@Getter
public class PageDomain<T> {

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
