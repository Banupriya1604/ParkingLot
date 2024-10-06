import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<ParkingFloor> floors;

    public ParkingLot(String name) {
        this.name = name;
        this.floors = new ArrayList<>();
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findSpot(vehicle);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findSpot(vehicle);
        if (spot != null) {
            return spot.parkVehicle(vehicle);
        } else {
            System.out.println("No spot available for this vehicle.");
            return null;
        }
    }

    public double exitVehicle(ParkingTicket ticket) {
        return ticket.getSpot().exitVehicle(ticket);
    }
}