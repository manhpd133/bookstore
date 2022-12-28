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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_order")
    private long orderID;

    @Column(name = "id_user")
    private long userID;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    @Column(name = "id_product")
    private long productID;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_amount")
    private float totalAmount;

    @Column(name = "ship_name") // tên người nhận
    private  String ship_name;

    @Column(name = "ship_phone") // sđt người nhận
    private  String shipPhone;

    @Column (name = "ship_address") // địa chỉ người nhận
    private String shipAddress;
}
