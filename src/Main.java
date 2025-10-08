import f1.F1data;
import f1.SA;
import f1.Schedule;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {

        F1data data = new F1data(
                "src/data/races_2025_small.csv",
                "src/data/revenue_2025_small.csv",
                "src/data/forbids_2025_small.csv"
        );

        long[] seeds = {11L, 42L, 77L, 101L, 2025L};

        // ------------------ TEST CASE small ------------------
        {
            System.out.println("=== SA small TEST: T0=20, alpha=0.999, iters/T=1500 ===");
            double bestScore = 0;
            double bestMs = 0;
            Schedule best = null;

            for (int i = 0; i < 5; i++) {
                SA sa = new SA(data);
                sa.initialTemp = 20.0;
                sa.alpha = 0.999;
                sa.innerIters = 1500;
                sa.seed = seeds[i];

                long t0 = System.nanoTime();
                Schedule s = sa.run();
                long t1 = System.nanoTime();

                double score = s.score();
                double ms = (t1 - t0) / 1e6;

                if (score > bestScore) {
                    bestScore = score;
                    bestMs = ms;
                    best = s;
                }

                System.out.printf("Test case small, Run %s : score=%.2f  time=%.1f ms%n%n", i + 1, bestScore, ms);
            }
            System.out.printf("BEST (TestSmall): score=%.2f  time=%.1f ms%n%n", bestScore, bestMs);

            System.out.println("Best score schedule:");

            System.out.println("Week   Race");
            System.out.println("----   ----------------------------");
            for (int w = 0; w < Objects.requireNonNull(best).weekToRace.length; w++) {
                int raceId = best.weekToRace[w];
                String raceName = best.data.races[raceId].name;
                System.out.printf("%3d    %s%n", w + 1, raceName);
            }
            System.out.println();
        }

        data = new F1data(
                "src/data/races_2025_full.csv",
                "src/data/revenue_2025_full.csv",
                "src/data/forbids_2025_full.csv"
        );

        // ------------------ TEST CASE 1 ------------------
        {
            System.out.println("=== SA TEST 1: T0=20, alpha=0.999, iters/T=1500 ===");
            double bestScore = 0;
            double bestMs = 0;
            Schedule best = null;

            for (int i = 0; i < 5; i++) {
                SA sa = new SA(data);
                sa.initialTemp = 20.0;
                sa.alpha = 0.999;
                sa.innerIters = 1500;
                sa.seed = seeds[i];

                long t0 = System.nanoTime();
                Schedule s = sa.run();
                long t1 = System.nanoTime();

                double score = s.score();
                double ms = (t1 - t0) / 1e6;

                if (score > bestScore) {
                    bestScore = score;
                    bestMs = ms;
                    best = s;
                }

                System.out.printf("Test case 1, Run %s : score=%.2f  time=%.1f ms%n%n", i + 1, bestScore, ms);
            }
            System.out.printf("BEST (Test1): score=%.2f  time=%.1f ms%n%n", bestScore, bestMs);

            System.out.println("Best score schedule:");

            System.out.println("Week   Race");
            System.out.println("----   ----------------------------");
            for (int w = 0; w < Objects.requireNonNull(best).weekToRace.length; w++) {
                int raceId = best.weekToRace[w];
                String raceName = best.data.races[raceId].name;
                System.out.printf("%3d    %s%n", w + 1, raceName);
            }
            System.out.println();
        }

        // ------------------ TEST CASE 2 ------------------
        {
            System.out.println("=== SA TEST 2: T0=10, alpha=0.995, iters/T=1000 ===");
            double bestScore = 0;
            double bestMs = 0;
            Schedule best = null;

            for (int i = 0; i < 5; i++) {
                SA sa = new SA(data);
                sa.initialTemp = 10.0;
                sa.alpha = 0.995;
                sa.innerIters = 1000;
                sa.seed = seeds[i];

                long t0 = System.nanoTime();
                Schedule s = sa.run();
                long t1 = System.nanoTime();

                double score = s.score();
                double ms = (t1 - t0) / 1e6;

                if (score > bestScore) {
                    bestScore = score;
                    bestMs = ms;
                    best = s;
                }

                System.out.printf("Test case 1, Run %s : score=%.2f  time=%.1f ms%n%n", i + 1, bestScore, ms);
            }
            System.out.printf("BEST (Test2): score=%.2f  time=%.1f ms%n%n", bestScore, bestMs);

            System.out.println("Best score schedule:");

            System.out.println("Week   Race");
            System.out.println("----   ----------------------------");
            for (int w = 0; w < Objects.requireNonNull(best).weekToRace.length; w++) {
                int raceId = best.weekToRace[w];
                String raceName = best.data.races[raceId].name;
                System.out.printf("%3d    %s%n", w + 1, raceName);
            }
            System.out.println();
        }

        // ------------------ TEST CASE 3 ------------------
        {
            System.out.println("=== SA TEST 3: T0=8, alpha=0.990, iters/T=1200 ===");
            double bestScore = 0;
            double bestMs = 0;
            Schedule best = null;

            for (int i = 0; i < 5; i++) {
                SA sa = new SA(data);
                sa.initialTemp = 8.0;
                sa.alpha = 0.990;
                sa.innerIters = 1200;
                sa.seed = seeds[i];

                long t0 = System.nanoTime();
                Schedule s = sa.run();
                long t1 = System.nanoTime();

                double score = s.score();
                double ms = (t1 - t0) / 1e6;

                if (score > bestScore) {
                    bestScore = score;
                    bestMs = ms;
                    best = s;
                }

                System.out.printf("Test case 1, Run %s : score=%.2f  time=%.1f ms%n%n", i + 1, bestScore, ms);
            }
            System.out.printf("BEST (Test3): score=%.2f  time=%.1f ms%n%n", bestScore, bestMs);

            System.out.println("Best score schedule:");

            System.out.println("Week   Race");
            System.out.println("----   ----------------------------");
            for (int w = 0; w < Objects.requireNonNull(best).weekToRace.length; w++) {
                int raceId = best.weekToRace[w];
                String raceName = best.data.races[raceId].name;
                System.out.printf("%3d    %s%n", w + 1, raceName);
            }
            System.out.println();
        }

        // ------------------ TEST CASE 4 ------------------
        {
            System.out.println("=== SA TEST 4: T0=30, alpha=0.997, iters/T=1200 ===");
            double bestScore = 0;
            double bestMs = 0;
            Schedule best = null;

            for (int i = 0; i < 5; i++) {
                SA sa = new SA(data);
                sa.initialTemp = 30.0;
                sa.alpha = 0.997;
                sa.innerIters = 1200;
                sa.seed = seeds[i];

                long t0 = System.nanoTime();
                Schedule s = sa.run();
                long t1 = System.nanoTime();

                double score = s.score();
                double ms = (t1 - t0) / 1e6;

                if (score > bestScore) {
                    bestScore = score;
                    bestMs = ms;
                    best = s;
                }

                System.out.printf("Test case 1, Run %s : score=%.2f  time=%.1f ms%n%n", i + 1, bestScore, ms);
            }
            System.out.printf("BEST (Test4): score=%.2f  time=%.1f ms%n%n", bestScore, bestMs);

            System.out.println("Best score schedule:");

            System.out.println("Week   Race");
            System.out.println("----   ----------------------------");
            for (int w = 0; w < Objects.requireNonNull(best).weekToRace.length; w++) {
                int raceId = best.weekToRace[w];
                String raceName = best.data.races[raceId].name;
                System.out.printf("%3d    %s%n", w + 1, raceName);
            }
            System.out.println();
        }

        // ------------------ TEST CASE 5 ------------------
        {
            System.out.println("=== SA TEST 5: T0=5, alpha=0.985, iters/T=600 ===");
            double bestScore = 0;
            double bestMs = 0;
            Schedule best = null;

            for (int i = 0; i < 5; i++) {
                SA sa = new SA(data);
                sa.initialTemp = 5.0;
                sa.alpha = 0.985;
                sa.innerIters = 600;
                sa.seed = seeds[i];

                long t0 = System.nanoTime();
                Schedule s = sa.run();
                long t1 = System.nanoTime();

                double score = s.score();
                double ms = (t1 - t0) / 1e6;

                if (score > bestScore) {
                    bestScore = score;
                    bestMs = ms;
                    best = s;
                }

                System.out.printf("Test case 1, Run %s : score=%.2f  time=%.1f ms%n%n", i + 1, bestScore, ms);
            }
            System.out.printf("BEST (Test5): score=%.2f  time=%.1f ms%n%n", bestScore, bestMs);

            System.out.println("Best score schedule:");

            System.out.println("Week   Race");
            System.out.println("----   ----------------------------");
            for (int w = 0; w < Objects.requireNonNull(best).weekToRace.length; w++) {
                int raceId = best.weekToRace[w];
                String raceName = best.data.races[raceId].name;
                System.out.printf("%3d    %s%n", w + 1, raceName);
            }
            System.out.println();
        }


        System.out.println("All tests done.");
    }
}