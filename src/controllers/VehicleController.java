package controllers;

import dtos.CreateVehicleRequestDto;
import dtos.CreateVehicleResponseDto;
import dtos.ResponseStatusDto;
import models.Vehicle;
import services.VehicleService;

public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public CreateVehicleResponseDto createVehicle(CreateVehicleRequestDto request){
        Vehicle createdVehicle = vehicleService.createVehicle(request.getOwnerName(),
                request.getVehicleNumber(), request.getVehicleType());
        CreateVehicleResponseDto response = new CreateVehicleResponseDto();
        response.setVehicle(createdVehicle);
        response.setResponseStatus(ResponseStatusDto.SUCCESS);
        return response;
    }
}
