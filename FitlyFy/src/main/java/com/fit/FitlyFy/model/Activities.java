package com.fit.FitlyFy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Entity
@AllArgsConstructor
// @NoArgsConstructor
@Builder

@ToString(exclude = "user")
public class Activities {

@Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "userid", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_user")) // FK
@JsonIgnore
private User user;
private Integer duration;
private Integer CaloriesBurned;

        private LocalDateTime startedAt;
    @Enumerated(EnumType.STRING)   // WHY???  actual data store hogi nahi to 1,2,3,4,5.... hogi
    private ActivityType activityType;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String, Object> additionalStuff;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL,orphanRemoval = true)
 //   @JsonIgnore
     private List<Recommendations> recommendations = new ArrayList<>();
//private  List<Activities> activities= new ArrayList<>();

}
