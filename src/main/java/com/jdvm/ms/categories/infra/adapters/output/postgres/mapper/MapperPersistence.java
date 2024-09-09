package com.jdvm.ms.categories.infra.adapters.output.postgres.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import com.jdvm.ms.categories.domain.model.CategoryDomain;
import com.jdvm.ms.categories.domain.model.PageDomain;
import com.jdvm.ms.categories.infra.adapters.output.postgres.entity.CategoryEntity;

/*
 * 
 */
@Mapper(componentModel = "spring")
public interface MapperPersistence {

  CategoryDomain toDomain(CategoryEntity categoryEntity);

  CategoryEntity toEntity(CategoryDomain categoryDomain);

  @Mapping(target = "pageNumber", source = "page.pageable.pageNumber")
  @Mapping(target = "pageSize", source = "page.pageable.pageSize")
  @Mapping(target = "offset", source = "page.pageable.offset")
  @Mapping(target = "paged", source = "page.pageable.paged")
  @Mapping(target = "unpaged", source = "page.pageable.unpaged")
  PageDomain<CategoryDomain> toPageDomain(Page<CategoryEntity> page);
}
