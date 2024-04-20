package com.reservationapp4.repository;


import com.reservationapp4.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository <UserRegistration,Long> {
}
