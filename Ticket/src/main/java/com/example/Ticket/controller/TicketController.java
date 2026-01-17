package com.example.Ticket.controller;

import com.example.Ticket.entity.Ticket;
import com.example.Ticket.model.TicketRequest;
import com.example.Ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "*")
public class TicketController {
    public final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<String> saveTicket(@RequestBody TicketRequest request) {
        service.saveTicket(request);
        return ResponseEntity.ok("Ticket created successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTicket(){
        return ResponseEntity.ok(service.getAllTickets());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = service.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

}
