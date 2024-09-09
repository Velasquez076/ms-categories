package com.jdvm.ms.categories.infra.adapters.input.web;

import static com.jdvm.ms.categories.infra.adapters.input.web.constants.Constants.CREATE;
import static com.jdvm.ms.categories.infra.adapters.input.web.constants.Constants.ID;
import static com.jdvm.ms.categories.infra.adapters.input.web.constants.Constants.ORIENTATION;
import static com.jdvm.ms.categories.infra.adapters.input.web.constants.Constants.PAGE;
import static com.jdvm.ms.categories.infra.adapters.input.web.constants.Constants.PAGEABLE;
import static com.jdvm.ms.categories.infra.adapters.input.web.constants.Constants.QUANTITY;
import static com.jdvm.ms.categories.infra.adapters.input.web.constants.Constants.RESOURCE_CATEGORY;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jdvm.ms.categories.application.ports.input.CategoryService;
import com.jdvm.ms.categories.domain.dto.CategoryDto;
import com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.request.CategoryRequest;
import com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.response.BaseResponse;
import com.jdvm.ms.categories.infra.adapters.input.web.dto.categories.response.PageResponse;
import com.jdvm.ms.categories.infra.adapters.input.web.mapper.MapperRest;
import com.jdvm.ms.categories.infra.catalog.messages.MessagesEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RESOURCE_CATEGORY)
class CategoryController {

  private final CategoryService categoryService;
  private final MapperRest mapperRest;

  /*
   * 
   */
  @PostMapping(path = CREATE, consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<BaseResponse<CategoryDto>> createCategory(
      @RequestBody CategoryRequest categoryRequest) {
    log.info(".:: Creating ...");

    var domain = categoryService.createCategory(mapperRest.toDomain(categoryRequest));
    var response = new BaseResponse<CategoryDto>(UUID.randomUUID().toString(),
        String.valueOf(MessagesEnum.CREATE_SUCCESS.getStatusCode()),
        MessagesEnum.CREATE_SUCCESS.getMessage(), mapperRest.toDto(domain));
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  /*
   * 
   */
  @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<BaseResponse<CategoryDto>> getCategoryById(@PathVariable(name = ID) Long id) {

    log.info("Querying category by id ...");
    var domain = categoryService.getCategoryById(id);
    var response = new BaseResponse<CategoryDto>(UUID.randomUUID().toString(),
        String.valueOf(MessagesEnum.QUERY_SUCCESS.getStatusCode()),
        MessagesEnum.QUERY_SUCCESS.getMessage(), mapperRest.toDto(domain));
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /*
   * 
   */
  @GetMapping(path = PAGEABLE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<BaseResponse<PageResponse<CategoryDto>>> getPageable(
      @RequestParam(name = PAGE, required = true) Integer page,
      @RequestParam(name = QUANTITY, required = true) Integer quantity,
      @RequestParam(name = ORIENTATION, required = true) String orientation) {
    log.info("Query in pageable...");
    var pageResponse = categoryService.categoryPageable(page, quantity, orientation);
    var response = new BaseResponse<PageResponse<CategoryDto>>(UUID.randomUUID().toString(),
        String.valueOf(MessagesEnum.QUERY_PAGEABLE_SUCCESS.getStatusCode()),
        MessagesEnum.QUERY_PAGEABLE_SUCCESS.getMessage(), mapperRest.toPageResponse(pageResponse));
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
