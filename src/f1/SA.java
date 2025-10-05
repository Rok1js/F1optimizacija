package f1;

import java.util.Random;

public class SA {
    private final F1data data;
    private final Random random;
    private final int raceLength;

    // SA algoritma konfigurācija
    public double initialTemp   = 5.0;
    public double minTemp       = 1e-3;
    public double alpha         = 0.995;   // Atdzišanas ātrums
    public int    innerIters    = 500;     // Cik reizes mēs ejam cauri katrai temperatūrai
    public long   seed          = 42L;

    public SA(F1data data) {
        this.data = data;
        this.random  = new Random(seed);
        this.raceLength = data.races.length;
    }

    public Schedule run() {
        double Temperature = initialTemp;

        // Sākuma posma nejauša izvēle.
        Schedule current = Schedule.random(data, random);
        double currentScore = current.score();

        // Līdz šim labākais risinājums ir vienīgais risinājums :)
        Schedule best = current.copy();
        double bestScore = currentScore;

        // Pildam līdz temperatūra sasniedz miniāmo temperatūru
        while (Temperature > minTemp) {
            // Katrai temperatūrai pildam N skaitu ciklu
            for (int it = 0; it < innerIters; it++) {
                int week1 = random.nextInt(raceLength);
                int week2 = random.nextInt(raceLength);

                if (week1 == week2) {
                    continue;
                }

                // Mainām nedēļas vietām un aprēķinam jauno rezultātu un deltu
                current.swapWeeksInPlace(week1, week2);
                double newScore = current.score();
                double scoreDelta = newScore - currentScore;

                // Pārbaudam vai jaunais risinājums ir labāks par labāko
                if (newScore > bestScore) {
                    bestScore = newScore;
                    best = current.copy();
                }

                // Pārbaudam vai jaunais risinājums ir labāks par veco
                if (scoreDelta >= 0 || random.nextDouble() < Math.exp(scoreDelta / Temperature)) {
                    currentScore = newScore;
                } else {
                    current.swapWeeksInPlace(week1, week2);
                }
            }
            // Atdzesējam temperatūru
            Temperature *= alpha;
        }

        return best;
    }
}
