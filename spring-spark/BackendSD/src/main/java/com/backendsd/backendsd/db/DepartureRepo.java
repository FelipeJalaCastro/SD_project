package com.backendsd.backendsd.db;

import com.backendsd.backendsd.entity.Departure;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartureRepo extends MongoRepository<Departure, String> {

    List<Departure> findByLocationName(String locationName);
    List<Departure> findByTiempoEstimadoSalida(String status);

    List<Departure> findByTiempoEstimadoSalidaIsNotIn(List<String> statuses);
}
