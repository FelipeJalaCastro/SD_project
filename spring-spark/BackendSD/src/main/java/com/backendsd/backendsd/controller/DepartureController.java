package com.backendsd.backendsd.controller;

import com.backendsd.backendsd.db.DepartureRepo;
import com.backendsd.backendsd.db.MongoRepo;
import com.backendsd.backendsd.entity.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findLate")
    public List<Departure> getLateDepartures(){

    }

}
