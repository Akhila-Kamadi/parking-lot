package services;

import models.EntryGate;
import models.Ticket;
import models.Vehicle;
import models.enums.ParkingSpotType;
import repositories.TicketRepository;
import strategies.spotassignmentstrategies.RandomSpotAssignmentStrategy;
import strategies.spotassignmentstrategies.SpotAssignmentStrategy;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(TicketRepository ticketRepository, SpotAssignmentStrategy spotAssignmentStrategy) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public Ticket generateTicket(Long parkingLotId, ParkingSpotType spotType,
                                 Vehicle vehicle, EntryGate entryGate){
        /*
        1. Assign a parking spot
        2.If parking spot is assigned -> create ticket
        3. save
        4. return
         */

//        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();
//        spotAssignmentStrategy.assignSpot(spotType,)
        return null;
    }
}
