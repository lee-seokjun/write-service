package com.example.writeservice.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseWrite {
    private String title;
    private String content;

    private Date createdAt;
    private String writeId;
    private String userId;
}
