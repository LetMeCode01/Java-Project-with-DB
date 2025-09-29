public class Mechanic extends Employee {
    private String specialty;       
    private int experienceYears;   
    private boolean certified;      

    public Mechanic(String name, double salary, String specialty, int experienceYears, boolean certified) {
        super(name, salary); 
        this.specialty = specialty;
        this.experienceYears = experienceYears;
        this.certified = certified;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    @Override
    public String toString() {
        return super.toString() + " [Specialty: " + specialty + ", Experience: " 
               + experienceYears + " yrs, Certified: " + certified + "]";
    }
}
