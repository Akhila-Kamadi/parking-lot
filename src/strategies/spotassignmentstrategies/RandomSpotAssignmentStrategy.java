package strategies.spotassignmentstrategies;

import models.EntryGate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.ParkingSpotType;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    @Override
    public ParkingSpot assignSpot(ParkingSpotType spotType, ParkingLot parkingLot, EntryGate entryGate) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkingSpotType().equals(spotType)
                && parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
