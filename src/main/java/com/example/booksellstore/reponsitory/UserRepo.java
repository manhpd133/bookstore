package com.example.booksellstore.reponsitory;

import com.example.booksellstore.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByEmailAndPassword(String email,String password);
}
