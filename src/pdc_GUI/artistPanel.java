/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author nikis
 */
public class artistPanel extends BookingPage {
    private final TempoTicketsWebsite ttw; 
    private final String artistName; 
    
    public artistPanel(TempoTicketsWebsite ttw, String artistName){
        super(ttw); 
        this.ttw = ttw; 
        this.artistName = artistName; 
        artistInitialScreen(artistName); 
    }

    private void artistInitialScreen(String artistName) {
        setLayout(new BorderLayout()); 
        
        JPanel artistPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        JLabel details = new JLabel(artistName + " details will be displayed here!"); //will implement individual details later 
        details.setFont(new Font("Arial", Font.PLAIN, 18)); 
        details.setHorizontalAlignment(SwingConstants.CENTER);
        artistPanel.add(details); 
        add(details, BorderLayout.CENTER); 
        
        JButton homeButton = buttons.homePageButton(ttw); 
        add(homeButton, BorderLayout.NORTH); 
        
        JButton bookingButton = buttons.bookingStage("Book Tickets Nows!"); 
        add(bookingButton, BorderLayout.SOUTH); 
    }
    
    
    
}
