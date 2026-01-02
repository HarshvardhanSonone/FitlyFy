package com.fit.FitlyFy.Controller;


import com.fit.FitlyFy.DTO.RegisterReq;
import com.fit.FitlyFy.DTO.userResponse;
import com.fit.FitlyFy.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor // for final fieldds only
public class UserAuthController {



private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<userResponse> Register(@RequestBody RegisterReq registerReq){

        System.out.println("user saved");
            return ResponseEntity.ok( userService.register(registerReq));
    }

    @GetMapping("/getAll")
    public ResponseEntity<userResponse> GetAll(@RequestBody RegisterReq registerReq){
        return  null; //.ResponseEntity.ok(userService.register(registerReq));
    }
}
