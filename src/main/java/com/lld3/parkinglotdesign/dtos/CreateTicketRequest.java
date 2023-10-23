package com.lld3.parkinglotdesign.dtos;

import com.lld3.parkinglotdesign.models.VehicleType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateTicketRequest {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId;
}