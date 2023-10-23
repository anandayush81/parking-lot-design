package com.lld3.parkinglotdesign.service;

import com.lld3.parkinglotdesign.models.Vehicle;
import com.lld3.parkinglotdesign.models.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {
        return Vehicle
                .builder()
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();
    }

}