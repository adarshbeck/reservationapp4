package com.reservationapp4.payload;


import jakarta.persistence.Lob;

public class UserRegistrationDto {
    private long id;
    private String name;
    private String email;
    private String password;

    @Lob
    private byte[]profilePicture;
}
