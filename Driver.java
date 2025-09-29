public class Driver extends Employee {
    private String nationality;


    public Driver(String name, double salary, String nationality) {
        super(name, salary);  
        this.nationality = nationality;
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + nationality + "]";
    }
}
