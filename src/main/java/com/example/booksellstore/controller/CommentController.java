package com.example.booksellstore.controller;

import com.example.booksellstore.dto.CommentDTO;
import com.example.booksellstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

     @Autowired
     private CommentService commentService;

    @GetMapping("/comment")
    public String getCommentPage(Model model,
                                  @RequestParam(name = "Comment",defaultValue = "1") Long id){

        List<CommentDTO> commentDTOS = commentService.getComment();
        model.addAttribute("getComment",commentDTOS);
        System.out.println(commentDTOS.toString());

        List<CommentDTO>deleteComment = commentService.deleteComment(id);
        model.addAttribute("getComment",deleteComment);
        System.out.println(deleteComment.toString());

        return "index";
    }
}
