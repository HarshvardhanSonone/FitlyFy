package com.fit.FitlyFy.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RecommendationsRequest {

    private String userId;
    private String activityId;

    private List<String> improvements;

    private List<String> suggestion;


    private List<String> safety;


}
