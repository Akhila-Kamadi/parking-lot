package dtos;

import models.enums.ParkingSpotType;

import java.util.Map;

public class AddParkingSpotRequestDto {
    private Long parkingLotId;
    private Map<ParkingSpotType, Long> spotCount;

    //Spot type -> Spot Count
    // Bike -> 20
    // Car -> 10

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Map<ParkingSpotType, Long> getSpotCount() {
        return spotCount;
    }

    public void setSpotCount(Map<ParkingSpotType, Long> spotCount) {
        this.spotCount = spotCount;
    }

}
