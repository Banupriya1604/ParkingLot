public class ParkingSpot {
    private String spotType;
    private Vehicle vehicle;

    public ParkingSpot(String spotType) {
        this.spotType = spotType;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        switch (spotType) {
            case "compact":
                return vehicle.getVehicleType().equals("car");
            case "large":
                return vehicle.getVehicleType().equals("car") || vehicle.getVehicleType().equals("truck");
            case "motorcycle":
                return vehicle.getVehicleType().equals("bike");
            default:
                return false;
        }
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if (isAvailable() && canFitVehicle(vehicle)) {
            this.vehicle = vehicle;
            return new ParkingTicket(this, vehicle);
        }
        return null;
    }

    public double exitVehicle(ParkingTicket ticket) {
        if (ticket.getVehicle().equals(this.vehicle)) {
            this.vehicle = null;
            long duration = ticket.calculateDuration();
            return Payment.calculateFee(duration);
        }
        return 0;
    }
}