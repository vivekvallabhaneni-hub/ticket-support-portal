package com.example.Ticket.service;

import com.example.Ticket.entity.Ticket;
import com.example.Ticket.model.TicketRequest;
import com.example.Ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository repo;
    public String saveTicket(TicketRequest request) {
        Ticket ticket= new Ticket();
        ticket.setEmail(request.getEmail());
        ticket.setFullname(request.getFullname());
        ticket.setTitle(request.getTitle());
        ticket.setDepartment(request.getDepartment());
        ticket.setContent(request.getContent());
        repo.save(ticket);
        return "Ticket Saved Successfully ";
    }

    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }
    public Ticket getTicketById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

}
