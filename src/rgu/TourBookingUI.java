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
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TourBookingUI extends JFrame {

    public TourBookingUI() {
        setTitle("Tour Booking System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        mainPanel.add(createBookingPanel());
        mainPanel.add(createTouristPanel());
        mainPanel.add(createTourPackagePanel());
    }

    private JPanel createBookingPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Bookings"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tourists
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Tourists"), gbc);

        gbc.gridx = 1;
        JComboBox<String> tourists = new JComboBox<>(
                new String[]{"Adam from USA, preferred audio guide language is ENGLISH"});
        panel.add(tourists, gbc);

        // Tour Packages
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Tour Packages"), gbc);

        gbc.gridx = 1;
        JComboBox<String> packages = new JComboBox<>(
                new String[]{"A city tour in York with a total cost of 80.0£ including a personal guide."});
        panel.add(packages, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Date and Time"), gbc);

        gbc.gridx = 1;
        JTextField dateField = new JTextField(15);
        panel.add(dateField, gbc);

        // Buttons
        gbc.gridx = 2;
        JButton createBtn = new JButton("Create Booking");
        panel.add(createBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JComboBox<String> bookings = new JComboBox<>(
                new String[]{"Adam, booked a sightseeing tour in and around Carlisle..."});
        panel.add(bookings, gbc);

        gbc.gridx = 2;
        JButton cancelBtn = new JButton("Cancel Booking");
        panel.add(cancelBtn, gbc);

        return panel;
    }

    private JPanel createTouristPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Tourist"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField("Adam", 15);
        panel.add(nameField, gbc);

        // Country
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Country"), gbc);

        gbc.gridx = 1;
        JTextField countryField = new JTextField("USA", 15);
        panel.add(countryField, gbc);

        // Language
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Audio Guide Language"), gbc);

        gbc.gridx = 1;
        JComboBox<String> langBox = new JComboBox<>(new String[]{"ENGLISH"});
        panel.add(langBox, gbc);

        // Buttons
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(new JButton("New Tourist"), gbc);

        gbc.gridy = 1;
        panel.add(new JButton("View Bill"), gbc);

        gbc.gridy = 2;
        panel.add(new JButton("Save Tourist"), gbc);

        return panel;
    }

    private JPanel createTourPackagePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Tour Package"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Description
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Description"), gbc);

        gbc.gridx = 1;
        JTextField desc = new JTextField("A day tour of the lovely lake district!", 20);
        panel.add(desc, gbc);

        // Location
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Location"), gbc);

        gbc.gridx = 1;
        JTextField location = new JTextField("Carlisle", 15);
        panel.add(location, gbc);

        // Cost
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Tour cost"), gbc);

        gbc.gridx = 1;
        JTextField cost = new JTextField("100.0", 10);
        panel.add(cost, gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("£"), gbc);

        // Radio buttons
        gbc.gridx = 1;
        gbc.gridy = 3;
        JRadioButton cityTour = new JRadioButton("City Tour");
        JRadioButton sightseeing = new JRadioButton("Sightseeing Tour", true);

        ButtonGroup group = new ButtonGroup();
        group.add(cityTour);
        group.add(sightseeing);

        JPanel radioPanel = new JPanel();
        radioPanel.add(cityTour);
        radioPanel.add(sightseeing);

        panel.add(radioPanel, gbc);

        // Guide options
        gbc.gridy = 4;
        JPanel guidePanel = new JPanel();
        guidePanel.add(new JLabel("With guide"));
        JRadioButton yes = new JRadioButton("Yes");
        JRadioButton no = new JRadioButton("No");
        ButtonGroup guideGroup = new ButtonGroup();
        guideGroup.add(yes);
        guideGroup.add(no);
        guidePanel.add(yes);
        guidePanel.add(no);

        panel.add(guidePanel, gbc);

        // Ticket cost
        gbc.gridy = 5;
        JPanel ticketPanel = new JPanel();
        ticketPanel.add(new JLabel("Cost for the tickets"));
        JTextField ticketCost = new JTextField("20.0", 5);
        ticketPanel.add(ticketCost);
        ticketPanel.add(new JLabel("£"));

        panel.add(ticketPanel, gbc);

        // Buttons
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(new JButton("New Tour Package"), gbc);

        gbc.gridy = 5;
        panel.add(new JButton("Save Tour Package"), gbc);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TourBookingUI().setVisible(true);
        });
    }
}