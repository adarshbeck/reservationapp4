package com.reservationapp4.controller;

import com.reservationapp4.payload.BusDto;
import com.reservationapp4.repository.BusRepository;
import com.reservationapp4.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {



    @Autowired
    private BusService busService;

    //http:localhost:8080/api/v1/bus/add

    @PostMapping("/add")
    public ResponseEntity<String> addBusDetails(@RequestBody BusDto busDto) throws ParseException {

 busService.addBus(busDto);
     return new ResponseEntity<>("Bus details added", HttpStatus.CREATED);


}
}
