package com.example.booksellstore.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductResDTO {
    public Long productID;
    public String nameProduct;
    public Float price;
    public String image;


}
