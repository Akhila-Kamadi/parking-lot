package services;

import models.*;
import models.enums.ParkingSpotType;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import strategies.spotassignmentstrategies.RandomSpotAssignmentStrategy;
import strategies.spotassignmentstrategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository, SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Long parkingLotId, ParkingSpotType spotType,
                                 Vehicle vehicle, EntryGate entryGate){
        /*
        0. Get parking lot
        1. Assign a parking spot
        2.If parking spot is assigned -> create ticket
        3. save
        4. return
         */
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);
        if (parkingLot == null){
            return null;
        }
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(spotType, parkingLot, entryGate);
        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        ticket.setGeneratedBy(entryGate.getOperator());
        ticket.setParkingLot(parkingLot);
        ticket.setVehicle(vehicle);
        ticket.setOwnerName(vehicle.getOwnerName());
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        Ticket createdTicket = ticketRepository.save(ticket);
        return createdTicket;
    }
}
