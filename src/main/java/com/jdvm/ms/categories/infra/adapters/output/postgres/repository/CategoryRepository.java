package com.jdvm.ms.categories.infra.adapters.output.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jdvm.ms.categories.infra.adapters.output.postgres.entity.CategoryEntity;

/**
 * 
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
