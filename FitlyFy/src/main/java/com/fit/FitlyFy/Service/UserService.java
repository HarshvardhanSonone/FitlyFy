package com.fit.FitlyFy.Service;

import com.fit.FitlyFy.DTO.RegisterReq;
import com.fit.FitlyFy.DTO.userResponse;
import com.fit.FitlyFy.Repository.UserRepo;
import com.fit.FitlyFy.model.Activities;
import com.fit.FitlyFy.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

//import static jdk.jpackage.internal.util.CompositeProxy.build;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    public userResponse register(RegisterReq registerReq) {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        User user =  User.builder()
                .id(registerReq.getId())
                        .email(registerReq.getEmail())
                        .first_name(registerReq.getFirst_name())  // np need for null if not needed
                        .last_name(registerReq.getLast_name())
              //  .updatedAt(registerReq.LocalDateTime)
                //.createdAt(registerReq.LocalDateTime)
                .password((registerReq.getPassword()))
                .build();
        System.out.println("waaaa");

        System.out.println(user);
        System.out.println(registerReq.getId());

//

//
//        User user = new User(
//                null,
//
//registerReq.getEmail(),
//                registerReq.getPassword(),
//                registerReq.getFirst_name(),
//                registerReq.getLast_name(),
//now,
//              now,
//List.of(),
//     List.of()
//
//        );
//


       User userSave=userRepo.save(user);
        System.out.println(userSave);
     return  toRes(userSave);
    }

//    public  userResponse getAllUser(RegisterReq registerReq){
//
//        return null;
//    }
    private userResponse toRes(User userSave) {

        userResponse response = new userResponse();
        response.setId(userSave.getId());                 // use ka type ko accept kr user res me return kr deha
        response.setEmail(userSave.getEmail());
        response.setPassword(userSave.getPassword());
        response.setFirst_name(userSave.getFirst_name());
        response.setLast_name(userSave.getLast_name());
        response.setCreatedAt(userSave.getCreatedAt());
        response.setUpdatedAt(userSave.getUpdatedAt());

        return response;
    }
}
