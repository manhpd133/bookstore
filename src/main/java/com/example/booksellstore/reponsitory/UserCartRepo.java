package com.example.booksellstore.reponsitory;

import com.example.booksellstore.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCartRepo extends JpaRepository<UserCart, Long> {
    Optional<UserCart> findById(Long aLong);


}
