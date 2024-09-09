package com.jdvm.ms.categories.application.usecase;

import org.springframework.stereotype.Service;
import com.jdvm.ms.categories.application.ports.input.CategoryService;
import com.jdvm.ms.categories.application.ports.output.CategoryPersistence;
import com.jdvm.ms.categories.domain.exception.NotFoundCategoryException;
import com.jdvm.ms.categories.domain.model.CategoryDomain;
import com.jdvm.ms.categories.domain.model.PageDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@Service
@RequiredArgsConstructor
class CategoryUseCase implements CategoryService {

  private final CategoryPersistence categoryPersistence;

  @Override
  public CategoryDomain createCategory(CategoryDomain categoryDomain) {
    log.info(".:: Init create category...");
    return categoryPersistence.save(categoryDomain);
  }

  @Override
  public CategoryDomain getCategoryById(Long id) {
    log.info(".:: Consulting category by id {} ::.", id);
    return categoryPersistence.getCategoryById(id).orElseThrow(NotFoundCategoryException::new);
  }

  @Override
  public PageDomain<CategoryDomain> categoryPageable(int page, int quantity, String orientation) {
    log.info("Query pageable");
    return categoryPersistence.getPageableCategory(page, quantity, orientation);
  }
}
