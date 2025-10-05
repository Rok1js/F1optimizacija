package f1;

public class Race {
    public final int id; // Posma id
    public final String name, region; // Posma nosaukums un reģions
    public final double lat, lon; // Posma posma atrašanās kordinātas

    public Race(int id, String name, String region, double lat , double lon)
    {
        this.id = id;
        this.name = name;
        this.region = region;
        this.lat = lat;
        this.lon = lon;
    }
}
