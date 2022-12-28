package com.example.booksellstore.service;

import com.example.booksellstore.dto.UserResDTO;
import com.example.booksellstore.mapper.UserMapper;
import com.example.booksellstore.model.Users;
import com.example.booksellstore.reponsitory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserResDTO> getListUsers() {
        List<Users> users = userRepo.findAll();
        List<UserResDTO> userDTOS = new ArrayList<>();
        for (Users user : users) {
            userDTOS.add(UserMapper.toUserDTO(user));
        }
        return userDTOS;
    }

    public ResponseEntity<HttpStatus> Login( String email, String password){
        try {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
