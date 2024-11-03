
public class MinDecorator extends ValueDecorator {
    private double min;

    public MinDecorator(ValueStrategy vs, double min) {
        super(vs);
        this.min = min;

    }

    @Override
    public double fromKelvin(double temperature) {
        return super.fromKelvin(limitTemperature(temperature));
    }

    @Override
    public double toKelvin(double temperature) {
        return limitTemperature(super.toKelvin(temperature));
    }

    private double limitTemperature(double temperature) {
        if (temperature < min) {
            return min;
        } else {
            return temperature;
        }
    }

}