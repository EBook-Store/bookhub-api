package com.hampcode.bookhub.service;

import com.hampcode.bookhub.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AdminCategoryService {
    List<Category> findAll();
    Page<Category> paginate(Pageable pageable);
    Category create(Category category);
    Category findById(Integer id);
    Category update(Integer id, Category updatedCategory);
    void delete(Integer id);
}