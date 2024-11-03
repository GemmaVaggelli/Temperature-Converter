
public class CelsiusStrategy implements ValueStrategy {
    private double CELSIUS_OFFSET = 273.15;

    @Override
    public double fromKelvin(double temperature) {
        return temperature - CELSIUS_OFFSET;
    }

    @Override
    public double toKelvin(double temperature) {
        return temperature + CELSIUS_OFFSET;
    }

}