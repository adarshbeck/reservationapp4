package com.reservationapp4.service;


import com.reservationapp4.entity.Bus;
import com.reservationapp4.entity.Route;
import com.reservationapp4.exception.ResourceNotFound;
import com.reservationapp4.repository.BusRepository;
import com.reservationapp4.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusRepository busRepository;

    @Transactional
    public Route createRoute(long busId, Route route) {
        // Check if the bus exists
        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not found with ID: " + busId)
        );

        // Associate the route with the bus
        route.setBus(bus);

        // Save the route
        return routeRepository.save(route);
    }
}
