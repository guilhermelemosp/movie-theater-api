package com.example.developer.MovieProjectApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.developer.MovieProjectApi.model.TicketsBoughtByUser;
import com.example.developer.MovieProjectApi.repository.TicketsRepo;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepo ticketsRepo;

    public TicketsService(TicketsRepo ticketsRepo) {
        this.ticketsRepo = ticketsRepo;
    }

   public List<TicketsBoughtByUser> getAllTickets() {
    return ticketsRepo.findAll();
    }

    public TicketsBoughtByUser getTicketById(Long id) {
        return ticketsRepo.findById(id).orElse(null);
    }

    public TicketsBoughtByUser addTicket(TicketsBoughtByUser ticket) {
        return ticketsRepo.save(ticket);
    }
}

    
    

