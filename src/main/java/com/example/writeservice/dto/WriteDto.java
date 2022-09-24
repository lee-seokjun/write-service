package com.example.writeservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WriteDto implements Serializable {
    private String title;
    private String content;

    private Date createdAt;
    private String writeId;
    private String userId;
}

