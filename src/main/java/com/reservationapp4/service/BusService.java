package com.reservationapp4.service;
import com.reservationapp4.entity.Bus;
import com.reservationapp4.entity.Route;
import com.reservationapp4.entity.SubRoute;
import com.reservationapp4.payload.BusDto;
import com.reservationapp4.payload.SubRouteDto;
import com.reservationapp4.repository.BusRepository;
import com.reservationapp4.repository.RouteRepository;
import com.reservationapp4.repository.SubRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;



    public Bus addBus(BusDto busDto) {
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        Bus savedBus = busRepository.save(bus);
 return savedBus;
    }
    }
