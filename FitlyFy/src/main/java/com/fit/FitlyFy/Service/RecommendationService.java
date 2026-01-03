package com.fit.FitlyFy.Service;


import com.fit.FitlyFy.DTO.RecommendationsRequest;
import com.fit.FitlyFy.Repository.ActivityRepo;
import com.fit.FitlyFy.Repository.RecommendationRepo;
import com.fit.FitlyFy.Repository.UserRepo;
import com.fit.FitlyFy.model.Activities;
import com.fit.FitlyFy.model.Recommendations;
import com.fit.FitlyFy.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class RecommendationService {
private final UserRepo userRepo;
private final ActivityRepo activityRepo;
//private final Activities activity;
private final  RecommendationRepo recommendationRepo;
    public Recommendations genrateRecommendation(RecommendationsRequest recommendationsRequest) {

        User user= userRepo.findById(recommendationsRequest.getUserid())
        .orElseThrow(()->new RuntimeException("User not found"+recommendationsRequest.getUserid()));

        System.out.println("USER ID = " + recommendationsRequest.getUserid());


        if (recommendationsRequest.getUserid() == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        User user1 = userRepo.findById(recommendationsRequest.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Activities activities= activityRepo.findById(recommendationsRequest.getActivityId())
                .orElseThrow(()->new RuntimeException("User not found"+recommendationsRequest.getActivityId()));

       Recommendations recommendations= Recommendations.builder()
               .user(user)
                       .activity(activities)
                                .improvements(recommendationsRequest.getImprovements())
                                       .suggestion(recommendationsRequest.getSuggestion())
                                               .safety(recommendationsRequest.getSafety())
                                                .build();

Recommendations savedRecomm= recommendationRepo.save(recommendations);

        return savedRecomm;

    }
}
