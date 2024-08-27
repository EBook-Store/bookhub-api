package com.hampcode.ebookstore.repository;

import com.hampcode.ebookstore.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
    /**
     * TODO: Verificar si existe un libro con el slug especificado.
     * Este método será útil para validar la unicidad del slug antes de crear o actualizar un libro.
     */
    //boolean existsBySlug(String slug);
    @Query("SELECT COUNT(b) > 0 FROM Book b WHERE b.slug = :slug")
    boolean existsBySlug(@Param("slug") String slug);

    /**
     * TODO: Verificar si existe un libro con el slug especificado, excluyendo un ID determinado.
     * Utilizado principalmente al actualizar un libro para asegurarse de que el nuevo slug no sea duplicado para otro libro.
     */
    //boolean existsBySlugAndIdNot(String slug, Integer idNot);
    @Query("SELECT COUNT(b) > 0 FROM Book b WHERE b.slug = :slug AND b.id != :id")
    boolean existsBySlugAndIdNot(@Param("slug") String slug, @Param("id") Integer idNot);
}
