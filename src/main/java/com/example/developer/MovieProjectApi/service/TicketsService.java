package com.example.developer.MovieProjectApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.developer.MovieProjectApi.repository.TicketsRepo;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepo ticketsRepo;

    public TicketsService(TicketsRepo ticketsRepo) {
        this.ticketsRepo = ticketsRepo;
    }

    // public TicketsRepo addTicket(TicketsRepo ticket) {
    //     return ticketsRepo.save(ticket);
    // }

    
    
}
