package com.jdvm.ms.categories.application.ports.input;

import com.jdvm.ms.categories.domain.model.CategoryDomain;
import com.jdvm.ms.categories.domain.model.PageDomain;

/*
 * 
 */
public interface CategoryService {

  CategoryDomain createCategory(CategoryDomain categoryDomain);

  CategoryDomain getCategoryById(Long id);

  PageDomain<CategoryDomain> categoryPageable(int page, int quantity, String orientation);
}
