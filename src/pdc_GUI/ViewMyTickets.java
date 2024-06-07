/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
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
    public CustomerUpdate userInfo;
    public JLabel bookingId; 
    public JLabel artist; 
    public JLabel venue; 
    public JLabel date; 
    public JLabel time; 
    public JLabel ticketType; 
    public JLabel numOfTickets;
    public JLabel totalCost; 

    public ViewMyTickets(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo) {
        this.ttw = ttw;
        this.aInfo = aInfo;
        this.userInfo = userInfo;
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
        JLabel title = new JLabel("Here are all your purchased Tickets!");
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
        
        //retrieves user's booking id
        bookingId = new JLabel("");
        bookingId.setBounds(50, 200, 200, 25);
        ticketDisplayPanel.add(bookingId);

        //retrieves user's artist
        artist = new JLabel("");
        artist.setBounds(50, 230, 200, 25);
        ticketDisplayPanel.add(artist);
        
        //retrieves user's artist's venue
        venue = new JLabel("");
        venue.setBounds(50, 260, 400, 25);
        ticketDisplayPanel.add(venue);

        //retrieves user's artist's date 
        date = new JLabel("");
        date.setBounds(50, 290, 200, 25);
        ticketDisplayPanel.add(date);

        //retrieves user's artist's time 
        time = new JLabel("");
        time.setBounds(50, 320, 200, 25);
        ticketDisplayPanel.add(time);
        
        //retrieves user's ticket type 
        ticketType = new JLabel("");
        ticketType.setBounds(50, 350, 400, 25);
        ticketDisplayPanel.add(ticketType);

        //retrieves user's number of tickets 
        numOfTickets = new JLabel("");
        numOfTickets.setBounds(50, 380, 200, 25);
        ticketDisplayPanel.add(numOfTickets);

        //retrieves user's total cost
        totalCost = new JLabel("");
        totalCost.setBounds(50, 410, 200, 25);
        ticketDisplayPanel.add(totalCost);

        //adds another homepage button if they want to return after checking details 
        JButton goBackToHomePage = Buttons.homePageButton(ttw, aInfo);
        goBackToHomePage.setBounds(190, 300, 200, 25);
        
        //creates exit button for the user to exit the website after looking at details 
        JButton exitButton = new JButton("Exit the website");
        exitButton.setBounds(190, 350, 200, 25);
        
        
        add(ticketDisplayPanel, BorderLayout.CENTER); 
    }

    @Override
    public boolean checkDetailRequirements() {
        return true; 
    }

}
