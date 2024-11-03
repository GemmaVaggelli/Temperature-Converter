import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main {
    public static void main(String args[]) {
        JFrame f = new JFrame("Thermostat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField tfTemp = new JTextField();
        JButton bInc = new JButton("Increase");
        JButton bDec = new JButton("Decrease");
        JButton bK = new JButton("Kelvin");
        JButton bC = new JButton("Celsius");
        JButton bF = new JButton("Farenheit");
        
        tfTemp.setHorizontalAlignment(JTextField.CENTER);
        tfTemp.setEditable(false);
        tfTemp.setBounds(175, 100, 150, 20);
        bK.setBounds(50, 200, 100, 50);
        bC.setBounds(200, 200, 100, 50);
        bF.setBounds(350, 200, 100, 50);
        bInc.setBounds(100, 300, 100, 50);
        bDec.setBounds(300, 300, 100, 50);
        bInc.setBackground(Color.decode("#98fb98"));
        bInc.setForeground(Color.BLACK);
        tfTemp.setBackground(Color.WHITE);
        bDec.setBackground(Color.decode("#ff6961"));
        bDec.setForeground(Color.BLACK);

        f.add(tfTemp);
        f.add(bK);
        f.add(bC);
        f.add(bF);
        f.add(bInc);
        f.add(bDec);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        TemperatureModel tm = new TemperatureModel();
        tm.setStrategy(new CelsiusStrategy());
        View v = new View(tm, tfTemp, bInc, bDec);
        tm.attach(v);

        bK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tm.setStrategy(new KelvinStrategy());
            }
        });
        bC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tm.setStrategy(new CelsiusStrategy());
            }
        });
        bF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tm.setStrategy(new FarenheitStrategy());
            }
        });

    }
}