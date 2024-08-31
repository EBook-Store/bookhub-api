package com.hampcode.bookhub.api;

import com.hampcode.bookhub.model.entity.Author;
import com.hampcode.bookhub.model.entity.Category;
import com.hampcode.bookhub.service.AdminAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/authors")
@RequiredArgsConstructor
public class AdminAuthorController {

    private final AdminAuthorService adminAuthorService;

    @GetMapping
    public List<Author> listAll() {
        return adminAuthorService.findAll();
    }

    @GetMapping("/page")
    public Page<Author> paginate(@PageableDefault(size = 5, sort = "firstName") Pageable pageable) {
        return adminAuthorService.paginate(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Author create(@RequestBody Author author) {
        return adminAuthorService.create(author);
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable Integer id) {
        return adminAuthorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Integer id, @RequestBody Author author) {
        return adminAuthorService.update(id, author);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adminAuthorService.delete(id);
    }
}
