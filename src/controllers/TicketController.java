package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request){
        Ticket ticket = new Ticket();
        ticket.setEntryGate(request.getEntryGate());
        return null;
    }
}
