package com.fit.FitlyFy.Repository;

import com.fit.FitlyFy.model.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepo extends JpaRepository<Recommendations,String > {



}
