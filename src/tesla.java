public class tesla extends Car{
    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public int getHorsePower() {
        return super.getHorsePower();
    }

    @Override
    public void setHorsePower(int horsePower) {
        super.setHorsePower(horsePower);
    }

    @Override
    public int getCategory() {
        return super.getCategory();
    }

    @Override
    public void setCategory(int category) {
        super.setCategory(category);
    }

    @Override
    public float getDifferencial() {
        return super.getDifferencial();
    }

    @Override
    public void setDifferencial(float differencial) {
        super.setDifferencial(differencial);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public tesla(String model, int horsePower, int category, float differencial) {
        super(model, horsePower, category, differencial);
    }
}
