package com.example.booksellstore.controller;

import com.example.booksellstore.dto.CommentDTO;
import com.example.booksellstore.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class ApiCommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<CommentDTO> getCommentPage( @RequestParam(name = "Comment",defaultValue = "1") Long id) {

        List<CommentDTO> commentDTOS = commentService.getComment();
        log.info(commentDTOS.toString());

        return commentDTOS;
    }

    @DeleteMapping ("/delete_comment/{id}")
    public List<CommentDTO> postCommentPage( @RequestParam(name = "Comment",defaultValue = "1") Long id) {

        List<CommentDTO> commentDTOS = commentService.deleteComment(id);
        log.info(commentDTOS.toString());

        return commentDTOS;
    }
}
