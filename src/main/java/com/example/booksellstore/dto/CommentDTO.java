package com.example.booksellstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public interface CommentDTO {
    String getFullName();
    String getContent();

    @JsonFormat(pattern="yyyy-MM-dd")
    Date getCreatedAt();
}
