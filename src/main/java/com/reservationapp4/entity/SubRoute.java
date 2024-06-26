package com.reservationapp4.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private int totalDuration;
    private String fromTime;
    private String toTime;

    @Column(name = "route_id",nullable = false)
    private long routeId;
}
//    @ManyToOne
//    @JoinColumn(name = "route_id")
//    private Route route;
//
//    // getters and setters
//}
