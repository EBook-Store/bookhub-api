package com.hampcode.bookhub.service;

import com.hampcode.bookhub.model.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminAuthorService {
    List<Author> findAll();
    Page<Author> paginate(Pageable pageable);
    Author create(Author Author);
    Author findById(Integer id);
    Author update(Integer id, Author updatedAuthor);
    void delete(Integer id);
}
