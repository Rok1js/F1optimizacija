package f1;

import java.util.*;

public class Schedule {
    public final F1data data;
    public int[] weekToRace;
    public final int raceLength;

    public Schedule(F1data data) {
        this.data = data;
        this.weekToRace = new int[data.races.length];
        this.raceLength = data.races.length;
    }

    // Nejauši izvēlēts posmu sākuma plānojums
    public static Schedule random(F1data data, Random rnd) {
        Schedule schedule = new Schedule(data);

        for (int week = 0; week < schedule.raceLength ; week++) {
            schedule.weekToRace[week] = week;
        }

        // Samainām posmus nejaušā secībā
        for (int i = schedule.raceLength - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            schedule.swapWeeksInPlace(i,j);
        }

        return schedule;
    }

    public void swapWeeksInPlace(int week1, int week2) {
        int temp = weekToRace[week1];
        weekToRace[week1] = weekToRace[week2];
        weekToRace[week2] = temp;
    }

    public Schedule copy() {
        Schedule copy = new Schedule(data);
        copy.weekToRace = this.weekToRace.clone();
        return copy;
    }

    public double score() {
        double value = 0.0;
        double travelKm = 0.0;

        for (int week = 0; week < raceLength; week++) {
            int raceId = weekToRace[week];

            if (data.forbid[raceId][week]) {
                return -1e12; // Atgriežam ļoti mazu rezultātu, jo šādā secībā posms ir stingri aizliegts
            }

            value += data.revenue[raceId][week]; // Pieliekam ieņēmumus no posmiem.
        }

        for (int week = 0; week < raceLength - 1; week++) {
            int raceId1 = weekToRace[week];
            int raceId2 = weekToRace[week + 1];
            travelKm += data.distanceKm[raceId1][raceId2];
        }

        value -= data.lambda * travelKm; // uzliekam "sodu" par pārāk garu distanci starp posmiem.

        return value;
    }

}
