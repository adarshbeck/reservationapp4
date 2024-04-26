package com.reservationapp4.controller;

import com.reservationapp4.entity.Bus;
import com.reservationapp4.entity.Route;
import com.reservationapp4.payload.BusDto;
import com.reservationapp4.repository.BusRepository;
import com.reservationapp4.repository.RouteRepository;
import com.reservationapp4.service.BusService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

@Autowired
private EntityManager entityManager;
@Autowired
private RouteRepository routeRepository;

@Autowired
private BusRepository busRepository;

    @Autowired
    private BusService busService;

    //http:localhost:8080/api/v1/bus/add

    @PostMapping("/add")
    public ResponseEntity<Bus> addBusDetails(@RequestBody BusDto busDto) throws ParseException {

 Bus bus = busService.addBus(busDto);
     return new ResponseEntity<>(bus, HttpStatus.CREATED);


}

}
