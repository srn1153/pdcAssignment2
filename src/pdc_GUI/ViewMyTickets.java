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
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class ViewMyTickets extends JPanel implements PanelInterface {

    private TempoTicketsWebsite ttw;
    public Artist aInfo;
    private CustomerUpdate userInfo;
    public JLabel userBookingId;
    public JLabel artistChosen;
    public JLabel venue;
    public JLabel date;
    public JLabel time;
    public JLabel ticketTypeChosen;
    public JLabel numOfTicketsChosen;
    public JLabel totalCost;

    public ViewMyTickets(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo) throws InterruptedException {
        this.ttw = ttw;
        this.aInfo = aInfo;
        this.userInfo = userInfo;
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
        JLabel title = new JLabel("Here are all your purchased tickets!");
        title.setFont(new Font("Garamond", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        //describing purpose of this page 
        JLabel purpose = new JLabel("Below displays all details relating to events you have booked!");
        purpose.setFont(new Font("Garamond", Font.PLAIN, 18));
        purpose.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(purpose);

        //adds in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton);

        add(homeButtonPanel, BorderLayout.NORTH);

        //creates new panel 
        JPanel ticketDisplayPanel = new JPanel();
        ticketDisplayPanel.setLayout(null);

        //booking id text 
        JLabel bookingId = new JLabel("Booking ID: ");
        bookingId.setBounds(90, 40, 200, 25);
        ticketDisplayPanel.add(bookingId);

        //artist text 
        JLabel artist = new JLabel("Artist: ");
        artist.setBounds(90, 70, 200, 25);
        ticketDisplayPanel.add(artist);

        //venue text 
        JLabel venueText = new JLabel("Event venue:");
        venueText.setBounds(90, 100, 200, 25);
        ticketDisplayPanel.add(venueText);

        //date text 
        JLabel dateText = new JLabel("Event Date: ");
        dateText.setBounds(90, 130, 200, 25);
        ticketDisplayPanel.add(dateText);
        //retrieves user's artist's date 
        date = new JLabel("");
        date.setBounds(200, 130, 200, 25);
        ticketDisplayPanel.add(date);

        //time text 
        JLabel timeText = new JLabel("Event Time: ");
        timeText.setBounds(90, 160, 200, 25);
        ticketDisplayPanel.add(timeText);
        //retrieves user's artist's time 
        time = new JLabel("");
        time.setBounds(200, 160, 200, 25);
        ticketDisplayPanel.add(time);

        //ticketType text 
        JLabel ticketType = new JLabel("Ticket type selected: ");
        ticketType.setBounds(90, 190, 200, 25);
        ticketDisplayPanel.add(ticketType);

        //number of tickets text 
        JLabel numOfTickets = new JLabel("Number of tickets purchased: ");
        numOfTickets.setBounds(90, 220, 200, 25);
        ticketDisplayPanel.add(numOfTickets);

        //total cost text 
        JLabel totalCostText = new JLabel("Total Cost: $");
        totalCostText.setBounds(90, 250, 200, 25);
        ticketDisplayPanel.add(totalCostText);
        
        System.out.println(userInfo.getBookingIds());

        List<Integer> bookingIds = userInfo.getBookingIds(); 
        List<String> artists = userInfo.getArtists(); 
        List<String> ticketTypes = userInfo.getTicketTypes(); 
        List<Integer> numberOfTickets = userInfo.getNumberOfTickets(); 
        List<Double> totalCosts = userInfo.getTotalCosts();
        
        System.out.println(bookingIds);
        System.out.println(artists);
        System.out.println(ticketTypes);
        System.out.println(numberOfTickets);
        System.out.println(totalCosts);

       /*for (int i = 0; i < bookingIds.size(); i++){
            //JPanel for booking details 
            JPanel bookingDetails = new JPanel(); 
            bookingDetails.setLayout(null); 
                    
            //booking id text 
            JLabel bookingId = new JLabel("Booking ID: " + bookingIds.get(i));
            //bookingId.setBounds(90, 40, 200, 25);
            bookingDetails.add(bookingId);

            //artist text 
            JLabel artist = new JLabel("Artist: " + artists.get(i));
            //artist.setBounds(90, 70, 200, 25);
            bookingDetails.add(artist);

            //venue text 
            JLabel venueText = new JLabel("Event venue:");
            //venueText.setBounds(90, 100, 200, 25);
            bookingDetails.add(venueText);

            //date text 
            JLabel dateText = new JLabel("Event Date: ");
            //dateText.setBounds(90, 130, 200, 25);
            bookingDetails.add(dateText);
            //retrieves user's artist's date 
            date = new JLabel("");
            //date.setBounds(200, 130, 200, 25);
            bookingDetails.add(date);

            //time text 
            JLabel timeText = new JLabel("Event Time: ");
            //timeText.setBounds(90, 160, 200, 25);
            bookingDetails.add(timeText);
            //retrieves user's artist's time 
            time = new JLabel("");
            //time.setBounds(200, 160, 200, 25);
            bookingDetails.add(time);

            //ticketType text 
            JLabel ticketType = new JLabel("Ticket type selected: " + ticketTypes.get(i));
            //ticketType.setBounds(90, 190, 200, 25);
            bookingDetails.add(ticketType);

            //number of tickets text 
            JLabel numOfTickets = new JLabel("Number of tickets purchased: " + numberOfTickets.get(i));
            //numOfTickets.setBounds(90, 220, 200, 25);
            bookingDetails.add(numOfTickets);

            //total cost text 
            JLabel totalCostText = new JLabel("Total Cost: $" + totalCosts.get(i));
            //totalCostText.setBounds(90, 250, 200, 25);
            bookingDetails.add(totalCostText);
            
            ticketDisplayPanel.add(bookingDetails); 
            ticketDisplayPanel.add(Box.createVerticalStrut(20)); 
        }*/
        //adds another homepage button if they want to return after checking details 
        JButton goBackToHomePage = Buttons.homePageButton(ttw, aInfo);
        goBackToHomePage.setBounds(190, 290, 200, 25);
        ticketDisplayPanel.add(goBackToHomePage);

        //creates exit button for the user to exit the website after looking at details 
        JButton exitButton = new JButton("Exit the website");
        exitButton.setBounds(190, 340, 200, 25);
        ticketDisplayPanel.add(exitButton);

        //adding components to panel 
        panel.add(ticketDisplayPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        
        }); 
    }
    
    

    @Override
    public boolean checkDetailRequirements() {
        return true;
    }

}
