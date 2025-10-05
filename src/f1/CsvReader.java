package f1;

import java.nio.file.*; import java.util.*;

// Klase izmantota priekš CSV tipa datu ielasīšanas no csv failiem
public class CsvReader {
    public static List<String[]> read(String path) throws Exception {
        List<String[]> rows = new ArrayList<>();

        for (String line : Files.readAllLines(Path.of(path))) {
            line = line.trim();

            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            rows.add(line.split("\\s*,\\s*"));
        }

        return rows;
    }
}