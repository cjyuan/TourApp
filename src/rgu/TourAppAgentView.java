/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author astel
 */

public class TourAppAgentView extends JFrame {
    
 // swing componants
    private JPanel jpanel;
    private JComboBox <TourAgent>comboBox;
    private JButton newButton,saveButton;
    private JTextField nameField, locationField;
    
    //list to store TourAgent
    private ArrayList<TourAgent> tourAgents;
    
    public TourAppAgentView() {
        tourAgents = new ArrayList (Arrays.asList(
        new TourAgent("Jame", "Leeds"),
        new TourAgent("Rupert", "Hull")
        ));

    
        //Frame set up
        setTitle ("Tourist Booking");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (420,420);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        
        //Panel setup
        jpanel = new JPanel();
        jpanel.setBackground (Color.red);
        jpanel.setLayout(null);
        add(jpanel);
        
        //ComboBox
        comboBox = new JComboBox ();
        comboBox.setBounds(50,20,300,30);
        comboBox.setEditable(false);
        jpanel.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel(tourAgents.toArray()));
        
         //NameField
        nameField = new JTextField ("Name");
        nameField.setBounds(50,70,150,25);
        jpanel.add(nameField);
        
        //LocationField
        locationField = new JTextField ("Location");
        locationField.setBounds(50,110,150,25);
        jpanel.add(locationField);
        
         //New Button
        newButton = new JButton ("New Tour Agent");
        newButton.setBounds(50,160,150,30);
        jpanel.add(newButton);
        
        //Save Button
        saveButton = new JButton ("Save Tour Agent");
        saveButton.setBounds(220,160,150,30);
        jpanel.add(saveButton);
        
        //clear Fields
        newButton.addActionListener(e-> {
        nameField.setText("");
        locationField.setText("");
        nameField.requestFocus();
        });
        
        //new Agent to ComboBox
        newButton.addActionListener(e->{
        String name = nameField.getText().trim();
        String location = locationField.getText().trim();
        
        if (!name.isEmpty() && !location.isEmpty()){
            TourAgent agentEntry = new TourAgent(name, location);
            tourAgents.add(agentEntry);
            comboBox.setModel(new DefaultComboBoxModel(tourAgents.toArray()));
            
            JOptionPane.showMessageDialog(this, "Tour Agent Saved!");
            nameField.setText("");
            locationField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter Name and Location");
        }
        });
        
        setVisible(true);
        
              //save Agent to ComboBox
        saveButton.addActionListener(e->{
        String name = nameField.getText().trim();
        String location = locationField.getText().trim();
        
        if (!name.isEmpty() && !location.isEmpty()){
             TourAgent A = (TourAgent)comboBox.getSelectedItem();
             A.setName(name);
             A.setLocation(location);
            //comboBox.setModel(new DefaultComboBoxModel(tourAgents.toArray()));
            
            JOptionPane.showMessageDialog(this, "Tour Agent Saved!");
            nameField.setText("");
            locationField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter Name and Location");
        }
        });
        
        setVisible(true);
        
        
        
        //JComboBox action listener
        comboBox.addActionListener(e->{
        TourAgent A = (TourAgent)comboBox.getSelectedItem();
        
       
         nameField.setText(A.getName());
        
         locationField.setText(A.getLocation());
        });
    }
     
      
        
    public static void main (String[] args) {
        SwingUtilities.invokeLater(TourAppAgentView::new);
    }
}

