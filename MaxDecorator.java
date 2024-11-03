
public class MaxDecorator extends ValueDecorator {
    private double max;

    public MaxDecorator(ValueStrategy vs, double max) {
        super(vs);
        this.max = max;

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
        if (temperature > max) {
            return max;
        } else {
            return temperature;
        }
    }

}