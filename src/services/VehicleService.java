package services;

import models.Vehicle;
import models.enums.VehicleType;
import repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(String owner, String numberPlate, VehicleType vehicleType){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setVehicleNumber(numberPlate);
        vehicle.setOwnerName(owner);
        Vehicle createdVehicle = vehicleRepository.save(vehicle);
        return createdVehicle;
    }
}
