package com.reservationapp4.controller;

import com.reservationapp4.entity.Route;
import com.reservationapp4.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    private RouteService routeservice;

    @PostMapping("/{busId}")
    public ResponseEntity<Route> addRoute(@PathVariable long busId, @RequestBody Route route){
        Route r= routeservice.createRoute(busId,route);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }
}
