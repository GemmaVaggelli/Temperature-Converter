import javax.swing.*;
import java.awt.event.*;

public class View implements Observer {
    private TemperatureModel tm;
    private JTextField tfTemp;

    public View(TemperatureModel tm, JTextField tfTemp, JButton bInc, JButton bDec) {
        this.tm = tm;
        this.tfTemp = tfTemp;
        this.tfTemp.setText(String.format("%.1f", tm.getValue()));

        bInc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increaseTemperature();
            }
        });
        bDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decreaseTemperature();
            }
        });
    }

    @Override
    public void update(Observable obs) {
        tfTemp.setText(String.format("%.1f", obs.getValue()));
    }

    public void increaseTemperature() {
        double currentTemperature = tm.getValue();
        tm.setValue(currentTemperature + 1);
    }

    public void decreaseTemperature() {
        double currentTemperature = tm.getValue();
        tm.setValue(currentTemperature - 1);
    }

}