package com.example.booksellstore.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResDTO {
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
}
