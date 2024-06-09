package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import dtos.ResponseStatusDto;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request){
        Ticket createdTicket = ticketService.generateTicket(request.getParkingLotId(), request.getParkingSpotType(),
                request.getVehicle(), request.getEntryGate());
        GenerateTicketResponseDto response = new GenerateTicketResponseDto();
        response.setTicket(createdTicket);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);
        return response;
    }
}
/*
To create a ticket ->
1. Create ParkingLot
2. Create Vehicle -> we can pass vehicleId in dto
3. Create EntryGate -> --------"OperatorId in dto
4. Create/generate a ticket
 */
