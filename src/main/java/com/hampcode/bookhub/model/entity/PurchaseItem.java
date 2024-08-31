package com.hampcode.bookhub.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_items")
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float price;

    @Column(name = "downs_ava")
    private Integer downloadsAvailable;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_purchaseitem_books"))
    private Book book;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_purchaseites_purchases"))
    private Purchase purchase;
}
