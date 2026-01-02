package com.fit.FitlyFy.Repository;

import com.fit.FitlyFy.model.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activities,String> {


    List<Activities> findByUser_Id(String userId);

}
