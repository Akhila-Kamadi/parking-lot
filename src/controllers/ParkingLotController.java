package controllers;

import dtos.*;
import models.ParkingFloor;
import models.ParkingLot;
import services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public CreateParkingLotResponseDto createParkingLot(CreateParkingLotRequestDto request){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(request.getAddress());
        if (request.getNumberOfFloors()<2){
            CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
            response.setResponseStatus(ResponseStatusDto.FAILURE);
            return response;
        }
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 0; i < request.getNumberOfFloors(); i++) {
            parkingFloors.add(new ParkingFloor());
        }
        parkingLot.setParkingFloors(parkingFloors);
        ParkingLot createdParkingLot = parkingLotService.createParkingLot(parkingLot);
        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        response.setParkingLot(createdParkingLot);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);

        return response;
    }

    public UpdateParkingLotResponseDto updateAddress(UpdateParkingLotRequestDto request){
        ParkingLot updatedParkingLot = parkingLotService.updateParkingLot(request.getParkingLotId(), request.getAddress());
        UpdateParkingLotResponseDto response = new UpdateParkingLotResponseDto();
        response.setParkingLot(updatedParkingLot);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);
        return response;
    }

    //add parking spot
    //for which parkingFloor, what type of spot and how many => same as addseats in auditorium in BMS
    //
}
