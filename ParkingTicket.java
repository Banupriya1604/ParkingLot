public class ParkingTicket {
    private ParkingSpot spot;
    private Vehicle vehicle;
    private long timeIn;
    private long timeOut;

    public ParkingTicket(ParkingSpot spot, Vehicle vehicle) {
        this.spot = spot;
        this.vehicle = vehicle;
        this.timeIn = System.currentTimeMillis();
        this.timeOut = 0;
    }

    public void exit() {
        this.timeOut = System.currentTimeMillis();
    }

    public long calculateDuration() {
        if (timeOut != 0) {
            return timeOut - timeIn;
        }
        return System.currentTimeMillis() - timeIn;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
