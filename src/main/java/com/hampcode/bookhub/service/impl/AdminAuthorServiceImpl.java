package com.hampcode.bookhub.service.impl;

import com.hampcode.bookhub.model.entity.Author;
import com.hampcode.bookhub.repository.AuthorRepository;
import com.hampcode.bookhub.service.AdminAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminAuthorServiceImpl implements AdminAuthorService {

    private final AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Author> paginate(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Author create(Author author) {
        author.setCreatedAt(LocalDateTime.now());
        return authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public Author findById(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    @Override
    @Transactional
    public Author update(Integer id, Author updatedAuthor) {
        Author authorFromDb = findById(id); // Utiliza el método findById para obtener el autor existente
        authorFromDb.setFirstName(updatedAuthor.getFirstName());
        authorFromDb.setLastName(updatedAuthor.getLastName());
        authorFromDb.setBio(updatedAuthor.getBio());
        authorFromDb.setUpdatedAt(LocalDateTime.now());
        return authorRepository.save(authorFromDb);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Author author = findById(id); // Utiliza el método findById para obtener el autor existente
        authorRepository.delete(author);
    }
}
