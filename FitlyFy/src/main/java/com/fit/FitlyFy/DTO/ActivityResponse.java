package com.fit.FitlyFy.DTO;

import com.fit.FitlyFy.model.ActivityType;
import com.fit.FitlyFy.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse {
    private String id;

        private String userID;
        private Integer duration;
        private Integer CaloriesBurned;

        private LocalDateTime startedAt;
        private ActivityType activityType;
        private LocalDateTime updatedAt;
        private LocalDateTime createdAt;
        private Map<String, Object> ExtraStuff;


    }

