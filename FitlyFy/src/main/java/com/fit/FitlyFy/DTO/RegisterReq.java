package com.fit.FitlyFy.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {

    private String id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
}
