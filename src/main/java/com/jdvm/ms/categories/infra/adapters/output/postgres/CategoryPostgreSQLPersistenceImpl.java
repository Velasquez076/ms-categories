package com.jdvm.ms.categories.infra.adapters.output.postgres;

import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import com.jdvm.ms.categories.application.ports.output.CategoryPersistence;
import com.jdvm.ms.categories.domain.model.CategoryDomain;
import com.jdvm.ms.categories.domain.model.PageDomain;
import com.jdvm.ms.categories.infra.adapters.output.postgres.mapper.MapperPersistence;
import com.jdvm.ms.categories.infra.adapters.output.postgres.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 
 */
@Slf4j
@Repository
@RequiredArgsConstructor
class CategoryPostgreSQLPersistenceImpl implements CategoryPersistence {

  private final CategoryRepository categoryRepository;
  private final MapperPersistence mapperPersistence;

  private static final String ORDER = "name";

  @Override
  public CategoryDomain save(CategoryDomain categoryDomain) {
    log.info(".:: Saving category ::.");
    return mapperPersistence
        .toDomain(categoryRepository.save(mapperPersistence.toEntity(categoryDomain)));
  }

  @Override
  public Optional<CategoryDomain> getCategoryById(Long id) {
    log.info(".:: Get category by id ::.");
    return categoryRepository.findById(id).map(mapperPersistence::toDomain);
  }

  @Override
  public PageDomain<CategoryDomain> getPageableCategory(int page, int quantity,
      String orientation) {
    log.info("Get pageable...");
    var pageable =
        PageRequest.of(page, quantity, Sort.Direction.fromString(orientation.toUpperCase()), ORDER);
    return mapperPersistence.toPageDomain(categoryRepository.findAll(pageable));
  }
}
