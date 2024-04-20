package com.reservationapp4.repository;

import com.reservationapp4.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository <Bus,Long> {
}
