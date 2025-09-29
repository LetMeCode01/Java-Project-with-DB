public class Car {
    private String model;     
    private String hp;

    public Car(String model, String hp) {
        this.model = model;
        this.hp = hp;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHP() {
        return hp;
    }

    public void setEngine(String hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine='" + hp +
                '}';
    }
}
