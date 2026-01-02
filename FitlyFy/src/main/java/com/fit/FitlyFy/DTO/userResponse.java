package com.fit.FitlyFy.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userResponse {

    private String id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
