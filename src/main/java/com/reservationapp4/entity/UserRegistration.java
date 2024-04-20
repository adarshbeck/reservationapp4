package com.reservationapp4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="User_registration")
public class UserRegistration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private long id;
    private String name;
    private String email;
    private String password;

    @Lob
    @Column(name="profile_picture",length =1024)
    private byte[]profilePicture;

}
