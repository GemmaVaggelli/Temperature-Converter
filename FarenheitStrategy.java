
public class FarenheitStrategy implements ValueStrategy {
    private double FARENHEIT_OFFSET = 459.67;
    private double FARENHEIT_SCALE = ((double) 9 / 5);

    @Override
    public double fromKelvin(double temperature) {
        return (temperature * FARENHEIT_SCALE) - FARENHEIT_OFFSET;
    }

    @Override
    public double toKelvin(double temperature) {
        return (temperature + FARENHEIT_OFFSET) / FARENHEIT_SCALE;
    }

}