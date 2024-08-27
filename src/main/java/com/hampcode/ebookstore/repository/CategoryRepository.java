package com.hampcode.ebookstore.repository;

import com.hampcode.ebookstore.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
