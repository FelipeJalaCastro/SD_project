package com.backendsd.backendsd.controller;

import com.backendsd.backendsd.db.DepartureRepo;
import com.backendsd.backendsd.db.MongoRepo;
import com.backendsd.backendsd.entity.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartureController{

    @Autowired
    private DepartureRepo depRepo;

    private MongoRepo mongoRepo;

    @GetMapping("/findDep")
    public List<Departure> getDepartures(@RequestParam(name = "locName") String locationName){
        return depRepo.findByLocationName(locationName);
    }

    @GetMapping("/findStatus")
    public List<Departure> getByStatus(@RequestParam(name = "status") String status){
        return depRepo.findByTiempoEstimadoSalida(status);
    }

    @GetMapping("/findDelayed")
    public List<Departure> getLateDepartures(){
        List<String> statuses = Arrays.asList("On time", "Cancelled", "Delayed");
        return depRepo.findByTiempoEstimadoSalidaIsNotIn(statuses);
    }

    @GetMapping("/findRatio")
    public long getOnTimeRatio(@RequestParam(name = "status") String status){
        long departures = depRepo.count();
        long filtered = depRepo.findByTiempoEstimadoSalida(status).size();
        return filtered / departures;
    }



}
