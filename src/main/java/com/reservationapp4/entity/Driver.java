package com.reservationapp4.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    private String driverName;
    private String driverLicenseNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;

    // You can add any other necessary fields and methods
}
