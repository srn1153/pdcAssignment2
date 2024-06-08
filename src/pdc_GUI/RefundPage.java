/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
        //retrieves user's information
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

        //adding title 
        JLabel title = new JLabel("Lets refund your tickets!");
        title.setFont(new Font("Garamond", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        //describing purpose of this page 
        JLabel purpose = new JLabel("Enter your booking ID below to refund your tickets");
        purpose.setFont(new Font("Garamond", Font.PLAIN, 18));
        purpose.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(purpose);

        //adds in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton);

        //adding homebutton to screen
        add(homeButtonPanel, BorderLayout.NORTH);

        //creating new panel for user input 
        JPanel refundInput = new JPanel();
        refundInput.setLayout(new BoxLayout(refundInput, BoxLayout.Y_AXIS));
        refundInput.setLayout(null);

        //go view ticket details 
        JButton viewMyTickets = new JButton("Can't remember your booking ID? Click here!");
        viewMyTickets.setBounds(150, 20, 300, 25);
        refundInput.add(viewMyTickets);

        //actionlistener to go back
        viewMyTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new ViewMyTickets(ttw, aInfo, userInfo));
            }
        });

        //asking for booking id
        JLabel bookingIdText = new JLabel("Booking Id:");
        bookingIdText.setBounds(100, 70, 200, 25);
        refundInput.add(bookingIdText);
        //text field 
        userBookingId = new JTextField(20);
        userBookingId.setBounds(300, 70, 200, 25);
        refundInput.add(userBookingId);

        //confirmation 
        correctionInput = new JLabel("");
        correctionInput.setBounds(150, 100, 500, 25);
        refundInput.add(correctionInput);

        //confirmation 
        JButton comfirmation = new JButton("Confirm booking ID");
        comfirmation.setBounds(50, 130, 150, 25);
        refundInput.add(comfirmation);

        //recap message, displays once button is clicked
        JLabel recap = new JLabel("");
        recap.setBounds(50, 170, 200, 25);
        refundInput.add(recap);

        //the artist chosen, displays once button is clicked
        JLabel artist = new JLabel("");
        artist.setBounds(50, 200, 200, 25);
        refundInput.add(artist);

        //
        JLabel location = new JLabel("");
        location.setBounds(50, 230, 200, 25);
        refundInput.add(location);

        //the artist chosen, displays once button is clicked
        JLabel date = new JLabel("");
        date.setBounds(50, 260, 200, 25);
        refundInput.add(date);

        //the artist chosen, displays once button is clicked
        JLabel time = new JLabel("");
        time.setBounds(50, 290, 200, 25);
        refundInput.add(time);

        //the ticket type chosen, displays once button is clicked
        JLabel ticketTypeChosen = new JLabel("");
        ticketTypeChosen.setBounds(50, 320, 400, 25);
        refundInput.add(ticketTypeChosen);

        //the number of tickets chosen, displays once button is clicked
        JLabel numOfTickets = new JLabel("");
        numOfTickets.setBounds(50, 350, 200, 25);
        refundInput.add(numOfTickets);

        //what their total cost will be displays once button is clicked
        JLabel totalCost = new JLabel("");
        totalCost.setBounds(50, 380, 200, 25);
        refundInput.add(totalCost);

        //asking to select number of tickets (max is their original pruchase amount)
        JLabel numberOfTicketsLabel = new JLabel("Select number of tickets to refund: ");
        numberOfTicketsLabel.setBounds(290, 130, 250, 25);

        refundNumOfTickets = new JComboBox<>();
        refundNumOfTickets.setBounds(500, 130, 40, 25);

        //refund message
        JLabel refundMessage = new JLabel("Refunds will be sent to the card");
        refundMessage.setBounds(320, 170, 500, 25);

        JLabel refundMessage1 = new JLabel("used for original purchase.");
        refundMessage1.setBounds(340, 190, 500, 25);

        JLabel refundMessage2 = new JLabel("Please allow for up to 3 business");
        refundMessage2.setBounds(320, 210, 500, 25);

        JLabel refundMessage3 = new JLabel("days for the refund to process!");
        refundMessage3.setBounds(330, 230, 500, 25);

        JLabel refundAmount = new JLabel("");
        refundAmount.setBounds(340, 270, 500, 25);
        refundInput.add(refundAmount);

        JButton submitRefund = new JButton("Submit Refund");
        submitRefund.setBounds(340, 310, 150, 25);
        
        JLabel success = new JLabel("");
        success.setBounds(340, 350, 500, 25);
        success.setFont(new Font("Garamond", Font.BOLD, 20));
        refundInput.add(success);
        
        JButton exitButton = new JButton("Exit Webiste");
        exitButton.setBounds(340, 390, 150, 25);
        

        //actionlistener to confirm booking id
        comfirmation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkDetailRequirements()) {
                    String userBookingIdInput = userBookingId.getText().trim();
                    int intBookingIdInput = Integer.parseInt(userBookingIdInput);
                    CustomerUpdate bookingIdInfo = ttw.db.retrieveBookingId(intBookingIdInput);

                    if (bookingIdInfo.getArtist() == null) {
                        correctionInput.setText("This is an invalid booking ID number");
                    } else {
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

                        //removes items if the confirm button is getting clicked again 
                        refundNumOfTickets.removeAllItems();

                        for (int i = 1; i <= bookingIdInfo.getNumber_of_tickets(); i++) {
                            refundNumOfTickets.addItem(i);
                        }
                        refundInput.add(refundNumOfTickets);

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
                
                double perTicket = bookingIdInfo.getTotal_cost() / bookingIdInfo.getNumber_of_tickets();
                refundTicketsSelected = Integer.parseInt(refundNumOfTickets.getSelectedItem().toString());
                refundAmountDouble = refundTicketsSelected * perTicket;

                refundAmountDouble = Math.round(refundAmountDouble * 100.0) / 100.0;

                refundAmount.setText("Refund amount is: $" + refundAmountDouble);
                refundInput.add(submitRefund);
            }

        });
        
        submitRefund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userBookingIdInput = userBookingId.getText().trim();
                int intBookingIdInput = Integer.parseInt(userBookingIdInput);
                //CustomerUpdate bookingIdInfo = ttw.db.retrieveBookingId(intBookingIdInput);
                ttw.db.refundTickets(intBookingIdInput, refundTicketsSelected, refundAmountDouble); 
                
                success.setText("Refund Successful!"); 
                refundInput.add(exitButton); 
                revalidate(); 
                repaint(); 
                
            }
            
        }); 
        
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
            
        });

        panel.add(refundInput, BorderLayout.SOUTH);  //adds to panel 
        //adding components to panel 
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public boolean checkDetailRequirements() {
        String userBookingIdInput = userBookingId.getText().trim();

        //ensures that all JTextFields aren't left empty
        if (userBookingIdInput.isEmpty()) {
            correctionInput.setText("Please do not leave text field empty");
            return false;
        }
        //ensures the name is letters only (not digits)
        if (!(userBookingIdInput.matches("-?[0-9]+"))) {
            correctionInput.setText("Please enter digits when entering your booking ID");
            return false;
        }
        correctionInput.setText("");
        return true;
    }
}
