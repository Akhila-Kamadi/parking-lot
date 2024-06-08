package repositories;

import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;


public class ParkingLotRepository {
    Map<Long, ParkingLot> parkingLots = new HashMap<>();
    Long lastCount = 0L;

    public ParkingLot save(ParkingLot parkingLot) {
        lastCount += 1;
        parkingLot.setId(lastCount);
        parkingLots.put(lastCount, parkingLot);
        return parkingLot;
    }

    public ParkingLot getById(Long parkingLotId) {
        if (parkingLots.containsKey(parkingLotId)) {
            return parkingLots.get(parkingLotId);
        }
        return null;
    }

    public ParkingLot update(Long parkingLotId, ParkingLot parkingLot) {
        return parkingLots.put(parkingLotId, parkingLot);
    }
}
