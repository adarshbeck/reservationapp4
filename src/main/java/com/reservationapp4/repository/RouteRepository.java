package com.reservationapp4.repository;

import com.reservationapp4.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    Route findByBusId(long busId);
}
