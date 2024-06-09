package dtos;

import models.Vehicle;

public class CreateVehicleResponseDto extends ResponseDto{
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
