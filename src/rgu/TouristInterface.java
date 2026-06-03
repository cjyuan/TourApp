/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author astel
 */
public class TouristInterface extends javax.swing.JFrame {
    
    private DefaultComboBoxModel<Tourist> touristModel;
    private JComboBox<Tourist> touristComboBox;
    private JComboBox<TourPackage> tourPackageComboBox;
    private JComboBox<Booking> bookingComboBox;
    private JComboBox<AudioLanguage> audLangComboBox;
    
    private JTextField descriptionTextField;
    private JTextField locationTextField;
    private JTextField tourcostTextField;
    private JTextField ticketcostTextField;
    private JTextField datetimeTextField;
    
    private JTextField nameTextField;
    private JTextField countryTextField;
    private JButton createBookingButton;
    private JButton cancelBookingButton;
    private JButton newTouristButton;
    private JButton viewBillButton;
    private JButton saveTouristButton;
    private JButton newTourPackageButton;
    private JButton saveTourPackageButton;
    private JTextField description1TextField;
    private JTextField location1TextField;
    private JTextField ticketTextField;
    private JTextField guidecostTextField;
    private JTabbedPane tabPanel;
    
    private ArrayList<Tourist> touristList = new ArrayList<>(Arrays.asList(
            new Tourist("John", "London", AudioLanguage.FRENCH),
            new Tourist("Robert", "Rugby", AudioLanguage.ENGLISH)
    ));
    private ArrayList<TourPackage> tourPackageList = new ArrayList<>(Arrays.asList(
            new CityTour("John", "London", 29, false, 34),
            new CityTour("Robert", "Rugby", 39, true, 50),
            new SightSeeingTour("Kim", "Benahei", 29, 34),
            new SightSeeingTour("Linzi", "Nilefalls", 38, 50)
    ));
    
    private ArrayList<Booking> bookingList = new ArrayList<>(Arrays.asList());
    
    public TouristInterface() {
        initComponents();
    }
    
