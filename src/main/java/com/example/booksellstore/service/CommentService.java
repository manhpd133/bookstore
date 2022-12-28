package com.example.booksellstore.service;

import com.example.booksellstore.dto.CommentDTO;
import com.example.booksellstore.reponsitory.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public List<CommentDTO> getComment(){
        return commentRepo.findAllBy();
    }

    public  List<CommentDTO> deleteComment(Long id){
        return commentRepo.deleteCommentById(id);
    }

}
