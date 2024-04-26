package com.reservationapp4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;



    @Column(name = "busId",unique = true)
    private long busId;

    @Column(name = "routeId",unique = true)
    private long routeId;

    @Column(name = "seatNumber",unique= true)
    private String seatNumber;
}
