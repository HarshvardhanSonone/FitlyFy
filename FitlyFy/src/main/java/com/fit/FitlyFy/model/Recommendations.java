package com.fit.FitlyFy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fit.FitlyFy.model.Activities;
import com.fit.FitlyFy.model.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@Data
@Entity
public class Recommendations {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_recommendation_user"))
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_recommendation_activity"))
    @JsonIgnore
    private Activities activity;

    @Column(length = 1000)
    private String recommendation;

    private String type;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> improvements;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> suggestion;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> safety;

    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
