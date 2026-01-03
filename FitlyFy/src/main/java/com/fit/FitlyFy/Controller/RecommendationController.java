package com.fit.FitlyFy.Controller;

import com.fit.FitlyFy.DTO.RecommendationsRequest;
import com.fit.FitlyFy.Service.RecommendationService;
import com.fit.FitlyFy.model.Recommendations;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor

@RestController
        @RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;
    @PostMapping("/generate")
    public ResponseEntity<Recommendations> generateRecommendation(
           @Validated @RequestBody RecommendationsRequest request
    ){

        Recommendations recommendations= recommendationService.genrateRecommendation(request);
        return ResponseEntity.ok(recommendations);
    }

}
