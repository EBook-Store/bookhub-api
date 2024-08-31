package com.hampcode.bookhub.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "collection_books")
@IdClass(CollectionBookPK.class)
public class CollectionBook {
    @Id
    private Book book;
    @Id
    private Collection collection;

    @Column(name = "added_date")
    private LocalDateTime addedDate;
}
