package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    Map<Long, Vehicle> vehicles = new HashMap<>();
    Long lastCount = 0L;

    public Vehicle save(Vehicle vehicle) {
        lastCount += 1;
        vehicle.setId(lastCount);
        vehicles.put(lastCount, vehicle);
        return vehicle;
    }
}
