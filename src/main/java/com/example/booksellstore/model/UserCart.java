package com.example.booksellstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "user_cart")
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_user_cart")
    private long userCartID;

    @Column(name = "id_user")
    private long userID;

    @Column(name = "id_product")
    private long productID;

    @Column(name = "quantity")
    private int quantity;
}
