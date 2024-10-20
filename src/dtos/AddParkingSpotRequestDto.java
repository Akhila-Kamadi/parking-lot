package dtos;

import models.enums.ParkingSpotType;

import java.util.Map;

public class AddParkingSpotRequestDto {
    private Long parkingFloorId;
    private Map<ParkingSpotType, Long> spotCount;

    //Spot type -> Spot Count
    // Bike -> 20
    // Car -> 10

}
