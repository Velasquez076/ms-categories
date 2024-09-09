package com.jdvm.ms.categories.application.ports.output;

import java.util.Optional;
import com.jdvm.ms.categories.domain.model.CategoryDomain;
import com.jdvm.ms.categories.domain.model.PageDomain;

/*
 * 
 */
public interface CategoryPersistence {

  CategoryDomain save(CategoryDomain categoryDomain);

  Optional<CategoryDomain> getCategoryById(Long id);

  PageDomain<CategoryDomain> getPageableCategory(int page, int quantity, String orientation);
}
