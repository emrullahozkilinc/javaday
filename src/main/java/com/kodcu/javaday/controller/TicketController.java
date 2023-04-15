package com.kodcu.javaday.controller;

import com.kodcu.javaday.dto.request.CreateTicketRequestDto;
import com.kodcu.javaday.service.db.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticket")
@CrossOrigin
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<CreateTicketRequestDto> createTicket(@Valid @RequestBody CreateTicketRequestDto ticket){
        ticketService.saveTicket(ticket);
        return ResponseEntity.ok(ticket);
    }
}
