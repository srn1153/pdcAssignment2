/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class BookingPage extends JPanel implements BookingPageInterface{

    protected final TempoTicketsWebsite ttw;

    public BookingPage(TempoTicketsWebsite ttw) {
        this.ttw = ttw;
        detailsPage();
    }

    public JPanel getContent() {
        return this;
    }

    @Override
    public JPanel comboBoxOptions() {
        JPanel userInputPanel = new JPanel(); 
        JLabel ticketTypeLabel = new JLabel("Select your ticket type: ");
        userInputPanel.add(ticketTypeLabel); 
        
        JComboBox ticketType = new JComboBox();
        ticketType.addItem("Standard Ticket");
        ticketType.addItem("Wheelchair Access Ticket ");
        userInputPanel.add(ticketType); 
        
        userInputPanel.add(Box.createVerticalStrut(40)); 
        
        /*JLabel numberOfTicketsLabel = new JLabel("Select number of tickets to purchase: ");
        userInputPanel.add(numberOfTicketsLabel); 
        
        JComboBox numberOfTickets = new JComboBox();
        numberOfTickets.addItem("1");
        numberOfTickets.addItem("2");
        numberOfTickets.addItem("3");
        numberOfTickets.addItem("4");
        numberOfTickets.addItem("5");
        numberOfTickets.addItem("6");
        userInputPanel.add(numberOfTickets); */

        return userInputPanel; 
    }

    public void detailsPage() {

        setLayout(new BorderLayout()); 
        
        JPanel titlePanel = new JPanel(); 
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS)); 
                
        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BorderLayout());
        JButton homeButton = Buttons.homePageButton(ttw); 
        homeButtonPanel.add(homeButton, BorderLayout.WEST); 
        titlePanel.add(homeButtonPanel); 
        
        //displaying title (this is the stage after logging in)
        JLabel loggedIn = new JLabel("You have successfully logged in!");
        loggedIn.setFont(new Font("Garamond", Font.BOLD, 28)); 
        loggedIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(loggedIn); 
        
        titlePanel.add(Box.createVerticalStrut(20)); 
        
        //adding in text before drop boxes 
        JLabel title = new JLabel("Select from the options below:");
        title.setFont(new Font("Garamond", Font.BOLD, 20)); 
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);
        
        titlePanel.add(Box.createVerticalStrut(20)); 
               
        add(titlePanel, BorderLayout.NORTH);
        
        add(comboBoxOptions(), BorderLayout.CENTER);

    }
}
