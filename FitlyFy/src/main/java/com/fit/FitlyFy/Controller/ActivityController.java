package com.fit.FitlyFy.Controller;

import com.fit.FitlyFy.DTO.ActivityReq;
import com.fit.FitlyFy.DTO.ActivityResponse;
import com.fit.FitlyFy.Service.ActivityService;
import com.fit.FitlyFy.model.Activities;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ActivityController {

@GetMapping("/api/activities")
    public ResponseEntity <List<ActivityResponse>> getActivities(
            @RequestHeader(name = "userId",required = true)
            String userid){

    System.out.println("HIT GET /api/activities with userId = " + userid);
   // System.out.println(activityService.getUserActivites(userid));
    return ResponseEntity.ok(activityService.getUserActivites(userid));
}

    private final ActivityService activityService;
    @PostMapping ("api/activities")
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityReq activityReq){

        return ResponseEntity.ok((ActivityResponse) activityService.trackActivity(activityReq));
    }
}
