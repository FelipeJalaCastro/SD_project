package com.backendsd.backendsd.service;

import com.backendsd.backendsd.entity.Departure;

import java.util.List;

public interface DepartureService{

    List<Departure> filterLateDepartures();

}
