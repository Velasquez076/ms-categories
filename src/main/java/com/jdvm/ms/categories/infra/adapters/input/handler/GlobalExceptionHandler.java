package com.jdvm.ms.categories.infra.adapters.input.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.jdvm.ms.categories.domain.exception.NotFoundCategoryException;
import com.jdvm.ms.categories.infra.adapters.input.handler.dto.ErrorDto;
import com.jdvm.ms.categories.infra.catalog.error.CatalogError;
import lombok.extern.slf4j.Slf4j;

/*
 * 
 */
@Slf4j
@RestControllerAdvice
class GlobalExceptionHandler {

  @ExceptionHandler({NotFoundCategoryException.class})
  ResponseEntity<ErrorDto> notFoundException(NotFoundCategoryException ex) {
    log.error("{}", ex.getMessage(), ex);
    var error = ErrorDto.builder().status(HttpStatus.NOT_FOUND.value())
        .message(CatalogError.CATEGORY_NOT_FOUND.getMessage()).build();
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({MissingServletRequestParameterException.class})
  ResponseEntity<ErrorDto> missingParameter(MissingServletRequestParameterException ex) {
    log.error("{}", ex.getMessage(), ex);
    var error = ErrorDto.builder()
        .message(String.format(CatalogError.MISSING_PARAM.getMessage(), ex.getParameterName()))
        .build();
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
