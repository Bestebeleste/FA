public class Car {
    private String model;
    private int HorsePower;
    private int category;
    private float differencial;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return HorsePower;
    }

    public Car(String model,
               int horsePower,
               int category,
               float differencial) {
        this.model = model;
        HorsePower = horsePower;
        this.category = category;
        this.differencial = differencial;
    }

    public void setHorsePower(int horsePower) {
        HorsePower = horsePower;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getDifferencial() {
        return differencial;
    }

    public void setDifferencial(float differencial) {
        this.differencial = differencial;
    }
}
