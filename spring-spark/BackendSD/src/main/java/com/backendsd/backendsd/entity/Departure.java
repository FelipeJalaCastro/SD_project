package com.backendsd.backendsd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Document(collection = "departure")
public class Departure {

    @Id
    public String id;
    public String locationName;
    public String tiempoProgramadoSalida;
    public String destinationName;
    public String tiempoEstimadoSalida;

    public Departure(String id, String locationName, String tiempoProgramadoSalida, String destinationName, String tiempoEstimadoSalida) {
        this.id = id;
        this.locationName = locationName;
        this.tiempoProgramadoSalida = tiempoProgramadoSalida;
        this.destinationName = destinationName;
        this.tiempoEstimadoSalida = tiempoEstimadoSalida;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getTiempoProgramadoSalida() {
        return tiempoProgramadoSalida;
    }

    public void setTiempoProgramadoSalida(String tiempoProgramadoSalida) {
        this.tiempoProgramadoSalida = tiempoProgramadoSalida;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getTiempoEstimadoSalida() {
        return tiempoEstimadoSalida;
    }

    public void setTiempoEstimadoSalida(String tiempoEstimadoSalida) {
        this.tiempoEstimadoSalida = tiempoEstimadoSalida;
    }
}
