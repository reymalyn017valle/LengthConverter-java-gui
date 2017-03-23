/**FINALS IN JAVA
 * Prepared By: Reymalyn R. Valle and Romari E. Macapagal
 * Course & Section: BSCS 2A
 *
 * @(#)Length_Converter.java
 *
 *
 * @author 
 * @version 1.00 2017/3/19
 */

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;
public class Length_Converter {

    private JButton myButton;
	private JFrame frame;
	private JLabel titleLabel;
    private JLabel centerLabel;
    private JLabel bLabel;
    private JTextField frField;
    private JComboBox<String> fromBox;
    private JPanel toPanel;
    private JPanel frPanel;
    private JPanel bottomPanel;
    private JTextField toField;
    private JComboBox<String> toBox;
    private final String[] lengthTypes = {"Inches", "Centimeters", "Feet", "Miles", "Yards", "Meters", "Millimeters"};
    private final HashMap<String, HashMap<String, Double>> conversions = new HashMap<>();
    
    public void convert() {
    
    	frame = new JFrame("Length Conversion");
    	frame.setSize(600, 300);
    	frame.setLayout(new GridLayout(4,1));
        frPanel = new JPanel();
        centerLabel = new JLabel("To:");
        frField = new JTextField(20);
        fromBox = new JComboBox<>(lengthTypes);
        toPanel = new JPanel();
        bLabel = new JLabel("From:");
        toBox = new JComboBox<>(lengthTypes);
        toField = new JTextField(20);
        toField.setEnabled(false);
        titleLabel = new JLabel("       =====LENGTH CONVERTER=====      ");
        myButton = new JButton("     CONVERT       ");
        bottomPanel = new JPanel();
        myButton.addActionListener(new SubmitListener());

        frPanel.setLayout(new BoxLayout(frPanel, BoxLayout.PAGE_AXIS));
        frPanel.add(bLabel);
        frPanel.add(frField);
        frPanel.add(fromBox);
       
        

        toPanel.setLayout(new BoxLayout(toPanel, BoxLayout.PAGE_AXIS));
        toPanel.add(centerLabel);
        toPanel.add(toField);
        toPanel.add(toBox);
        

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(myButton);

        Font labelFont = new Font("Arial", Font.BOLD, 26);
        titleLabel.setFont(labelFont);
        
        frame.setLayout(new BorderLayout());
        Container window = frame.getContentPane();
        
        
        window.add(BorderLayout.NORTH, titleLabel);
        window.add(BorderLayout.WEST, frPanel);
        window.add(BorderLayout.EAST, toPanel);
   
        window.add(BorderLayout.SOUTH, bottomPanel);
      
        window.setBackground(Color.CYAN);
        myButton.setForeground(Color.WHITE);
        myButton.setBackground(Color.BLACK);
        
        bottomPanel.setLayout(new GridLayout(2,10));
       
        frame.setSize(new Dimension (400, 400));
        bottomPanel.setBackground(Color.CYAN);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);	
    }

    public Length_Converter() {
    	
    		
    		
    	conversions.put("Inches", new HashMap<>());

        conversions.get("Inches").put("Inches", 1.0);
        conversions.get("Inches").put("Centimeters", 2.54);
        conversions.get("Inches").put("Feet", 0.0833333);
        conversions.get("Inches").put("Miles", 0.00001578282828283);
        conversions.get("Inches").put("Yards", 0.0277778);
        conversions.get("Inches").put("Meters", 0.0254);
        conversions.get("Inches").put("Millimeters", 25.4);

        conversions.put("Centimeters", new HashMap<>());

        conversions.get("Centimeters").put("Inches", 0.393701);
        conversions.get("Centimeters").put("Centimeters", 1.0);
        conversions.get("Centimeters").put("Feet", 0.0328084);
        conversions.get("Centimeters").put("Miles", 0.00000621);
        conversions.get("Centimeters").put("Yards", 0.0109361);
        conversions.get("Centimeters").put("Meters", 0.01);
        conversions.get("Centimeters").put("Millimeters", 10.0);

        conversions.put("Feet", new HashMap<>());

        conversions.get("Feet").put("Inches", 12.0);
        conversions.get("Feet").put("Centimeters", 30.48);
        conversions.get("Feet").put("Feet", 1.0);
        conversions.get("Feet").put("Miles", 0.00018939);
        conversions.get("Feet").put("Yards", 0.3333333);
        conversions.get("Feet").put("Meters", 0.3048);
        conversions.get("Feet").put("Millimeters", 304.8);
        
        conversions.put("Miles", new HashMap<>());

        conversions.get("Miles").put("Inches", 63360.0);
        conversions.get("Miles").put("Centimeters", 160934.4);
        conversions.get("Miles").put("Feet", 5280.0);
        conversions.get("Miles").put("Miles", 1.0);
        conversions.get("Miles").put("Yards", 1760.0);
        conversions.get("Miles").put("Meters", 1609.344);
        conversions.get("Miles").put("Millimeters", 1.6093E+6);

        conversions.put("Yards", new HashMap<>());

        conversions.get("Yards").put("Inches", 36.0);
        conversions.get("Yards").put("Centimeters", 91.44);
        conversions.get("Yards").put("Feet", 3.0);
        conversions.get("Yards").put("Miles", 0.00056818);
        conversions.get("Yards").put("Yards", 1.0);
        conversions.get("Yards").put("Meters", 0.9144);
        conversions.get("Yards").put("Millimeters", 914.4);

        conversions.put("Meters", new HashMap<>());

        conversions.get("Meters").put("Inches", 39.3701);
        conversions.get("Meters").put("Centimeters", 100.0);
        conversions.get("Meters").put("Feet", 3.28084);
        conversions.get("Meters").put("Miles", 0.00062137);
        conversions.get("Meters").put("Yards", 1.09361);
        conversions.get("Meters").put("Meters", 1.0);
        conversions.get("Meters").put("Millimeters", 1000.0);

        conversions.put("Millimeters", new HashMap<>());

        conversions.get("Millimeters").put("Inches", 0.0393701);
        conversions.get("Millimeters").put("Centimeters", 0.1);
        conversions.get("Millimeters").put("Feet", 0.00328084);
        conversions.get("Millimeters").put("Miles", 6.2137E-7);
        conversions.get("Millimeters").put("Yards", 0.00109361);
        conversions.get("Millimeters").put("Meters", 0.001);
        conversions.get("Millimeters").put("Millimeters", 1.0);
    }
    
    class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Double numToConvert = Double.parseDouble(frField.getText());
            Double conversionRate = conversions.get(fromBox.getSelectedItem()).get(toBox.getSelectedItem());
            String result = Double.toString(numToConvert * conversionRate);
            int length = result.length();
            if (length > 4) {
                Dimension d = frame.getSize();
                frame.setSize(length + d.width - 16, d.height);
                toField.setColumns(length);
            }
            else {
                toField.setColumns(4);
                frame.pack();
            }
            toField.setText(result);
            frame.revalidate();
            
        }
    }
     public static void main(String[] args){
    	 new Length_Converter().convert();
	
    }
}


	
