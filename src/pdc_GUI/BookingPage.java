/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author nikis
 */
public abstract class BookingPage extends JPanel implements BookingPageInterface{    
    protected final TempoTicketsWebsite ttw; 
    
    public BookingPage(TempoTicketsWebsite ttw){
        this.ttw = ttw; 
        setLayout(new BorderLayout()); 
        detailsPage(); 
    }
    
    public JPanel getContent() {
        return this; 
    }

    private void detailsPage() {
        
        JPanel bookingPanel = new JPanel(); 
        JLabel title = new JLabel("Booking Page"); 
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        bookingPanel.add(title, BorderLayout.NORTH); 
        
        JButton homeButton = buttons.homePageButton(ttw); 
        bookingPanel.add(homeButton, BorderLayout.SOUTH); 
        
        add(bookingPanel, BorderLayout.NORTH); 
    }
}
