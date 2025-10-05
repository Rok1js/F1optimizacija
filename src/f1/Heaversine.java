package f1;


import static java.lang.Math.*;

// Klasi izmanto lai aprēķinātu attālumus starp dažādiem F1 posmiem
public class Heaversine {
    private static final double earthRadius = 6378.0; // Aptuveni km

    public static double distanceBetweenPlaces(
            double lat1,
            double lon1,
            double lat2,
            double lon2
    ) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double diffLat = toRadians(lat2 - lat1);
        double diffLon = toRadians(lon2 - lon1);
        double a = pow(sin(diffLat / 2), 2)
                + pow(sin(diffLon / 2), 2)
                        * cos(lat1Rad)
                        * cos(lat2Rad);

        return 2 * earthRadius * asin(sqrt(a));
    }
}
