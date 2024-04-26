package com.reservationapp4.payload;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor


@Data
public class RouteDto {

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private Integer totalDuration;
    private String fromTime;
    private String toTime;

    // Constructors, getters, and setters
}
