/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

/**
 *
 * @author astel
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class CityTourDialog extends JDialog {

    private JComboBox<CityTour> cityTourComboBox;
    private JTextField descriptionTextField;
    private JTextField locationTextField;
    private JTextField tourcostTextField;
     private JTextField guidecostTextField;
    private JTextField datetimeTextField;
    JRadioButton withGuideCost = new JRadioButton("With Guide");
    JRadioButton withoutGuideCost = new JRadioButton("Without Guide");
    private JButton clearButton;
    private JButton confirmButton;

    private ArrayList<CityTour> cityTourList;

    // Constructor
    public CityTourDialog(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("City Tour Package");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cityTourList = new ArrayList<>(Arrays.asList(
                new CityTour("John", "London", 29, false, 34),
                new CityTour("Robert", "Rugby", 39, true, 50)
        ));

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        ButtonGroup group = new ButtonGroup();
        group.add(withGuideCost);
        group.add(withoutGuideCost);
        panel.add(withGuideCost);
        panel.add(withoutGuideCost);
        withGuideCost.setBounds(50, 200, 150, 25);
        withoutGuideCost.setBounds(200, 200, 150, 25);

        JLabel touristLabel = new JLabel("Select Tourist:");
        touristLabel.setBounds(20, 20, 100, 25);
        panel.add(touristLabel);

        cityTourComboBox = new JComboBox<>(cityTourList.toArray(new CityTour[0]));
        cityTourComboBox.setBounds(130, 20, 200, 25);
        panel.add(cityTourComboBox);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(20, 60, 100, 25);
        panel.add(descriptionLabel);

        descriptionTextField = new JTextField();
        descriptionTextField.setBounds(130, 60, 200, 25);
        panel.add(descriptionTextField);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(20, 100, 100, 25);
        panel.add(locationLabel);

        locationTextField = new JTextField();
        locationTextField.setBounds(130, 100, 200, 25);
        panel.add(locationTextField);
        
        JLabel guidecostLabel = new JLabel("Guide Cost:");
        guidecostLabel.setBounds(20, 100, 100, 25);
        panel.add(guidecostLabel);

        guidecostTextField = new JTextField();
        guidecostTextField.setBounds(130, 100, 200, 25);
        panel.add(guidecostTextField);
        
       JLabel tourcostLabel = new JLabel("Tour Cost:");
       tourcostLabel.setBounds(20, 100, 100, 25);
        panel.add(tourcostLabel);

        tourcostTextField = new JTextField();
        tourcostTextField.setBounds(130, 100, 200, 25);
        panel.add(tourcostTextField);

        clearButton = new JButton("Clear  City Tour");
        clearButton.setBounds(50, 150, 120, 30);
        panel.add(clearButton);

        confirmButton = new JButton("Save City Tour");
        confirmButton.setBounds(200, 150, 130, 30);
        panel.add(confirmButton);

        add(panel);

        // ComboBox selection listener
        cityTourComboBox.addActionListener(e -> {
            CityTour c = (CityTour) cityTourComboBox.getSelectedItem();
            if (c != null) {
                descriptionTextField.setText(c.getDescription());
                locationTextField.setText(c.getLocation());
                guidecostTextField.setText(String.valueOf(c.getGuideCost()));
                tourcostTextField.setText(String.valueOf(c.getTourCost()));
            }
        });

        // Clear/New button
        clearButton.addActionListener(e -> {
            descriptionTextField.setText("");
            locationTextField.setText("");
            guidecostTextField.setText("");
            datetimeTextField.setText("");
            cityTourComboBox.setSelectedIndex(-1);
        });

        // Confirm/Save button
        confirmButton.addActionListener(e -> {

    String description = descriptionTextField.getText().trim();
    String location = locationTextField.getText().trim();
    String tourCostStr = tourcostTextField.getText().trim();
    String guideCostStr = guidecostTextField.getText().trim();

    // Check empty fields FIRST
    if (!description.isEmpty() && !location.isEmpty()
            && !tourCostStr.isEmpty() && !guideCostStr.isEmpty()) {

        try {
            int tourCost = Integer.parseInt(tourCostStr);
            int guideCost = Integer.parseInt(guideCostStr);

            // Example boolean (adjust to your radio button)
            boolean isWithGuide = withGuideCost.isSelected();

            CityTour c = new CityTour(description, location, tourCost, isWithGuide, guideCost);

            cityTourList.add(c);
            cityTourComboBox.setModel(
                new DefaultComboBoxModel<>(cityTourList.toArray(new CityTour[0]))
            );

            JOptionPane.showMessageDialog(this, "City Tour saved!");
            clearButton.doClick();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Costs must be numbers");
        }

    } else {
        JOptionPane.showMessageDialog(this, "Please fill all fields");
    }
});
    }

    public static void main(String[] args) {
        /*
        S0wingUtilities.invokeLater(() -> {
            TouristDetailsDialog dialog = new TouristDetailsDialog(new JFrame(), true);
            dialog.setVisible(true);
        });
        */
    }
}
