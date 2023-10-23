package com.lld3.parkinglotdesign.controller;

import com.lld3.parkinglotdesign.dtos.CreateTicketRequest;
import com.lld3.parkinglotdesign.models.Ticket;
import com.lld3.parkinglotdesign.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private TicketService ticketService;

    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request) {
        return ticketService.createTicket(request);
    }
}