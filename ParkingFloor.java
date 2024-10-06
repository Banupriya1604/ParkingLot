import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private String name;
    private List<ParkingSpot> spots;

    public ParkingFloor(String name) {
        this.name = name;
        this.spots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
        return null;
    }
}