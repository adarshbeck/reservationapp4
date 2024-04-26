package com.reservationapp4.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Route {
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

    @Column(name = "busId",insertable=false, updatable=false)
    private Long busId;

    @OneToOne
    @JoinColumn(name = "busId")
    private Bus route;

    public Long getbusId() {
        return busId;
    }
    public Bus setBus(Bus bus) {
        return bus;
    }


    // getters and setters


}
