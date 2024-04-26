package com.reservationapp4.controller;

import com.reservationapp4.entity.Bus;
import com.reservationapp4.entity.Passenger;
import com.reservationapp4.entity.Route;
import com.reservationapp4.exception.ResourceNotFound;
import com.reservationapp4.payload.ReservationDto;
import com.reservationapp4.repository.BusRepository;
import com.reservationapp4.repository.PassengerRepository;
import com.reservationapp4.repository.RouteRepository;
import com.reservationapp4.util.EmailService;
import com.reservationapp4.util.PdfTicketGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PdfTicketGenerator pdfTicketGenerator;

    @Autowired
 private EmailService emailService;

//http://localhost:8080/api/reservation?BusId=1&routeId=1
    @PostMapping
    public ResponseEntity<String> bookTicket(

        @RequestParam long BusId,
        @RequestParam long routeId,
        @RequestBody Passenger passenger

               ) {
        boolean busIsPresent = false;
        boolean routeIsPresent = false;
        Optional<Bus> byId = busRepository.findById(BusId);
        if (byId.isPresent()) {
            busIsPresent = true;
            Bus bus = byId.get();


        }
        Optional<Route> byRouteId = routeRepository.findById(routeId);
        if (byRouteId.isPresent()) {
            routeIsPresent = true;
            Bus bus = byId.get();

        }
        if(busIsPresent&&routeIsPresent){

            Passenger p= new Passenger();
            p.setFirstName(passenger.getFirstName());
            p.setLastName(passenger.getLastName());
            p.setEmail(passenger.getEmail());
            p.setMobile(passenger.getMobile());
            p.setRouteId(routeId);
            p.setBusId(BusId);
            Passenger savedPassenger= passengerRepository.save(p);
            byte [] pdfBytes= pdfTicketGenerator.generateTicket(savedPassenger,byRouteId.get().getFromLocation(),byRouteId.get().getToLocation(),byRouteId.get().getFromDate(),byRouteId.get().getToDate());
             emailService.sendEmailWithAttachment(passenger.getEmail(),"Booking Confirmed..","You reservation id"+savedPassenger.getId(),pdfBytes,"ticket");
    }
        return new ResponseEntity<>("done", HttpStatus.CREATED);

    }

}

