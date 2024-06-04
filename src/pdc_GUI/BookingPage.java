/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        
        JLabel numberOfTicketsLabel = new JLabel("Select number of tickets to purchase: ");
        userInputPanel.add(numberOfTicketsLabel); 
        
        JComboBox numberOfTickets = new JComboBox();
        numberOfTickets.addItem("1");
        numberOfTickets.addItem("2");
        numberOfTickets.addItem("3");
        numberOfTickets.addItem("4");
        numberOfTickets.addItem("5");
        numberOfTickets.addItem("6");
        userInputPanel.add(numberOfTickets);

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
        //add(comboBoxOptions(), BorderLayout.CENTER);
        
        JPanel userInputPanel = new JPanel(); 
        userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.Y_AXIS));
        //userInputPanel.add(comboBoxOptions(), BorderLayout.NORTH); 
        userInputPanel.setLayout(null);
        
        //Asking for first name 
        JLabel fName = new JLabel("First Name:");
        fName.setBounds(10, 20, 200, 25); 
        userInputPanel.add(fName); 
        //Enter first name 
        JTextField fNameText = new JTextField(20);
        fNameText.setBounds(150, 20, 200, 25); 
        userInputPanel.add(fNameText);
        
        //Asking for last name 
        JLabel lName = new JLabel("Last Name:");
        lName.setBounds(10, 50, 200, 25); 
        userInputPanel.add(lName); 
        //Enter last name 
        JTextField lNameText = new JTextField(20);
        lNameText.setBounds(150, 50, 200, 25); 
        userInputPanel.add(lNameText);
        
        //Asking for email
        JLabel email = new JLabel("Email:");
        email.setBounds(10, 80, 200, 25); 
        userInputPanel.add(email); 
        //Enter email 
        JTextField emailText = new JTextField(20);
        emailText.setBounds(150, 80, 200, 25); 
        userInputPanel.add(emailText);
        
        //Asking for phone number
        JLabel phoneNum = new JLabel("Phone number:");
        phoneNum.setBounds(10, 110, 200, 25); 
        userInputPanel.add(phoneNum); 
        //Enter email 
        JTextField phoneNumText = new JTextField(20);
        phoneNumText.setBounds(150, 110, 200, 25); 
        userInputPanel.add(phoneNumText);
        
        JButton confirm = new JButton("Click here to confirm details"); 
        confirm.setBounds(10, 150, 200, 25); 
        userInputPanel.add(confirm);
        
        JLabel recap = new JLabel(""); 
        recap.setBounds(10, 190, 200, 25);
        userInputPanel.add(recap); 
        
        JLabel artist = new JLabel(""); 
        artist.setBounds(10, 220, 200, 25);
        userInputPanel.add(artist); 
        
        JLabel ticketType = new JLabel(""); 
        ticketType.setBounds(10, 250, 200, 25);
        userInputPanel.add(ticketType); 
        
        JLabel numOfTickets = new JLabel(""); 
        numOfTickets.setBounds(10, 280, 200, 25);
        userInputPanel.add(numOfTickets); 
        
        JLabel totalCost = new JLabel(""); 
        totalCost.setBounds(10, 310, 200, 25);
        userInputPanel.add(totalCost); 
        
        
        
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                recap.setText("Confirmation details listed below:");
                //print artist they are buying for 
                artist.setText("something");
                //print tickettype
                ticketType.setText("something");
                //print numberOfTickets selected 
                numOfTickets.setText("something");
                //print total cost based on artist 
                totalCost.setText("something"); 
            }
        }); 
        
        add(userInputPanel, BorderLayout.CENTER);
    }
}
