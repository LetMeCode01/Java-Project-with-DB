import java.util.List;

public class Team {
    private String name;
    private List<Driver> drivers; 
    private String sponsor;        
    private int points;           

    public Team(String name, List<Driver> drivers, String sponsor, int points) {
        this.name = name;
        this.drivers = drivers;
        this.sponsor = sponsor;
        this.points = points;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Echipa{" +
                "name='" + name + '\'' +
                ", drivers=" + drivers +
                ", sponsor='" + sponsor + '\'' +
                ", points=" + points +
                '}';
    }
}
