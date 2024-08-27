package com.hampcode.ebookstore.api;

import com.hampcode.ebookstore.model.entity.Category;
import com.hampcode.ebookstore.service.AdminCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    private final AdminCategoryService adminCategoryService;

    @GetMapping
    public List<Category> list() {
        return adminCategoryService.findAll();
    }

    @GetMapping("/page")
    public Page<Category> paginate(@PageableDefault(size = 5, sort = "name") Pageable pageable) {
        return adminCategoryService.paginate(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Category create(@RequestBody Category category) {
        return adminCategoryService.create(category);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Integer id) {
        return adminCategoryService.findById(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) {
        return adminCategoryService.update(id, category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adminCategoryService.delete(id);
    }
}
