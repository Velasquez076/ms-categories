package com.jdvm.ms.categories.infra.adapters.input.web.mapper;

import org.mapstruct.Mapper;
import com.jdvm.ms.categories.domain.dto.CategoryDto;
import com.jdvm.ms.categories.domain.model.CategoryDomain;
import com.jdvm.ms.categories.domain.model.PageDomain;
import com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.request.CategoryRequest;
import com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.response.PageResponse;

/*
 * 
 */
@Mapper(componentModel = "spring")
public interface MapperRest {

  CategoryDomain toDomain(CategoryRequest categoryRequest);

  CategoryDto toDto(CategoryDomain categoryDomain);

  PageResponse<CategoryDto> toPageResponse(PageDomain<CategoryDomain> pageDomain);
}
