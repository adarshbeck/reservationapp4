package com.reservationapp4.payload;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRouteDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private int totalDuration;
    private String fromTime;
    private String toTime;

    // Constructors, getters, and setters
}

