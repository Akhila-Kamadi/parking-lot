import controllers.ParkingLotController;
import controllers.TicketController;
import dtos.*;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import services.ParkingLotService;
import services.TicketService;
import strategies.spotassignmentstrategies.RandomSpotAssignmentStrategy;
import strategies.spotassignmentstrategies.SpotAssignmentStrategy;

public class Client {
    public static void main(String[] args) {
        ObjectRegistry.put("ParkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.put("ParkingLotService", new ParkingLotService(
                (ParkingLotRepository) ObjectRegistry.get("ParkingLotRepository")
        ));
        ObjectRegistry.put("ParkingLotController", new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("ParkingLotService")
        ));

        ParkingLotController parkingLotController = (ParkingLotController) ObjectRegistry.get("ParkingLotController");
        CreateParkingLotRequestDto request = new CreateParkingLotRequestDto();
        request.setAddress("Bangalore");
        request.setNumberOfFloors(4);

        CreateParkingLotResponseDto response = parkingLotController.createParkingLot(request);

        if (response.getResponseStatus().equals(ResponseStatusDto.FAILURE)){
            System.out.println("Something went wrong");
        }
        System.out.println(response.getParkingLot());

        UpdateParkingLotRequestDto updateRequest = new UpdateParkingLotRequestDto();
        updateRequest.setAddress("Hyderabad");
        updateRequest.setParkingLotId(1L);

        UpdateParkingLotResponseDto updateResponse = parkingLotController.updateAddress(updateRequest);

        System.out.println(updateResponse);

        ObjectRegistry.put("TicketRepository", new TicketRepository());
        ObjectRegistry.put("SpotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("TicketService", new TicketService(
                (TicketRepository) ObjectRegistry.get("TicketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("SpotAssignmentStrategy")
        ));
        ObjectRegistry.put("TicketController", new TicketController(
                (TicketService) ObjectRegistry.get("TicketService")
        ));

        GenerateTicketRequestDto ticketRequest = new GenerateTicketRequestDto();

    }
}