    private void initComponents() {
        
        setTitle("Tourist System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buildUI();
        
        setVisible(true);
    }
    
    private void buildUI() {

        // Create the first tab (page1) and add a JLabel to it
        JPanel panel1 = createPanel1();
        JPanel panel2 = createPanel2();
        JPanel panel3 = createPanel3();

        // Add the three tabs to the JTabbedPane
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // --- Horizontal layout ---
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        // Column 1: labels
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panel1)
                                .addComponent(panel2)
                                .addComponent(panel3)
                        )
        );

        // --- Vertical layout ---
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(panel1)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(panel2)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(panel3)
                        )
        );
        
        add(panel);
    }
    
    private JPanel createPanel1() {
        
        touristModel = new DefaultComboBoxModel<>();
        touristComboBox = new JComboBox<>(touristModel);
        
        for (Tourist t : touristList) {
            touristModel.addElement(t);
        }
        
        tourPackageComboBox = new JComboBox<>(tourPackageList.toArray(new TourPackage[0]));
        bookingComboBox = new JComboBox<>(bookingList.toArray(new Booking[0]));
        
        JLabel touristLabel = new JLabel("Tourists");
        JLabel tourPackageLabel = new JLabel("Tour Packages");
        
        JLabel datetimeLabel = new JLabel("Date and Time");
        JLabel bookingLabel = new JLabel("Booking");
        
        datetimeTextField = new JTextField();
        
        createBookingButton = new JButton("Create Booking");
        
        createBookingButton.addActionListener(event -> {
            createBookingButtonClicked();
        });
        
        cancelBookingButton = new JButton("Cancel Booking");
        
        cancelBookingButton.addActionListener(event -> {
            cancelBookingButtonClicked();
        });
        
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Optional but helpful
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // --- Horizontal layout ---
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        // Column 1: labels
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(touristLabel)
                                .addComponent(tourPackageLabel)
                                .addComponent(datetimeLabel)
                                .addComponent(bookingLabel)
                        )
                        // Column 2: inputs
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(touristComboBox)
                                .addComponent(tourPackageComboBox)
                                .addComponent(datetimeTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookingComboBox)
                        )
                        // Column 3: button (only used in row 3)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(createBookingButton) // row 3
                                .addComponent(cancelBookingButton) // row 3               
                        )
        );

        // --- Vertical layout ---
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(touristLabel)
                                .addComponent(touristComboBox)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(tourPackageLabel)
                                .addComponent(tourPackageComboBox)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(datetimeLabel)
                                .addComponent(datetimeTextField)
                                .addComponent(createBookingButton)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(bookingLabel)
                                .addComponent(bookingComboBox)
                                .addComponent(cancelBookingButton)
                        )
        );
        
        return panel;
    }
    
    private JPanel createPanel2() {
        
        audLangComboBox = new JComboBox<>(AudioLanguage.values());
        
        JLabel touristLabel = new JLabel("Tourist");
        JLabel nameLabel = new JLabel("Name");
        JLabel countryLabel = new JLabel("Country");
        JLabel audioGuideLabel = new JLabel("Audio Guide");
        
        newTouristButton = new JButton("New Tourist");
        saveTouristButton = new JButton("Save Tourist");
        viewBillButton = new JButton("View Bill");
        nameTextField = new JTextField();
        countryTextField = new JTextField();
        
        newTouristButton.addActionListener(event -> {
            nameTextField.setText("");
            countryTextField.setText("");
            audLangComboBox.setSelectedIndex(-1);
        });
        
        saveTouristButton.addActionListener(event -> {
            saveTouristButtonClicked();
        });
        
        viewBillButton.addActionListener(event -> {
            
            BookingUtil a = new BookingUtil();
            
            Tourist t = (Tourist) touristComboBox.getSelectedItem();
            
            if (t == null) {
                JOptionPane.showMessageDialog(null, "Please select a tourist");
                return;
            }
            
            double[] bill = a.calculateBill(bookingList, t);
            
            JOptionPane.showMessageDialog(
                    null,
                    "Your total bill is " + bill[0]
                    + "\nYour discounted bill is " + bill[1]
            );
        });
        
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Optional but helpful
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // --- Horizontal layout ---
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        // Column 1: labels
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(touristLabel)
                                .addComponent(nameLabel)
                                .addComponent(countryLabel)
                                .addComponent(audioGuideLabel)
                        )
                        // Column 2: inputs
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGap(0)
                                .addComponent(nameTextField)
                                .addComponent(countryTextField)
                                .addComponent(audLangComboBox)
                        )
                        // Column 3: buttons
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(newTouristButton)
                                        .addComponent(viewBillButton)
                                )
                                .addGap(0)
                                .addGap(0)
                                .addComponent(saveTouristButton)
                        )
        );

        // --- Vertical layout ---
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(touristLabel)
                                .addComponent(newTouristButton)
                                .addComponent(viewBillButton)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLabel)
                                .addComponent(nameTextField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(countryLabel)
                                .addComponent(countryTextField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(audioGuideLabel)
                                .addComponent(audLangComboBox)
                                .addComponent(saveTouristButton)
                        )
        );
        
        return panel;
        
    }
    
    JRadioButton withGuideCost = new JRadioButton("Yes");
    JRadioButton withoutGuideCost = new JRadioButton("No");
    
    JRadioButton withCity = new JRadioButton("City Tour");
    JRadioButton withSightSeeing = new JRadioButton("SightSeeing Tour");
    
    private JPanel createPanel3_1() {
        JLabel desLabel = new JLabel("Description");
        JLabel locationLabel = new JLabel("Location");
        JLabel tourCostLabel = new JLabel("Tour Cost");
        
        descriptionTextField = new JTextField();
        locationTextField = new JTextField();
        tourcostTextField = new JTextField();
        
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        // Column 1: labels
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(desLabel)
                                .addComponent(locationLabel)
                                .addComponent(tourCostLabel)
                        )
                        // Column 2: inputs
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(descriptionTextField)
                                .addComponent(locationTextField)
                                .addComponent(tourcostTextField)
                        )
        );

        // --- Vertical layout ---
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(desLabel)
                                .addComponent(descriptionTextField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(locationLabel)
                                .addComponent(locationTextField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(tourCostLabel)
                                .addComponent(tourcostTextField)
                        )
        );
        
        return panel;
    }
    
    private JPanel createPanel3_2() {
        
        JLabel withGuideLabel = new JLabel("With Guide");
        JLabel guideCostLabel = new JLabel("Cost for the Guide (£)");
        
        guidecostTextField = new JTextField();
        
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        panel.setBorder(raisedetched);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        // Column 1: labels
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(withCity)
                                .addComponent(withGuideLabel)
                                .addComponent(guideCostLabel)
                        )
                        // Column 2: inputs
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(withGuideCost)
                                        .addComponent(withoutGuideCost)
                                )
                                .addComponent(guidecostTextField)
                        )
        );

        // --- Vertical layout ---
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(withCity)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(withGuideLabel)
                                .addComponent(withGuideCost)
                                .addComponent(withoutGuideCost)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(guideCostLabel)
                                .addComponent(guidecostTextField)
                        )
        );
        
        return panel;
    }
    
    private JPanel createPanel3_3() {
        
        JLabel ticketCostLabel = new JLabel("Cost for the Tickets (£)");
        ticketcostTextField = new JTextField();
        
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        panel.setBorder(raisedetched);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        // Column 1: labels
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(withSightSeeing)
                                .addComponent(ticketCostLabel)
                        )
                        // Column 2: inputs
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(ticketcostTextField)
                        )
        );

        // --- Vertical layout ---
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(withSightSeeing)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(ticketCostLabel)
                                .addComponent(ticketcostTextField)
                        )
        );
        
        return panel;
    }
    
    private JPanel createPanel3() {
        
        JLabel tourPackageLabel = new JLabel("Tour Package");
        
        newTourPackageButton = new JButton("New TourPackage");
        saveTourPackageButton = new JButton("Save TourPackage");
        
        ButtonGroup guideGroup = new ButtonGroup();
        guideGroup.add(withGuideCost);
        guideGroup.add(withoutGuideCost);
        withoutGuideCost.addActionListener(event -> {
            if (withoutGuideCost.isSelected()) {
                guidecostTextField.setText("0");
            }
        });
        withGuideCost.setSelected(true);
        
        ButtonGroup tourTypeGroup = new ButtonGroup();
        tourTypeGroup.add(withSightSeeing);
        tourTypeGroup.add(withCity);
        withCity.setSelected(true);
        
        JPanel p1 = createPanel3_1();
        JPanel p2 = createPanel3_2();
        JPanel p3 = createPanel3_3();
        
        newTourPackageButton.addActionListener(event -> {
            descriptionTextField.setText("");
            locationTextField.setText("");
            tourcostTextField.setText("");
            guidecostTextField.setText("");
            ticketcostTextField.setText("");
        });
        
        saveTourPackageButton.addActionListener(event -> {
            saveTourPackageButtonClicked();
        });
        
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        // Row A (full width)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(tourPackageLabel)
                                .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
                                .addComponent(newTourPackageButton)
                        )
                        // Middle row: 3 panels
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(p1)
                                .addComponent(p2)
                                .addComponent(p3)
                        )
                        // Row C (right aligned or full width)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
                                .addComponent(saveTourPackageButton)
                        )
        );
        
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        // Row A
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(tourPackageLabel)
                                .addComponent(newTourPackageButton)
                        )
                        // Row B (3 panels side by side)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(p1)
                                .addComponent(p2)
                                .addComponent(p3)
                        )
                        // Row C
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(saveTourPackageButton)
                        )
        );
        
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TouristInterface().setVisible(true);
        });
    }
    
    void createBookingButtonClicked() {
        
        Tourist tourist = (Tourist) touristComboBox.getSelectedItem();
        if (tourist == null) {
            JOptionPane.showMessageDialog(null, "Please select a tourist");
            return;
        }
        
        TourPackage tourPackage = (TourPackage) tourPackageComboBox.getSelectedItem();
        if (tourPackage == null) {
            JOptionPane.showMessageDialog(null, "Please select a Tour Package");
            return;
        }
        // 3. Validate date input
        String datetimeStr = datetimeTextField.getText().trim();
        if (datetimeStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter Date and Time");
            return;
        }
        
        try {
            // 4. Convert String → Date
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date datetime = formatter.parse(datetimeStr);

            // 5. Create Booking object (matches your class constructor)
            Booking booking = new Booking(tourist, tourPackage, datetime);

            // 6. Store booking in list
            bookingList.add(booking);

            // 7. Update combo box (so UI reflects new booking)
            bookingComboBox.addItem(booking);

            // 8. Success message
            JOptionPane.showMessageDialog(null, "Booking created successfully!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Invalid date format.\nUse: dd/MM/yyyy HH:mm:ss");
        }
    }
    
    void cancelBookingButtonClicked() {
        
        Object selected = bookingComboBox.getSelectedItem();
        
        if (selected == null) {
            JOptionPane.showMessageDialog(null, "Please select a booking to cancel");
            return;
        }
        
        bookingComboBox.removeItem(selected);
        
        JOptionPane.showMessageDialog(null, "Booking cancelled successfully");
    }
    
    void saveTourPackageButtonClicked() {
        
        String description = descriptionTextField.getText().trim();
        String location = locationTextField.getText().trim();
        String tourCostStr = tourcostTextField.getText().trim();
        String guideCostStr = guidecostTextField.getText().trim();
        String ticketCostStr = ticketcostTextField.getText().trim();
        
        if (description.isEmpty() || location.isEmpty() || tourCostStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all required fields");
            return;
        }
        
        TourPackage tourPackage = null;
        try {
            int tourCost = Integer.parseInt(tourCostStr);

            // ================= CITY TOUR =================
            if (withCity.isSelected()) {
                
                if (guideCostStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter guide cost");
                    return;
                }
                
                int guideCost = Integer.parseInt(guideCostStr);
                boolean isWithGuide = withGuideCost.isSelected();
                
                tourPackage = new CityTour(description, location, tourCost, isWithGuide, guideCost);
                
                JOptionPane.showMessageDialog(null, "City Tour saved!");
            } // ================= SIGHTSEEING TOUR =================
            else if (withSightSeeing.isSelected()) {
                
                if (ticketCostStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter ticket cost");
                    return;
                }
                
                int ticketCost = Integer.parseInt(ticketCostStr);
                
                tourPackage = new SightSeeingTour(description, location, tourCost, ticketCost);
                
                JOptionPane.showMessageDialog(null, "SightSeeing Tour saved!");
            }
            
            if (tourPackage != null) {
                tourPackageList.add(tourPackage);
                tourPackageComboBox.setModel(
                        new DefaultComboBoxModel<>(tourPackageList.toArray(new TourPackage[0]))
                );
            }
            
            newTourPackageButton.doClick();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Costs must be numbers");
        }
    }
    
    void saveTouristButtonClicked() {
        
        AudioLanguage selectedLang = (AudioLanguage) audLangComboBox.getSelectedItem();
        if (selectedLang == null) {
            JOptionPane.showMessageDialog(null, "Please select a Language");
            return;
        }
        
        String name = nameTextField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please add your name");
            return;
        }
        
        String country = countryTextField.getText().trim();
        if (country.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a Country");
            return;
        }
        
        Tourist t = new Tourist(name, country, selectedLang);
        touristModel.addElement(t);
        
        JOptionPane.showMessageDialog(null, "Tourist saved successfully!");
    }
    
}
