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

public class SightSeeingDialog extends JDialog {

    private JComboBox<SightSeeingTour> sightSeeingTourComboBox;
    private JTextField descriptionTextField;
    private JTextField locationTextField;
    private JTextField tourcostTextField;
    private JTextField ticketcostTextField;
    private JTextField datetimeTextField;
    private JButton clearButton;
    private JButton confirmButton;

    private ArrayList<SightSeeingTour> sightSeeingTourList;

    // Constructor
    public SightSeeingDialog(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("SightSeeing Tour Package");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        sightSeeingTourList = new ArrayList<>(Arrays.asList(
                new SightSeeingTour("Kim", "Benahei", 29, 34),
                new SightSeeingTour("Linzi", "Nilefalls", 38, 50)
        ));

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        

        JLabel touristLabel = new JLabel("Select Tourist:");
        touristLabel.setBounds(20, 20, 100, 25);
        panel.add(touristLabel);

        sightSeeingTourComboBox = new JComboBox<>(sightSeeingTourList.toArray(new SightSeeingTour[0]));
        sightSeeingTourComboBox.setBounds(130, 20, 200, 25);
        panel.add( sightSeeingTourComboBox);

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
        

        
       JLabel tourcostLabel = new JLabel("Tour Cost:");
       tourcostLabel.setBounds(20, 100, 100, 25);
        panel.add(tourcostLabel);

        tourcostTextField = new JTextField();
        tourcostTextField.setBounds(130, 100, 200, 25);
        panel.add(tourcostTextField);

        clearButton = new JButton("Clear  Sight Seeing City Tour");
        clearButton.setBounds(50, 150, 120, 30);
        panel.add(clearButton);

        confirmButton = new JButton("Save Sight Seeing Tour");
        confirmButton.setBounds(200, 150, 130, 30);
        panel.add(confirmButton);

        add(panel);

        // ComboBox selection listener
         sightSeeingTourComboBox.addActionListener(e -> {
            SightSeeingTour s = (SightSeeingTour)  sightSeeingTourComboBox.getSelectedItem();
            if (s != null) {
                descriptionTextField.setText(s.getDescription());
                locationTextField.setText(s.getLocation());
                tourcostTextField.setText(String.valueOf(s.getTourCost()));
                ticketcostTextField.setText(String.valueOf(s.getTicketCost()));
            }
        });

        // Clear/New button
        clearButton.addActionListener(e -> {
            descriptionTextField.setText("");
            locationTextField.setText("");
            tourcostTextField.setText("");
            ticketcostTextField.setText("");
            datetimeTextField.setText("");
             sightSeeingTourComboBox.setSelectedIndex(-1);
        });

        // Confirm/Save button
        confirmButton.addActionListener(e -> {

    String description = descriptionTextField.getText().trim();
    String location = locationTextField.getText().trim();
    String tourCostStr = tourcostTextField.getText().trim();
    String ticketCostStr = tourcostTextField.getText().trim();
  

    // Check empty fields FIRST
    if (!description.isEmpty() && !location.isEmpty()
            && !tourCostStr.isEmpty()&& !ticketCostStr.isEmpty()) {

        try {
            int tourCost = Integer.parseInt(tourCostStr);
            int ticketCost = Integer.parseInt(tourCostStr);
           

          

            SightSeeingTour s = new SightSeeingTour(description, location, tourCost, ticketCost);

            sightSeeingTourList.add(s);
             sightSeeingTourComboBox.setModel(
                new DefaultComboBoxModel<>(sightSeeingTourList.toArray(new SightSeeingTour[0]))
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
        SwingUtilities.invokeLater(() -> {
            SightSeeingDialog dialog = new SightSeeingDialog(new JFrame(), true);
            dialog.setVisible(true);
        });
    }
}

