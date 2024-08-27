package com.hampcode.ebookstore.api;

import com.hampcode.ebookstore.model.entity.Book;
import com.hampcode.ebookstore.service.AdminBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/books")
public class AdminBookController {
    private final AdminBookService adminBookService;

    @GetMapping()
    public List<Book> list() {
        return adminBookService.findAll();
    }

    @GetMapping("/page")
    public Page<Book> paginate(@PageableDefault(size = 5, sort = "title") Pageable pageable) {
        return adminBookService.paginate(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book create(@RequestBody Book bookFormDTO) {
        return adminBookService.create(bookFormDTO);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return adminBookService.findById(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book bookFormDTO) {
        return adminBookService.update(id, bookFormDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adminBookService.delete(id);
    }

}
