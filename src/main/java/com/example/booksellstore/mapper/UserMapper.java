package com.example.booksellstore.mapper;

import com.example.booksellstore.dto.UserResDTO;
import com.example.booksellstore.model.Users;

public class UserMapper {
   public static UserResDTO toUserDTO(Users users) {
       UserResDTO userResDTO = new UserResDTO();
       userResDTO.setFullName(users.getFullName());
       userResDTO.setEmail(users.getEmail());
       userResDTO.setPassword(users.getPassword());
       userResDTO.setAddress(users.getAddress());
       userResDTO.setPhone(users.getPhone());

       return userResDTO;
   }
}
