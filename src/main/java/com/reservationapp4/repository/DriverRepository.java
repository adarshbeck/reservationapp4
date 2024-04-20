package com.reservationapp4.repository;

import com.reservationapp4.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository <Driver,Long> {
}
