package com.example.booksellstore.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResDTO {

    private String email;
    private  String password;
}
