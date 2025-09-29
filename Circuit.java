public class Circuit {
    private String name;       
    private String location;   
    private double lengthKm;    
    private double lapRecord;  

    public Circuit(String name, String location, double lengthKm, double lapRecord) {
        this.name = name;
        this.location = location;
        this.lengthKm = lengthKm;
        this.lapRecord = lapRecord;
    }

    public Circuit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLengthKm() {
        return lengthKm;
    }

    public void setLengthKm(double lengthKm) {
        this.lengthKm = lengthKm;
    }

    public double getLapRecord() {
        return lapRecord;
    }

    public void setLapRecord(double lapRecord) {
        this.lapRecord = lapRecord;
    }

    @Override
    public String toString() {
        return "Circuit{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", lengthKm=" + lengthKm +
                ", lapRecord=" + lapRecord +
                '}';
    }
}
