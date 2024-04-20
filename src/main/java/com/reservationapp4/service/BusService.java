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


    @Transactional
    public void addBus(BusDto busDto) {
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        Route route = new Route();
        route.setFromLocation(busDto.getRoute().getFromLocation());
        route.setToLocation(busDto.getRoute().getToLocation());
        route.setFromDate(busDto.getRoute().getFromDate());
        route.setToDate(busDto.getRoute().getToDate());
        route.setTotalDuration(busDto.getRoute().getTotalDuration());
        route.setFromTime(busDto.getRoute().getFromTime());
        route.setToTime(busDto.getRoute().getToTime());

        // Save Route entity and associate it with the Bus
        bus.setRoute(route);
        busRepository.save(bus);

        if (busDto.getSubRoutes() != null && !busDto.getSubRoutes().isEmpty()) {
            for (SubRouteDto subRouteDto : busDto.getSubRoutes()) {
                SubRoute subRoute = new SubRoute();
                subRoute.setFromLocation(subRouteDto.getFromLocation());
                subRoute.setToLocation(subRouteDto.getToLocation());
                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
                subRoute.setFromTime(subRouteDto.getFromTime());
                subRoute.setToTime(subRouteDto.getToTime());

                subRoute.setRoute(route);


                subRouteRepository.save(subRoute);
            }


        }
    }
    }
