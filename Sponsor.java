public class Sponsor {
    private String name;       
    private double contribution; 

    public Sponsor(String name, double contribution) {
        this.name = name;
        this.contribution = contribution;
    }

    public Sponsor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "name='" + name + '\'' +
                ", contribution=$" + contribution +
                '}';
    }
}
