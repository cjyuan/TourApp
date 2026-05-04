/*
 * Changes made ->
 * Populated touristComboBox
 * inititialised cityTourComboBox and sightSeeingTourComboBox
 * RadioButtons (withCity) grouped with logic - now to be added to panel
 *audLangComboBox updated
 *SaveBooking button updated
 *duplicate descriptionTextField.setText("") removed; 
 */
package rgu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.SimpleDateFormat;

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

    private JComboBox<SightSeeingTour> sightSeeingTourComboBox;
    private JTextField descriptionTextField;
    private JTextField locationTextField;
    private JTextField tourcostTextField;
    private JTextField ticketcostTextField;
    private JTextField datetimeTextField;
    private JButton clearButton;
    private JButton confirmButton;
    private JTextField nameTextField;
    private JTextField countryTextField;
    private JButton createBookingButton;
    private JButton cancelBookingButton;
    private JButton newTouristButton;
    private JButton viewBillButton;
    private JButton saveTouristButton;
    private JButton newTourPackageButton;
    private JButton saveTourPackageButton;
    private JComboBox<CityTour> cityTourComboBox;
    private JTextField description1TextField;
    private JTextField location1TextField;
    private JTextField ticketTextField;
    private JTextField guidecostTextField;
    private JTabbedPane tabPanel;



    private ArrayList<Tourist> touristList = new ArrayList<>(Arrays.asList(
            new Tourist("John", "London", AudioLanguage.FRENCH),
            new Tourist("Robert", "Rugby", AudioLanguage.ENGLISH)
    ));
    private ArrayList<CityTour> cityTourList = new ArrayList<>(Arrays.asList(
            new CityTour("John", "London", 29, false, 34),
            new CityTour("Robert", "Rugby", 39, true, 50)
    ));

    private ArrayList<SightSeeingTour> sightSeeingTourList = new ArrayList<>(Arrays.asList(
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
        JTabbedPane tabPanel = new JTabbedPane();
        tabPanel.addTab("Create or Cancel Booking", panel1);
        tabPanel.addTab("Update Your Personal Details", panel2);
        tabPanel.addTab("Update Your Tour Package Deatils", panel3);

        add(tabPanel);
    }

    private JPanel createPanel1() {

        touristModel = new DefaultComboBoxModel<>();
        
         for (Tourist t : touristList) {
        touristModel.addElement(t);
    }
        touristComboBox = new JComboBox<>(touristModel);
        tourPackageComboBox = new JComboBox<>(cityTourList.toArray(new CityTour[0]));
        bookingComboBox = new JComboBox<>(bookingList.toArray(new Booking[0]));


        JLabel touristLabel = new JLabel("Tourists");
        JLabel tourPackageLabel = new JLabel("Tour Packages");

        JLabel datetimeLabel = new JLabel("Date and Time");
        JLabel bookingLabel = new JLabel("Booking");

        datetimeTextField = new JTextField();

       createBookingButton = new JButton("Create Booking");

        createBookingButton.addActionListener(event -> {

            // 1. Validate tourist selection
            Tourist tourist = (Tourist) touristComboBox.getSelectedItem();
            if (tourist == null) {
                JOptionPane.showMessageDialog(null, "Please select a tourist");
                return;
            }

            // 2. Validate tour package selection
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
        });

        cancelBookingButton = new JButton("Cancel Booking");

        cancelBookingButton.addActionListener(event -> {

            Object selected = bookingComboBox.getSelectedItem();

            if (selected == null) {
                JOptionPane.showMessageDialog(null, "Please select a booking to cancel");
                return;
            }

            bookingComboBox.removeItem(selected);

            JOptionPane.showMessageDialog(null, "Booking cancelled successfully");
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

      ButtonGroup tourTypeGroup = new ButtonGroup();

    tourTypeGroup.add (withCity);
    tourTypeGroup.add (withSightSeeing);

    ButtonGroup guideGroup = new ButtonGroup();

    guideGroup.add (withGuideCost);
    guideGroup.add (withoutGuideCost);

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

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JPanel row1 = new JPanel();
        row1.add(withCity);

        JPanel row2 = new JPanel();
        row2.add(withGuideLabel);
        row2.add(withGuideCost);
        row2.add(withoutGuideCost);

        JPanel row3 = new JPanel();
        row3.add(guideCostLabel);
        row3.add(guidecostTextField);

        panel.add(row1);
        panel.add(row2);
        panel.add(row3);

        return panel;
    }

    private JPanel createPanel3_3() {

        JLabel ticketCostLabel = new JLabel("Cost for the Tickets (£)");
        ticketcostTextField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JPanel row1 = new JPanel();
        row1.add(withSightSeeing);

        JPanel row2 = new JPanel();
        row2.add(ticketCostLabel);
        row2.add(ticketcostTextField);

        JPanel row3 = new JPanel();
        row3.add(new JLabel(""));

        panel.add(row1);
        panel.add(row2);
        panel.add(row3);

        return panel;
    }

    private JPanel createPanel3() {
        
        
        cityTourComboBox = new JComboBox<>(cityTourList.toArray(new CityTour[0]));
        sightSeeingTourComboBox = new JComboBox<>(sightSeeingTourList.toArray(new SightSeeingTour[0]));

        JLabel tourPackageLabel = new JLabel("Tour Package");

        newTourPackageButton = new JButton("New TourPackage");
        saveTourPackageButton = new JButton("Save TourPackage");

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

            String description = descriptionTextField.getText().trim();
            String location = locationTextField.getText().trim();
            String tourCostStr = tourcostTextField.getText().trim();
            String guideCostStr = guidecostTextField.getText().trim();
            String ticketCostStr = ticketcostTextField.getText().trim();

            if (description.isEmpty() || location.isEmpty() || tourCostStr.isEmpty()) {
                JOptionPane.showMessageDialog(p1, "Please fill all required fields");
                return;
            }

            try {
                int tourCost = Integer.parseInt(tourCostStr);

                // ================= CITY TOUR =================
                if (withCity.isSelected()) {

                    if (guideCostStr.isEmpty()) {
                        JOptionPane.showMessageDialog(p1, "Please enter guide cost");
                        return;
                    }

                    int guideCost = Integer.parseInt(guideCostStr);
                    boolean isWithGuide = withGuideCost.isSelected();

                    CityTour c = new CityTour(description, location, tourCost, isWithGuide, guideCost);

                    cityTourList.add(c);
                    cityTourComboBox.setModel(
                            new DefaultComboBoxModel<>(cityTourList.toArray(new CityTour[0]))
                    );

                    JOptionPane.showMessageDialog(p1, "City Tour saved!");
                } // ================= SIGHTSEEING TOUR =================
                else if (withSightSeeing.isSelected()) {

                    if (ticketCostStr.isEmpty()) {
                        JOptionPane.showMessageDialog(p1, "Please enter ticket cost");
                        return;
                    }

                    int ticketCost = Integer.parseInt(ticketCostStr);

                    SightSeeingTour s = new SightSeeingTour(description, location, tourCost, ticketCost);

                    sightSeeingTourList.add(s);
                    sightSeeingTourComboBox.setModel(
                            new DefaultComboBoxModel<>(sightSeeingTourList.toArray(new SightSeeingTour[0]))
                    );

                    JOptionPane.showMessageDialog(p1, "SightSeeing Tour saved!");
                }

                newTourPackageButton.doClick();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(p1, "Costs must be numbers");
            }
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
//private void initComponents() {
//private void initComponents() {
    // JPanel panel = new JPanel();
    // panel.setLayout(new GridLayout());
    //panel.add(createPanel1());
    //this.getContentPane().add(panel, BorderLayout.CENTER);
//}
    //public TouristInterface() throws HeadlessException {
    //  super("Tourist App");
    // initComponents();
    //}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TouristInterface().setVisible(true);
        });
    }
}
/*
       
       
    ButtonGroup guideGroup = new ButtonGroup();
    guideGroup.add(withGuideCost);
    guideGroup.add(withoutGuideCost);

    ButtonGroup optionGroup = new ButtonGroup();
    optionGroup.add(withSightSeeing);
    optionGroup.add(withCity);

    panel.add(withGuideCost);
    panel.add(withoutGuideCost);
    panel.add(withSightSeeing);
    panel.add(withCity);

 



   

        descriptionTextField = new JTextField();
        panel.add(descriptionTextField);

       

        locationTextField = new JTextField();
        locationTextField.setBounds(130, 100, 200, 25);
        panel.add(locationTextField);
        
        

        guidecostTextField = new JTextField();
        guidecostTextField.setBounds(130, 100, 200, 25);
        panel.add(guidecostTextField);
        
       JLabel tourcostLabel = new JLabel("Tour Cost:");
       tourcostLabel.setBounds(20, 100, 100, 25);
        panel.add(tourcostLabel);
        
       JLabel guidecostLabel = new JLabel("Guide Cost:");
        guidecostLabel.setBounds(20, 100, 100, 25);
        panel.add(guidecostLabel);
        
       JLabel touristLabel = new JLabel("Select Tourist:");
        touristLabel.setBounds(20, 20, 100, 25);
        panel.add(touristLabel);
        
       JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(20, 100, 100, 25);
        panel.add(locationLabel);
        
       JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(20, 60, 100, 25);
        panel.add(descriptionLabel);

        tourcostTextField = new JTextField();
        tourcostTextField.setBounds(130, 100, 200, 25);
        panel.add(tourcostTextField);



        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 60, 100, 25);
        panel.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(130, 60, 200, 25);
        panel.add(nameTextField);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(20, 100, 100, 25);
        panel.add(countryLabel);

        countryTextField = new JTextField();
        countryTextField.setBounds(130, 100, 200, 25);
        panel.add(countryTextField);



        cancelBookingButton = new JButton("Cancel Booking");
        panel.add(cancelBookingButton);
        
        newTouristButton = new JButton("New Tourist");
        panel.add(newTouristButton);
        
        saveTouristButton = new JButton("Save Tourist");
        panel.add(saveTouristButton);
        
        viewBillButton = new JButton("View Bill");
        panel.add(viewBillButton);

        newTourPackageButton = new JButton("New TourPackage");
        panel.add(newTourPackageButton);
        
        savePackageButton = new JButton("Save TourPackage");
        panel.add(savePackageButton);
        
         
  

        add(panel);


// Clear/New button
        newTourPackageButton.addActionListener(e -> {
            descriptionTextField.setText("");
            locationTextField.setText("");
            guidecostTextField.setText("");
            tourcostTextField.setText("");
            ticketcostTextField.setText("");
            withCityTextField.setText("");
            withSightSeeingTextField.setText("");
        });

        // Confirm/Save button
        saveTourPackageButton.addActionListener(e -> {

    String description = descriptionTextField.getText().trim();
    String location = locationTextField.getText().trim();
    String tourCostStr = tourcostTextField.getText().trim();
    String guideCostStr = guidecostTextField.getText().trim();
    String ticketCostStr = ticketcostTextField.getText().trim();
    
            // Variable to store the choice
            String selectedOption = "";

// Later, when you want to save the result:
            if (withCity.isSelected()) {
                selectedOption = "With City";
            } else if (withSightSeeing.isSelected()) {
                selectedOption = "With Sightseeing";
            }

// Now selectedOption holds the result, e.g., for saving to a file, database, etc.
System.out.println("User selected: " + selectedOption);

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
*/

