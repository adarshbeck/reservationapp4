package com.reservationapp4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;

    @OneToOne(mappedBy = "route")
    private Route route;

    // getters and setters
}