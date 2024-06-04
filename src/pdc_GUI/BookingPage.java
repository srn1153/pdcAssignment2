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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class BookingPage extends JPanel implements BookingPageInterface{    
    protected final TempoTicketsWebsite ttw; 
    
    public BookingPage(TempoTicketsWebsite ttw){
        this.ttw = ttw; 
        detailsPage(); 
    }
    
    public JPanel getContent() {
        return this; 
    }
    
    @Override
    public void ticketType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void numberOfTickets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void detailsPage() {
        setLayout(new BorderLayout()); 
        
        JPanel bookingPanel = new JPanel(); 
        bookingPanel.setLayout(new BoxLayout(bookingPanel, BoxLayout.Y_AXIS)); 
                
        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BorderLayout());
        JButton homeButton = Buttons.homePageButton(ttw); 
        homeButtonPanel.add(homeButton, BorderLayout.WEST); 
        bookingPanel.add(homeButtonPanel); 
        add(bookingPanel, BorderLayout.NORTH);
        
        //displaying title (this is the stage after logging in)
        JLabel loggedIn = new JLabel("You have successfully logged in!");
        loggedIn.setFont(new Font("Garamond", Font.BOLD, 28)); 
        loggedIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingPanel.add(loggedIn); 
        
        bookingPanel.add(Box.createVerticalStrut(20)); 
        
        //adding in text before drop boxes 
        JLabel title = new JLabel("Select from the options below:");
        title.setFont(new Font("Garamond", Font.BOLD, 20)); 
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingPanel.add(title);
        
        add(bookingPanel, BorderLayout.NORTH);
    }

    
}
