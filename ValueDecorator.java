
public abstract class ValueDecorator implements ValueStrategy {
    private ValueStrategy vs;

    public ValueDecorator(ValueStrategy vs) {
        this.vs = vs;

    }

    @Override
    public double fromKelvin(double temperature) {
        return vs.fromKelvin(temperature);
    }

    @Override
    public double toKelvin(double temperature) {
        return vs.toKelvin(temperature);
    }

}