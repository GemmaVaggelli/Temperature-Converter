public class TemperatureModel extends Observable {
    private double temperature;
    private ValueStrategy vs;

    public TemperatureModel() {
        this.temperature = 273.15;
    }

    @Override
    public double getValue() {
        return vs.fromKelvin(temperature);
    }

    @Override
    public void setValue(double temperature) {
        this.temperature = vs.toKelvin(temperature);
        notifyObservers();
    }

    public void setStrategy(ValueStrategy vs) {
        MinDecorator minD = new MinDecorator(vs, 263.15);
        MaxDecorator maxD = new MaxDecorator(minD, 343.15);
        this.vs = maxD;
        notifyObservers();
    }
}