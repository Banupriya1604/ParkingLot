public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create parking lot
        ParkingLot parkingLot = new ParkingLot("Mall Parking Lot");

        // Add a parking floor
        ParkingFloor floor1 = new ParkingFloor("First Floor");
        parkingLot.addFloor(floor1);

        // Add spots to the floor
        floor1.addSpot(new ParkingSpot("compact"));
        floor1.addSpot(new ParkingSpot("large"));
        floor1.addSpot(new ParkingSpot("motorcycle"));

        // Create a vehicle
        Vehicle car = new Vehicle("car", "ABC123");

        // Park the vehicle
        ParkingTicket ticket = parkingLot.parkVehicle(car);

        // Simulate parking duration by sleeping for 2 seconds
        if (ticket != null) {
            Thread.sleep(2000); // Simulating parking time

            // Exit the vehicle and calculate the fee
            double fee = parkingLot.exitVehicle(ticket);
            System.out.println("Parking fee: $" + fee);
        }
    }
}