package com.example.booksellstore.reponsitory;

import com.example.booksellstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
