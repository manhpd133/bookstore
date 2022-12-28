package com.example.booksellstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_product")
    private long productID;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "price")
    private float price;

    @Column(name = "detail",columnDefinition = "TEXT")
    private String detail;

    @Column(name = "quantity")
    private int quantity;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "image")
    private String image;

    @Column(name = "author")
    private String author;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "id_category")
    private long categoryID;

    @Column(name = "id_product_category")
    private long productCategoryID;
}
