package com.lld3.parkinglotdesign.controller;

import com.lld3.parkinglotdesign.dtos.CreateParkingLotRequest;
import com.lld3.parkinglotdesign.models.ParkingLot;
import com.lld3.parkinglotdesign.service.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/parking-lot")
@RestController
@AllArgsConstructor
public class ParkingLotController {
    private ParkingLotService parkingLotService;
    // Create a parking lot
    // POST
    // 1. Request validation
    // 2. Data transformation
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }
    @GetMapping("/{id}")
    public ParkingLot getParkingLot(@PathVariable("id") Long id){
        return ParkingLot.builder().id(id).build();
        // same as return new ParkingLot(id);
    }
    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() == null) {
            throw new RuntimeException("Invalid number of floors");
        }
    }
    private ParkingLot transform(CreateParkingLotRequest request) {
        return request.toParkingLot();
    }
}