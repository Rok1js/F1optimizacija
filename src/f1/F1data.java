package f1;

import java.util.*;

public class F1data {
    public final int totalWeeks;
    public final Race[] races;
    public final double[][] distanceKm;
    public final double[][] revenue;
    public final boolean[][] forbid;
    public final double lambda;

    public F1data(String raceData, String raceRevenue, String raceForbids) throws Exception {
        // Ielasam posmu datus
        List<String[]> racesList = CsvReader.read(raceData);
        int raceLength = racesList.size() - 1;

        races = new Race[raceLength];

        for (int i = 1; i < raceLength + 1; i++) {
            String[] values = racesList.get(i);
            races[i - 1] = new Race(
                    Integer.parseInt(values[0]),
                    values[1],
                    values[2],
                    Double.parseDouble(values[3]),
                    Double.parseDouble(values[4])
            );
        }

        this.totalWeeks = raceLength;

        // Ielasam katra posma ieņēmumus
        List<String[]> revenueData = CsvReader.read(raceRevenue);
        revenue = new double[totalWeeks][totalWeeks];
        for (int i = 1; i < revenueData.size() ; i++) {
            String[] values = revenueData.get(i);
            int raceId = Integer.parseInt(values[0]);

            for (int week = 1; week < totalWeeks; week++) {
                revenue[raceId][week - 1] = Double.parseDouble(values[week]);
            }
        }

        // Ielasam datus, kad katrs posms ir kategoriski aizliegts
        List<String[]> forbitsData = CsvReader.read(raceForbids);
        forbid = new boolean[totalWeeks][totalWeeks];
        for (int i = 1; i < forbitsData.size(); i++) {
            String[] values = forbitsData.get(i);
            int raceId = Integer.parseInt(values[0]);
            int raceWeek = Integer.parseInt(values[1]);

            forbid[raceId][raceWeek] = true;
        }

        // Apreķinam distances starp posmiem un ieliekam NxN matricā
        distanceKm = new double[totalWeeks][totalWeeks];
        for (int i = 0; i < totalWeeks - 1; i++) {
            for (int j = 0; j < totalWeeks - 1; j++) {
                distanceKm[i][j] = Heaversine.distanceBetweenPlaces(
                        races[i].lat,
                        races[i].lon,
                        races[j].lat,
                        races[j].lon);
            }
        }

        // Uzliekam lambdu, ka katri 5000km izmaksā 100 vienības
        this.lambda = 100.0 / 5000.0;
    }
}
