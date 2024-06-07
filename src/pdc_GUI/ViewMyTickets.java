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

        JLabel welcome = new JLabel("Here are all your purchased Tickets!");
        welcome.setFont(new Font("Garamond", Font.BOLD, 26));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(welcome);

        //adding sign in test
        JLabel upcoming = new JLabel("Below displays all details relating to events you have booked!");
        upcoming.setFont(new Font("Garamond", Font.PLAIN, 18));
        upcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(upcoming);

        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton);
        add(homeButtonPanel, BorderLayout.NORTH);

        JPanel ticketDisplayPanel = new JPanel();
        ticketDisplayPanel.setLayout(null);
        
        bookingId = new JLabel("");
        bookingId.setBounds(50, 200, 200, 25);
        ticketDisplayPanel.add(bookingId);

        artist = new JLabel("");
        artist.setBounds(50, 230, 200, 25);
        ticketDisplayPanel.add(artist);
        
        venue = new JLabel("");
        venue.setBounds(50, 260, 400, 25);
        ticketDisplayPanel.add(venue);

        date = new JLabel("");
        date.setBounds(50, 290, 200, 25);
        ticketDisplayPanel.add(date);

        time = new JLabel("");
        time.setBounds(50, 320, 200, 25);
        ticketDisplayPanel.add(time);
        
        ticketType = new JLabel("");
        ticketType.setBounds(50, 350, 400, 25);
        ticketDisplayPanel.add(ticketType);

        numOfTickets = new JLabel("");
        numOfTickets.setBounds(50, 380, 200, 25);
        ticketDisplayPanel.add(numOfTickets);

        totalCost = new JLabel("");
        totalCost.setBounds(50, 410, 200, 25);
        ticketDisplayPanel.add(totalCost);

        JButton proceedToPayment = new JButton("Proceed to payment -->");
        proceedToPayment.setBounds(50, 440, 200, 25);

        add(ticketDisplayPanel, BorderLayout.CENTER); 
    }

    @Override
    public boolean checkDetailRequirements() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
