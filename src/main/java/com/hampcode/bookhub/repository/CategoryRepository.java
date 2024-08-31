package com.hampcode.bookhub.repository;

import com.hampcode.bookhub.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
