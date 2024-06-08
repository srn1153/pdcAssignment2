/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class RefundPage extends JPanel implements PanelInterface {

    private TempoTicketsWebsite ttw;
    public Artist aInfo;
    private CustomerUpdate userInfo;
    public JTextField userBookingId;
    public JLabel correctionInput;
    public JComboBox refundNumOfTickets;
    public double refundAmountDouble; 
    public int refundTicketsSelected; 

   public RefundPage(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo) {
        this.ttw = ttw;
        this.aInfo = aInfo;
        this.userInfo = userInfo;
        //retrieves user's booking information
        this.userInfo = ttw.db.retrieveBookings(userInfo.getUserId());
        panelDisplay();
    }

    @Override
    public JPanel getContent() {
        return this;
    }

    @Override
    public void panelDisplay() {
        setLayout(new BorderLayout());

        //creating panel 
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(235, 239, 242)); //light blue background


        //adding title 
        JLabel title = new JLabel("Let's refund your tickets!");
        title.setFont(new Font("Garamond", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(118, 149, 182)); //dark blue 
        panel.add(title);

        //describing purpose of this page 
        JLabel purpose = new JLabel("Enter your booking ID below to refund your tickets");
        purpose.setFont(new Font("Garamond", Font.BOLD, 18));
        purpose.setAlignmentX(Component.CENTER_ALIGNMENT);
        purpose.setForeground(new Color(118, 149, 182)); //dark blue 
        panel.add(Box.createVerticalStrut(10));
        panel.add(purpose);

        //adds in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton);

        //adding homebutton to screen
        add(homeButtonPanel, BorderLayout.NORTH);

        //creating new panel for user information on refund 
        JPanel refundInput = new JPanel();
        refundInput.setLayout(new BoxLayout(refundInput, BoxLayout.Y_AXIS));
        refundInput.setBackground(new Color(235, 239, 242)); //light blue background
        refundInput.setLayout(null);

        //creating button for user to check their ticket details 
        JButton viewMyTickets = new JButton("Can't remember your booking ID? Click here!");
        viewMyTickets.setFont(new Font("Garamond", Font.BOLD, 16)); 
        viewMyTickets.setBackground(new Color(163, 194, 227)); //light blue 
        viewMyTickets.setForeground(Color.WHITE); //white text
        viewMyTickets.setBounds(150, 20, 350, 25);
        refundInput.add(viewMyTickets);

        //actionlistener to go back
        viewMyTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //goes to ViewMyTickets panel 
                ttw.nextPage(new ViewMyTickets(ttw, aInfo, userInfo));
            }
        });

        //asking for booking id
        JLabel bookingIdText = new JLabel("Booking Id:");
        bookingIdText.setFont(new Font("Garamond", Font.BOLD, 16)); 
        bookingIdText.setForeground(new Color(118, 149, 182)); //dark blue 
        bookingIdText.setBounds(100, 70, 200, 25);
        refundInput.add(bookingIdText);
        //text field 
        userBookingId = new JTextField(20);
        userBookingId.setBounds(300, 70, 200, 25);
        refundInput.add(userBookingId);

        //blank message that will be set if user enters invalid input 
        correctionInput = new JLabel("");
        correctionInput.setFont(new Font("Garamond", Font.BOLD, 16)); 
        correctionInput.setForeground(new Color(118, 149, 182)); //dark blue 
        correctionInput.setBounds(150, 100, 500, 25);
        refundInput.add(correctionInput);

        //confirmation 
        JButton comfirmation = new JButton("Confirm booking ID");
        comfirmation.setFont(new Font("Garamond", Font.BOLD, 16)); 
        comfirmation.setBackground(new Color(163, 194, 227)); //light blue 
        comfirmation.setForeground(Color.WHITE); //white text
        comfirmation.setBounds(50, 130, 200, 25);
        refundInput.add(comfirmation);

        //recap message, displays once button is clicked
        JLabel recap = new JLabel("");
        recap.setFont(new Font("Garamond", Font.BOLD, 16)); 
        recap.setForeground(new Color(118, 149, 182)); //dark blue 
        recap.setBounds(50, 170, 200, 25);
        refundInput.add(recap);

        //the artist chosen, displays once button is clicked
        JLabel artist = new JLabel("");
        artist.setFont(new Font("Garamond", Font.BOLD, 16)); 
        artist.setForeground(new Color(118, 149, 182)); //dark blue 
        artist.setBounds(50, 200, 200, 25);
        refundInput.add(artist);

        //the location displays once button is clicked 
        JLabel location = new JLabel("");
        location.setFont(new Font("Garamond", Font.BOLD, 16)); 
        location.setForeground(new Color(118, 149, 182)); //dark blue 
        location.setBounds(50, 230, 200, 25);
        refundInput.add(location);

        //the date displays once button is clicked
        JLabel date = new JLabel("");
        date.setFont(new Font("Garamond", Font.BOLD, 16)); 
        date.setForeground(new Color(118, 149, 182)); //dark blue 
        date.setBounds(50, 260, 200, 25);
        refundInput.add(date);

        //the time displays once button is clicked
        JLabel time = new JLabel("");
        time.setFont(new Font("Garamond", Font.BOLD, 16)); 
        time.setForeground(new Color(118, 149, 182)); //dark blue 
        time.setBounds(50, 290, 200, 25);
        refundInput.add(time);

        //the ticket type chosen, displays once button is clicked
        JLabel ticketTypeChosen = new JLabel("");
        ticketTypeChosen.setFont(new Font("Garamond", Font.BOLD, 16)); 
        ticketTypeChosen.setForeground(new Color(118, 149, 182)); //dark blue 
        ticketTypeChosen.setBounds(50, 320, 400, 25);
        refundInput.add(ticketTypeChosen);

        //the number of tickets chosen, displays once button is clicked
        JLabel numOfTickets = new JLabel("");
        numOfTickets.setFont(new Font("Garamond", Font.BOLD, 16)); 
        numOfTickets.setForeground(new Color(118, 149, 182)); //dark blue 
        numOfTickets.setBounds(50, 350, 200, 25);
        refundInput.add(numOfTickets);

        //total cost of original purchase, displays once button is clicked
        JLabel totalCost = new JLabel("");
        totalCost.setFont(new Font("Garamond", Font.BOLD, 16)); 
        totalCost.setForeground(new Color(118, 149, 182)); //dark blue 
        totalCost.setBounds(50, 380, 200, 25);
        refundInput.add(totalCost);

        //asking to select number of tickets (max is their original number of tickets)
        JLabel numberOfTicketsLabel = new JLabel("Select number of tickets to refund: ");
        numberOfTicketsLabel.setFont(new Font("Garamond", Font.BOLD, 16)); 
        numberOfTicketsLabel.setForeground(new Color(118, 149, 182)); //dark blue 
        numberOfTicketsLabel.setBounds(290, 130, 250, 25);

        //creates an combobox which user can select from
        refundNumOfTickets = new JComboBox<>();
        refundNumOfTickets.setBounds(530, 130, 40, 25);

        //refund message
        JLabel refundMessage = new JLabel("Refunds will be sent to the card");
        refundMessage.setFont(new Font("Garamond", Font.BOLD, 16)); 
        refundMessage.setForeground(new Color(118, 149, 182)); //dark blue 
        refundMessage.setBounds(320, 170, 500, 25);

        JLabel refundMessage1 = new JLabel("used for original purchase.");
        refundMessage1.setFont(new Font("Garamond", Font.BOLD, 16)); 
        refundMessage1.setForeground(new Color(118, 149, 182)); //dark blue 
        refundMessage1.setBounds(340, 190, 500, 25);

        JLabel refundMessage2 = new JLabel("Please allow for up to 3 business");
        refundMessage2.setFont(new Font("Garamond", Font.BOLD, 16)); 
        refundMessage2.setForeground(new Color(118, 149, 182)); //dark blue 
        refundMessage2.setBounds(320, 210, 500, 25);

        JLabel refundMessage3 = new JLabel("days for the refund to process!");
        refundMessage3.setFont(new Font("Garamond", Font.BOLD, 16)); 
        refundMessage3.setForeground(new Color(118, 149, 182)); //dark blue 
        refundMessage3.setBounds(330, 230, 500, 25);

        //refund amount will be displayed here 
        JLabel refundAmount = new JLabel("");
        refundAmount.setFont(new Font("Garamond", Font.BOLD, 16)); 
        refundAmount.setForeground(new Color(118, 149, 182)); //dark blue 
        refundAmount.setBounds(340, 270, 500, 25);
        refundInput.add(refundAmount);

        //creating a button to submit their refund
        JButton submitRefund = new JButton("Submit Refund");
        submitRefund.setFont(new Font("Garamond", Font.BOLD, 16)); 
        submitRefund.setBackground(new Color(163, 194, 227)); //light blue 
        submitRefund.setForeground(Color.WHITE); //white text
        submitRefund.setBounds(340, 310, 150, 25);
        
        //creates a message for when the refund is successful
        JLabel success = new JLabel("");
        success.setFont(new Font("Garamond", Font.BOLD, 16)); 
        success.setForeground(new Color(118, 149, 182)); //dark blue 
        success.setBounds(340, 350, 500, 25);
        success.setFont(new Font("Garamond", Font.BOLD, 20));
        refundInput.add(success);
        
        //creates an exit button for user
        JButton exitButton = new JButton("Exit Website");
        exitButton.setFont(new Font("Garamond", Font.BOLD, 16)); 
        exitButton.setBackground(new Color(163, 194, 227)); //light blue 
        exitButton.setForeground(Color.WHITE); //white text
        exitButton.setBounds(340, 390, 150, 25);
        

        //actionlistener to confirm booking id
        comfirmation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkDetailRequirements()) {//is all inputs are valid from the user
                    String userBookingIdInput = userBookingId.getText().trim(); //gets booking id provided
                    int intBookingIdInput = Integer.parseInt(userBookingIdInput); //parses it through an int
                    CustomerUpdate bookingIdInfo = ttw.db.retrieveBookingId(intBookingIdInput); //retrieves information based on that bookingId number

                    if (bookingIdInfo.getArtist() == null) {
                        //this means there is no bookingId if there is not Artist set 
                        correctionInput.setText("This is an invalid booking ID number");
                    } else { //important information relating to refund is displays onto the panel
                        recap.setText("Ticket details listed below:");
                        //prints artist they are seeing
                        artist.setText("Artist: " + bookingIdInfo.getArtist());
                        //prints location
                        location.setText("Location: " + bookingIdInfo.getLocation());
                        //prints date
                        date.setText("Date: " + bookingIdInfo.getDate());
                        //prints time
                        time.setText("Time: " + bookingIdInfo.getTime());
                        //prints ticket type
                        ticketTypeChosen.setText("Ticket type: " + bookingIdInfo.getTicket_type());
                        //print number of tickets selected 
                        numOfTickets.setText("Number of tickets: " + bookingIdInfo.getNumber_of_tickets());
                        //prints total cost based on artist 
                        totalCost.setText("Total cost: $" + bookingIdInfo.getTotal_cost());

                        refundInput.add(numberOfTicketsLabel);

                        //removes items from comboBox if the confirm button is clicked again 
                        refundNumOfTickets.removeAllItems();

                        //using a for loop to retrieve number of tickets the user initial bought (so I know how much they can get refunded)
                        for (int i = 1; i <= bookingIdInfo.getNumber_of_tickets(); i++) {
                            refundNumOfTickets.addItem(i);
                        }
                        refundInput.add(refundNumOfTickets);
                        //adds refunding message
                        refundInput.add(refundMessage);
                        refundInput.add(refundMessage1);
                        refundInput.add(refundMessage2);
                        refundInput.add(refundMessage3);

                        revalidate();
                        repaint();
                    }
                }
            }
        });

        refundNumOfTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userBookingIdInput = userBookingId.getText().trim();
                int intBookingIdInput = Integer.parseInt(userBookingIdInput);
                CustomerUpdate bookingIdInfo = ttw.db.retrieveBookingId(intBookingIdInput);
                
                //based on comboBox selected I calculate how much the user will be getting refunded 
                double perTicket = bookingIdInfo.getTotal_cost() / bookingIdInfo.getNumber_of_tickets();
                refundTicketsSelected = Integer.parseInt(refundNumOfTickets.getSelectedItem().toString());
                refundAmountDouble = refundTicketsSelected * perTicket;

                //rounds number to 2 decimal places
                refundAmountDouble = Math.round(refundAmountDouble * 100.0) / 100.0;

                //sets message to panel 
                refundAmount.setText("Refund amount is: $" + refundAmountDouble);
                refundInput.add(submitRefund);
            }

        });
        
        submitRefund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userBookingIdInput = userBookingId.getText().trim();
                int intBookingIdInput = Integer.parseInt(userBookingIdInput);
                //updates information in database table
                ttw.db.refundTickets(intBookingIdInput, refundTicketsSelected, refundAmountDouble); 
                
                //adds successful message and exit button to panel 
                success.setText("Refund Successful!"); 
                refundInput.add(exitButton); 
                revalidate(); 
                repaint(); 
                
            }
            
        }); 
        
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //allows user to exit program
                System.exit(0); 
            }
            
        });

        //adding components to panel
        panel.add(refundInput, BorderLayout.SOUTH);  
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public boolean checkDetailRequirements() { //requirements the user has to met before moving forward
        String userBookingIdInput = userBookingId.getText().trim();

        //ensures that all JTextFields aren't left empty
        if (userBookingIdInput.isEmpty()) {
            correctionInput.setText("Please do not leave text field empty");
            return false;
        }
        //ensures the id is only digits
        if (!(userBookingIdInput.matches("-?\\d+"))) {
            correctionInput.setText("Please enter digits when entering your booking ID");
            return false;
        }
        correctionInput.setText("");
        return true;
    }
}
