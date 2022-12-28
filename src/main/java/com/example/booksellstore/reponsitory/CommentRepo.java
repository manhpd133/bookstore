package com.example.booksellstore.reponsitory;

import com.example.booksellstore.dto.CommentDTO;
import com.example.booksellstore.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {

    @Query(value = "Select  u.full_name as fullName,  c.content, c.created_at as createdAt " +
            "from comment c " +
            "join product p on c.product_id = p.productid " +
            "join users u on u.id_users = c.user_id",nativeQuery = true)
    List<CommentDTO> findAllBy();

    @Query(value = "DELETE " +
            "FROM comment c " +
            "WHERE c.id = ?1 ",nativeQuery = true)
    List<CommentDTO> deleteCommentById(Long id);
}
