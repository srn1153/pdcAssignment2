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
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

    public ViewMyTickets(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo){
        
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
        panel.setBackground(new Color(235, 239, 242)); //light blue background

        //adding title 
        JLabel title = new JLabel("Here are all your purchased tickets!");
        title.setFont(new Font("Garamond", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        panel.add(title);

        //describing purpose of this page 
        JLabel purpose = new JLabel("Below displays all details relating to events you have booked!");
        purpose.setFont(new Font("Garamond", Font.PLAIN, 18));
        purpose.setAlignmentX(Component.CENTER_ALIGNMENT);
        purpose.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        panel.add(Box.createVerticalStrut(10));
        panel.add(purpose);

        //adds in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton);

        add(homeButtonPanel, BorderLayout.NORTH);

        //creating new panel to display details
        JPanel bookingsPanel = new JPanel();
        bookingsPanel.setLayout(new BoxLayout(bookingsPanel, BoxLayout.Y_AXIS));
        bookingsPanel.setBackground(new Color(235, 239, 242)); //light blue background

        //retrieving lists from CustomerUpdate
        List<Integer> bookingIds = userInfo.getBookingIds();
        List<String> artists = userInfo.getArtists();
        List<String> locations = userInfo.getLocations();
        List<String> dates = userInfo.getDates();
        List<String> times = userInfo.getTimes();
        List<String> ticketTypes = userInfo.getTicketTypes();
        List<Integer> numberOfTickets = userInfo.getNumberOfTickets();
        List<Double> totalCosts = userInfo.getTotalCosts();

        //specifically this 'for' loop is sourced from chatgpt this accounts for users with multiple bookings
        for (int i = 0; i < bookingIds.size(); i++) {
            JPanel bookingPanel = createBookingPanel(bookingIds.get(i), artists.get(i), locations.get(i), dates.get(i), times.get(i), ticketTypes.get(i), numberOfTickets.get(i), totalCosts.get(i));
            bookingPanel.setBackground(new Color(235, 239, 242)); //light blue background
            bookingsPanel.add(bookingPanel);
            bookingsPanel.add(Box.createVerticalStrut(10));
        }

        //adding scrolling feature so if customer has multiple bookings they're able to see all bookings on one panel
        JScrollPane scrollPane = new JScrollPane(bookingsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane, BorderLayout.CENTER);

        //creates exit button for the user to exit the website after looking at details 
        JButton backToLogin = new JButton("Back to Login Management");
        backToLogin.setBackground(new Color(163, 194, 227)); //light blue 
        backToLogin.setForeground(Color.WHITE); //white text
        panel.add(backToLogin, BorderLayout.SOUTH);
        panel.add(backToLogin);

        backToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new LoginForAccountDetails(ttw, aInfo, userInfo) {});              
            }
        });

        //adding components to panel 
        add(panel, BorderLayout.CENTER);
    }

    //this method is sourced from chatgpt, however I changed the components within the method to make the bookings presentable
    public JPanel createBookingPanel(int bookingId, String artist, String location, String date, String time, String ticketType, int numberOfTickets, double totalCost) {
        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new BoxLayout(bookingPanel, BoxLayout.Y_AXIS));
        bookingPanel.setBackground(new Color(235, 239, 242)); //light blue background

        //displaying booking id 
        JLabel bookingIdLabel = new JLabel("Booking ID: " + bookingId);
        bookingIdLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        bookingIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingPanel.add(bookingIdLabel);

        //displaying artist 
        JLabel artistLabel = new JLabel("Artist: " + artist);
        artistLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        artistLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(artistLabel);
        
        //displaying artist venue
        JLabel artistVenueLabel = new JLabel("Location: " + location);
        artistVenueLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        artistVenueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(artistVenueLabel);
        
        //displaying artist date
        JLabel artistDateLabel = new JLabel("Date: " + date);
        artistDateLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        artistDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(artistDateLabel);
        
        //displaying artist time
        JLabel artistTimeLabel = new JLabel("Time: " + time);
        artistTimeLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        artistTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(artistTimeLabel);

        //display ticket type selected 
        JLabel ticketTypeLabel = new JLabel("Ticket Type: " + ticketType);
        ticketTypeLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        ticketTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(ticketTypeLabel);

        //displaying number of tickets 
        JLabel numOfTicketsLabel = new JLabel("Number of Tickets: " + numberOfTickets);
        numOfTicketsLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        numOfTicketsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(numOfTicketsLabel);

        //displaying total cost
        JLabel totalCostLabel = new JLabel("Total Cost: $" + totalCost);
        totalCostLabel.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        totalCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(totalCostLabel);

        //adding divider in between different bookings 
        JLabel divider = new JLabel("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        divider.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        //centering information
        divider.setAlignmentX(Component.CENTER_ALIGNMENT);
        //adding gaps between each row for readability
        bookingPanel.add(Box.createVerticalStrut(10));
        bookingPanel.add(divider);

        return bookingPanel;
    }

    @Override
    public boolean checkDetailRequirements() {
        return true;
    }
}
