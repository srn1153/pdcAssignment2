/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class BookingPage extends JPanel implements PanelInterface {

    protected TempoTicketsWebsite ttw;
    public Artist aInfo;
    public CustomerUpdate userInfo;
    public JTextField fNameText;
    public JTextField lNameText;
    public JLabel inputMessage;
    public JComboBox ticketType; 
    public JComboBox numberOfTickets; 

    public BookingPage(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo) {
        this.ttw = ttw;
        this.aInfo = aInfo;
        this.userInfo = userInfo;
        panelDisplay();
    }

    public JPanel getContent() {
        return this;
    }

    public void panelDisplay() {

        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(new Color(235, 239, 242)); //light blue background

        //adding homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BorderLayout());
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton, BorderLayout.WEST);
        titlePanel.add(homeButtonPanel);

        //displaying title (this is the stage after logging in)
        JLabel loggedIn = new JLabel("You have successfully logged in!");
        loggedIn.setFont(new Font("Garamond", Font.BOLD, 28));
        loggedIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loggedIn.setForeground(new Color(118, 149, 182)); //dark blue 
        titlePanel.add(loggedIn);

        //adding gap between info 
        titlePanel.add(Box.createVerticalStrut(20));

        //prompt for user
        JLabel title = new JLabel("Select from the options below:");
        title.setFont(new Font("Garamond", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(118, 149, 182)); //dark blue 
        titlePanel.add(title);

        //adding gap between info 
        titlePanel.add(Box.createVerticalStrut(20));
        //adding to title panel 
        add(titlePanel, BorderLayout.NORTH);

        //creating new panel for user input 
        JPanel userInputPanel = new JPanel();
        userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.Y_AXIS));
        userInputPanel.setBackground(new Color(235, 239, 242)); //light blue background
        userInputPanel.setLayout(null);

        //asking for first name 
        JLabel fName = new JLabel("First Name:");
        fName.setForeground(new Color(118, 149, 182)); //dark blue 
        fName.setFont(new Font("Garamond", Font.BOLD, 16)); 
        fName.setBounds(50, 40, 200, 25);
        userInputPanel.add(fName);
        //enter first name 
        fNameText = new JTextField(20);
        fNameText.setBounds(320, 40, 200, 25);
        userInputPanel.add(fNameText);

        //asking for last name 
        JLabel lName = new JLabel("Last Name:");
        lName.setForeground(new Color(118, 149, 182)); //dark blue 
        lName.setFont(new Font("Garamond", Font.BOLD, 16)); 
        lName.setBounds(50, 80, 200, 25);
        userInputPanel.add(lName);
        //enter last name 
        lNameText = new JTextField(20);
        lNameText.setBounds(320, 80, 200, 25);
        userInputPanel.add(lNameText);

        //asking for ticket type 
        JLabel ticketTypeLabel = new JLabel("Select your ticket type: ");
        ticketTypeLabel.setForeground(new Color(118, 149, 182)); //dark blue
        ticketTypeLabel.setFont(new Font("Garamond", Font.BOLD, 16)); 
        ticketTypeLabel.setBounds(50, 120, 200, 25);
        userInputPanel.add(ticketTypeLabel);
        //using combo box for them to select 
        ticketType = new JComboBox();
        ticketType.addItem("Standard Ticket");
        ticketType.addItem("Wheelchair Access Ticket");
        ticketType.setBounds(320, 120, 200, 25);
        userInputPanel.add(ticketType);

        //asking to select number of tickets (max of 6 tickets per purchase)
        JLabel numberOfTicketsLabel = new JLabel("Select number of tickets to purchase: ");
        numberOfTicketsLabel.setForeground(new Color(118, 149, 182)); //dark blue 
        numberOfTicketsLabel.setFont(new Font("Garamond", Font.BOLD, 16)); 
        numberOfTicketsLabel.setBounds(50, 160, 300, 25);
        userInputPanel.add(numberOfTicketsLabel);

        //combo box so they can choose (avoid recieving invalid input)
        numberOfTickets = new JComboBox();
        numberOfTickets.addItem(1);
        numberOfTickets.addItem(2);
        numberOfTickets.addItem(3);
        numberOfTickets.addItem(4);
        numberOfTickets.addItem(5);
        numberOfTickets.addItem(6);
        numberOfTickets.setBounds(320, 160, 200, 25);
        userInputPanel.add(numberOfTickets);

        //invisible message that displays when input is incorrect
        //the message is a friendly prompt on what the correct input should be 
        inputMessage = new JLabel("");
        inputMessage.setForeground(new Color(118, 149, 182)); //dark blue 
        inputMessage.setFont(new Font("Garamond", Font.BOLD, 16)); 
        inputMessage.setBounds(50, 190, 500, 25);
        userInputPanel.add(inputMessage);

        //confirmation button to view detials before payment 
        JButton confirm = new JButton("Click here to confirm details");
        confirm.setBackground(new Color(163, 194, 227)); //light blue 
        confirm.setForeground(Color.WHITE); //white text  
        confirm.setFont(new Font("Garamond", Font.BOLD, 16)); 
        confirm.setBounds(50, 220, 250, 25);
        userInputPanel.add(confirm);

        //recap message, displays once button is clicked
        JLabel recap = new JLabel("");
        recap.setForeground(new Color(118, 149, 182)); //dark blue 
        recap.setFont(new Font("Garamond", Font.BOLD, 16)); 
        recap.setBounds(50, 250, 250, 25);
        userInputPanel.add(recap);
        
        //the artist chosen, displays once button is clicked
        JLabel artist = new JLabel("");
        artist.setForeground(new Color(118, 149, 182)); //dark blue 
        artist.setFont(new Font("Garamond", Font.BOLD, 16)); 
        artist.setBounds(50, 280, 200, 25);
        userInputPanel.add(artist);

        //the ticket type chosen, displays once button is clicked
        JLabel ticketTypeChosen = new JLabel("");
        ticketTypeChosen.setForeground(new Color(118, 149, 182)); //dark blue 
        ticketTypeChosen.setFont(new Font("Garamond", Font.BOLD, 16)); 
        ticketTypeChosen.setBounds(50, 310, 400, 25);
        userInputPanel.add(ticketTypeChosen);

        //the number of tickets chosen, displays once button is clicked
        JLabel numOfTickets = new JLabel("");
        numOfTickets.setForeground(new Color(118, 149, 182)); //dark blue 
        numOfTickets.setFont(new Font("Garamond", Font.BOLD, 16)); 
        numOfTickets.setBounds(50, 340, 200, 25);
        userInputPanel.add(numOfTickets);

        //what their total cost will be displays once button is clicked
        JLabel totalCost = new JLabel("");
        totalCost.setForeground(new Color(118, 149, 182)); //dark blue 
        totalCost.setFont(new Font("Garamond", Font.BOLD, 16)); 
        totalCost.setBounds(50, 370, 200, 25);
        userInputPanel.add(totalCost);

        //proceed to payment button
        JButton proceedToPayment = new JButton("Proceed to payment -->");
        proceedToPayment.setBackground(new Color(163, 194, 227)); //light blue 
        proceedToPayment.setForeground(Color.WHITE); //white text        
        proceedToPayment.setFont(new Font("Garamond", Font.BOLD, 16)); 
        proceedToPayment.setBounds(50, 400, 300, 25);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkDetailRequirements()) { //this runs if user's input meets all requirements
                    recap.setText("Confirmation details listed below:");
                    //prints artist they are seeing
                    artist.setText("Artist: " + aInfo.getArtistName());
                    //prints ticket type
                    ticketTypeChosen.setText("Ticket type: " + ticketType.getSelectedItem().toString());
                    //print number of tickets selected 
                    numOfTickets.setText("Number of tickets: " + numberOfTickets.getSelectedItem().toString());
                    //prints total cost based on artist 
                    int intNumberOfTicketsChosen = Integer.parseInt(numberOfTickets.getSelectedItem().toString());
                    double doubleTotalCost = aInfo.getPrice() * intNumberOfTicketsChosen;
                    totalCost.setText("Total cost: $" + doubleTotalCost);
                    userInputPanel.add(proceedToPayment); //adds to panel 
                    revalidate();
                    repaint();
                }
            }
        });

        proceedToPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkDetailRequirements()) { //this runs if user's input meets all requirements
                    //proceeds to payment panel 
                    ttw.nextPage(new PaymentPanel(ttw, aInfo, userInfo, BookingPage.this) {
                    });
                }
            }
        });
        add(userInputPanel, BorderLayout.CENTER);
    }

    //ensures all input is correct 
    public boolean checkDetailRequirements() { 
        //gets first name input 
        String fNameInput = fNameText.getText().trim();
        //gets last name input 
        String lNameInput = lNameText.getText().trim();

        //checks that all JTextFields aren't left empty
        if (fNameInput.isEmpty() || lNameInput.isEmpty()) {
            inputMessage.setText("Please do not leave any details empty");
            return false;
        }

        //checks that first and last name fields are string inputs (not digits)
        if(!lNameInput.matches("[a-zA-Z]+") || !fNameInput.matches("[a-zA-Z]+")) {
            inputMessage.setText("Please enter your first and last name using letters only");
            return false;
        }
        //if the requirements are meet then there is no message displayed 
        inputMessage.setText("");
        return true;
    }
}
