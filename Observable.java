import java.util.ArrayList;

public abstract class Observable {
    private ArrayList<Observer> obs = new ArrayList<>();

    public void attach(Observer o) {
        obs.add(o);

    }

    public void detach(Observer o) {
        obs.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : obs) {
            o.update(this);
        }
    }

    public abstract void setValue(double temperature);

    public abstract double getValue();
}
