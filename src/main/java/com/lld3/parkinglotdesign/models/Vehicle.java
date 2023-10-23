package com.lld3.parkinglotdesign.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Vehicle extends BaseModel {
    private String licenseNumber;
    private VehicleType type;
}