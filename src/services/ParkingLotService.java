package services;

import models.ParkingLot;
import repositories.ParkingLotRepository;

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
}
