package com.hampcode.bookhub.repository;

import com.hampcode.bookhub.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
