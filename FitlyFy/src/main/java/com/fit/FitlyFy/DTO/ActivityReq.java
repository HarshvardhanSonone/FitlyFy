package com.fit.FitlyFy.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fit.FitlyFy.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityReq {




        @JsonProperty ("userId")
        private String userID;
        private Integer duration;
        private Integer CaloriesBurned;

        private LocalDateTime startedAt;
        private ActivityType activityType;
        private Map<String, Object> ExtraStuff;


    }


