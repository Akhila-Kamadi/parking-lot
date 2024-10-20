package services;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.ParkingSpotType;
import repositories.ParkingLotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot updateParkingLot(Long parkingLotId, String newAddress){
        /*
        1. GetPL by Id
        2. If exists update address
        3. save updatePL
        4. return
         */
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);
        if (parkingLot == null){
            return null;
        }
        parkingLot.setAddress(newAddress);
        ParkingLot updatedParkinglot = parkingLotRepository.update(parkingLotId, parkingLot);
        return updatedParkinglot;
    }

    public void addParkingSpots(Long parkingLotId, Map<ParkingSpotType, Long> spotCount){
        /**
         * fetch PL by ID
         * get number of floors
         * iterate on spot count and create spots
         * save all spots
         * get PF list from PL=> for each floor add spots and save
         * save PL
         */
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);
        if (parkingLot == null){
            return;
        }
        List<ParkingSpot> parkingSpots = new ArrayList<>();

        for (Map.Entry<ParkingSpotType, Long> spotTypeEntry : spotCount.entrySet()){
            ParkingSpotType spotType = spotTypeEntry.getKey();
            Long numberOfSpots = spotTypeEntry.getValue();

            for (int i = 1; i <= numberOfSpots; i++) {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setParkingSpotType(spotType);
                parkingSpot.setParkingSpotNumber(i);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);

                parkingSpots.add(parkingSpot);
            }
        }

//        List<ParkingSpot> savedParkingSpots = saveAll
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for (int i = 0; i < parkingFloors.size(); i++) {
            //add saved parking spots
//            parkingFloors.get(0).setParkingSpots(savedParkingSpots);
//            for each parking spot in parking spot list set parking floor number
        }

        //save parking floor
        //save parking spot after updating parking floor number
        //save parking lot
    }
}
