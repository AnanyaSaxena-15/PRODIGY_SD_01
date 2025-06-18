import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class TemperatureConverterProgram extends JFrame implements ActionListener {

    JTextField inputField;
    JComboBox<String> unitBox;
    JButton convertButton;
    JLabel resultLabel1, resultLabel2;

    public TemperatureConverterProgram() {
        setTitle("Temperature Converter");
        setSize(550,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240,240,240)); 
        
        JLabel label0= new JLabel("TEMPERATURE CONVERTER");
        label0.setBounds(170,20,180,45);
        add(label0);
        
        JLabel label1 = new JLabel("Enter Temperature:");
        label1.setBounds(130, 100, 150, 25);
        add(label1);

        inputField = new JTextField();
        inputField.setBounds(270, 100, 120, 25);
        add(inputField);

        JLabel label2 = new JLabel("Select Unit:");
        label2.setBounds(130, 150, 100, 25);
        add(label2);

        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        unitBox = new JComboBox<>(units);
        unitBox.setBounds(270, 150, 120, 25);
        add(unitBox);

        convertButton = new JButton("Convert");
        convertButton.setBounds(200, 210, 120, 30);
        convertButton.addActionListener(this);
        add(convertButton);
        convertButton.setBackground(new Color(0, 120, 215));
        convertButton.setForeground(Color.WHITE);
        
        resultLabel1 = new JLabel();
        resultLabel1.setBounds(130, 260, 280, 25);
        add(resultLabel1);

        resultLabel2 = new JLabel();
        resultLabel2.setBounds(130, 290, 280, 25);
        add(resultLabel2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double temp = Double.parseDouble(inputField.getText());
            String unit = (String) unitBox.getSelectedItem();

            if (unit.equals("Celsius")) {
                double f = temp * 9 / 5 + 32;
                double k = temp + 273.15;
                resultLabel1.setText("Fahrenheit: " + f + " °F");
                resultLabel2.setText("Kelvin: " + k + " K");
            } else if (unit.equals("Fahrenheit")) {
                double c = (temp - 32) * 5 / 9;
                double k = c + 273.15;
                resultLabel1.setText("Celsius: " + c + " °C");
                resultLabel2.setText("Kelvin: " + k + " K");
            } else if (unit.equals("Kelvin")) {
                double c = temp - 273.15;
                double f = c * 9 / 5 + 32;
                resultLabel1.setText("Celsius: " + c + " °C");
                resultLabel2.setText("Fahrenheit: " + f + " °F");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverterProgram();
    }
}
