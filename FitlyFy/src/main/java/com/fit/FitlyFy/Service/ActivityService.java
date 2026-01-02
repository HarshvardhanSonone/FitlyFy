package com.fit.FitlyFy.Service;


import com.fit.FitlyFy.DTO.ActivityReq;
import com.fit.FitlyFy.DTO.ActivityResponse;
import com.fit.FitlyFy.Repository.ActivityRepo;
import com.fit.FitlyFy.Repository.UserRepo;
import com.fit.FitlyFy.model.Activities;
import com.fit.FitlyFy.model.User;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ActivityService {


    private final ActivityRepo activityRepo;
private final UserRepo userRepo;
    public ActivityResponse trackActivity(ActivityReq req) {
        User user= userRepo.findById(req.getUserID())
                .orElseThrow(()->new RuntimeException("Invalid Credentials"));

        Activities activity = Activities.builder()
                .user(user)
                .activityType(req.getActivityType())
                .duration(req.getDuration())
                .CaloriesBurned(req.getCaloriesBurned())
                .startedAt(req.getStartedAt())
                .additionalStuff(req.getExtraStuff())
                .duration(req.getDuration())

                .build();

        Activities Savedactivities=activityRepo.save(activity);

        System.out.println("-------------------------------"+Savedactivities);
      return  convertToRes(Savedactivities); //null;// activityRepo.save(activity);
    }

    private ActivityResponse convertToRes(Activities savedactivities) {

        ActivityResponse activityResponse= new ActivityResponse();

        activityResponse.setId(savedactivities.getId());
        activityResponse.setUserID(savedactivities.getUser().getId());
        activityResponse.setActivityType(savedactivities.getActivityType());
        activityResponse.setDuration(savedactivities.getDuration());
        activityResponse.setCaloriesBurned(savedactivities.getCaloriesBurned());
        activityResponse.setExtraStuff(savedactivities.getAdditionalStuff());
        activityResponse.setStartedAt(savedactivities.getStartedAt());
        activityResponse.setCreatedAt(savedactivities.getCreatedAt());
        activityResponse.setUpdatedAt(savedactivities.getUpdatedAt());

        return activityResponse;
    }

    public @Nullable List<ActivityResponse> getUserActivites(String userId) {


List<Activities>activitiesList=activityRepo.findByUser_Id(userId);
        return activitiesList.stream().map(this::convertToRes)
                .toList();
    }
}
