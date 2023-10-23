package com.lld3.parkinglotdesign.service;

import java.util.Date;

import com.lld3.parkinglotdesign.dtos.CreateTicketRequest;
import com.lld3.parkinglotdesign.models.ParkingSpot;
import com.lld3.parkinglotdesign.models.Ticket;
import com.lld3.parkinglotdesign.models.SpotStatus;
import com.lld3.parkinglotdesign.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TicketService {

    private VehicleService vehicleService;
    private ParkingSpotService parkingSpotService;

    private TicketRepository ticketRepository;

    public Ticket createTicket(CreateTicketRequest request) {

        // Check if parking lot is full
        ParkingSpot parkingSpot = parkingSpotService.allocateSlot(request.getParkingLotId(), request.getVehicleType());
        if (parkingSpot == null) {
            throw new RuntimeException("Slot not available!");
        }

        // Update slot status
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);

        // Persist slot
        parkingSpotService.update(parkingSpot);

        // Create and persist ticket
        Ticket ticket = Ticket
                .builder()
                .entryTime(new Date())
                .spotId(parkingSpot.getId())
                .entryGateId(request.getEntryGateId())
                .vehicle(vehicleService.findOrCreate(request.getVehicleNumber(), request.getVehicleType()))
                .build();

        return ticketRepository.save(ticket);
    }

}