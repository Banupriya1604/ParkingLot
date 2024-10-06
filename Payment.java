public class Payment {
    public static double calculateFee(long durationInMillis) {
        double ratePerHour = 10.0; // Assume a flat rate per hour
        double durationInHours = durationInMillis / (1000.0 * 60 * 60);
        return ratePerHour * durationInHours;
    }
}
