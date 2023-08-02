package com.backendsd.backendsd.controller;

import com.backendsd.backendsd.db.DepartureRepo;
import com.backendsd.backendsd.db.MongoRepo;
import com.backendsd.backendsd.entity.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    public float getOnTimeRatio(@RequestParam(name = "status") String status){
        float departures = depRepo.count();
        float filtered = depRepo.findByTiempoEstimadoSalida(status).size();
        return filtered / departures;
    }

    @GetMapping("/average/delayTime")
    public String getAverageDelay() throws ParseException {
        List<Departure> delayed = getLateDepartures();
        DateFormat sf = new SimpleDateFormat("mm:ss");
        long totalMS = 0;
        for(Departure dep : delayed){
            String progTimeStr = dep.getTiempoProgramadoSalida();
            String estTimeStr = dep.getTiempoEstimadoSalida();
            Date progTime = sf.parse(progTimeStr);
            Date estTime = sf.parse(estTimeStr);
            totalMS = totalMS + (estTime.getTime() - progTime.getTime());
        }
        long avgMS = totalMS / delayed.size();
        Date totalTime = new Date(avgMS);
        String totalTimeStr = sf.format(totalTime);
        return totalTimeStr;
    }

}
