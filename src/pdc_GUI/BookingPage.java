/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
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
    public Artist aInfo; 

    public BookingPage(TempoTicketsWebsite ttw, Artist aInfo) {
        this.ttw = ttw;
        this.aInfo = aInfo; 
        detailsPage();
    }

    public JPanel getContent() {
        return this;
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
        
        JPanel userInputPanel = new JPanel(); 
        userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.Y_AXIS));
        //userInputPanel.add(comboBoxOptions(), BorderLayout.NORTH); 
        userInputPanel.setLayout(null);
        
        //Asking for first name 
        JLabel fName = new JLabel("First Name:");
        fName.setBounds(50, 20, 200, 25); 
        userInputPanel.add(fName); 
        //Enter first name 
        JTextField fNameText = new JTextField(20);
        fNameText.setBounds(300, 20, 200, 25); 
        userInputPanel.add(fNameText);
        
        //Asking for last name 
        JLabel lName = new JLabel("Last Name:");
        lName.setBounds(50, 50, 200, 25); 
        userInputPanel.add(lName); 
        //Enter last name 
        JTextField lNameText = new JTextField(20);
        lNameText.setBounds(300, 50, 200, 25); 
        userInputPanel.add(lNameText);
        
        //Asking for email
        JLabel email = new JLabel("Email:");
        email.setBounds(50, 80, 200, 25); 
        userInputPanel.add(email); 
        //Enter email 
        JTextField emailText = new JTextField(20);
        emailText.setBounds(300, 80, 200, 25); 
        userInputPanel.add(emailText);
        
        //Asking for phone number
        JLabel phoneNum = new JLabel("Phone number:");
        phoneNum.setBounds(50, 110, 200, 25); 
        userInputPanel.add(phoneNum); 
        //Enter email 
        JTextField phoneNumText = new JTextField(20);
        phoneNumText.setBounds(300, 110, 200, 25); 
        userInputPanel.add(phoneNumText);
        
        //userInputPanel.add(comboBoxOptions(), BorderLayout.NORTH);
        JLabel ticketTypeLabel = new JLabel("Select your ticket type: ");
        ticketTypeLabel.setBounds(50, 140, 200, 25); 
        userInputPanel.add(ticketTypeLabel); 
        
        JComboBox ticketType = new JComboBox();
        ticketType.addItem("Standard Ticket");
        ticketType.addItem("Wheelchair Access Ticket ");
        ticketType.setBounds(300, 140, 200, 25); 
        userInputPanel.add(ticketType); 
        
        //userInputPanel.add(Box.createVerticalStrut(40)); 
        
        JLabel numberOfTicketsLabel = new JLabel("Select number of tickets to purchase: ");
        numberOfTicketsLabel.setBounds(50, 170, 250, 25); 
        userInputPanel.add(numberOfTicketsLabel); 
        
        JComboBox numberOfTickets = new JComboBox();
        numberOfTickets.addItem(1);
        numberOfTickets.addItem(2);
        numberOfTickets.addItem(3);
        numberOfTickets.addItem(4);
        numberOfTickets.addItem(5);
        numberOfTickets.addItem(6);
        numberOfTickets.setBounds(300, 170, 200, 25); 
        userInputPanel.add(numberOfTickets);

        JButton confirm = new JButton("Click here to confirm details"); 
        confirm.setBounds(50, 200, 200, 25); 
        userInputPanel.add(confirm);
        
        JLabel recap = new JLabel(""); 
        recap.setBounds(50, 240, 200, 25);
        userInputPanel.add(recap); 
        
        JLabel artist = new JLabel(""); 
        artist.setBounds(50, 270, 200, 25);
        userInputPanel.add(artist); 
        
        JLabel ticketTypeChosen = new JLabel(""); 
        ticketTypeChosen.setBounds(50, 300, 200, 25);
        userInputPanel.add(ticketTypeChosen); 
        
        JLabel numOfTickets = new JLabel(""); 
        numOfTickets.setBounds(50, 330, 200, 25);
        userInputPanel.add(numOfTickets); 
        
        JLabel totalCost = new JLabel(""); 
        totalCost.setBounds(50, 360, 200, 25);
        userInputPanel.add(totalCost); 
        
        JButton proceedToPayment = new JButton("Proceed to payment -->"); 
        proceedToPayment.setBounds(50, 390, 200, 25); 
        //userInputPanel.add(proceedToPayment);

        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                                
                recap.setText("Confirmation details listed below:");
                //print artist they are buying for 
                artist.setText("Artist: "+aInfo.getArtistName());
                //print tickettype
                ticketTypeChosen.setText("Ticket type: "+ticketType.getSelectedItem().toString());
                //print numberOfTickets selected 
                numOfTickets.setText("Number of tickets: "+numberOfTickets.getSelectedItem().toString());
                //print total cost based on artist 
                int intNumberOfTicketsChosen = Integer.parseInt(numberOfTickets.getSelectedItem().toString()); 
                double doubleTotalCost = aInfo.getPrice() * intNumberOfTicketsChosen; 
                totalCost.setText("Total cost: $" + doubleTotalCost); 
                userInputPanel.add(proceedToPayment);
                revalidate(); 
                repaint(); 
            }
        }); 
        
        proceedToPayment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = fNameText.getText(); 
                String lName = lNameText.getText(); 
                String email = emailText.getText(); 
                String phoneNum = phoneNumText.getText(); 
                
                ttw.db.insertInfo(fName, lName, email, phoneNum);                 
            }
            
        }); 
        
        add(userInputPanel, BorderLayout.CENTER);
    }
}
