package strategies.spotassignmentstrategies;

import models.EntryGate;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.ParkingSpotType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingSpotType spotType, ParkingLot parkingLot, EntryGate entryGate);
}
