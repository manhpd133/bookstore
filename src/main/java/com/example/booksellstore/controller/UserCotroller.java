package com.example.booksellstore.controller;

import com.example.booksellstore.dto.UserResDTO;
import com.example.booksellstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserCotroller {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getListUsers() {
        List<UserResDTO> userDTOS = userService.getListUsers();
        return ResponseEntity.ok(userDTOS);
    }


}
