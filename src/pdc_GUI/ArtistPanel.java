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
class ArtistPanel extends BookingPage{
    private final TempoTicketsWebsite ttw; 
    private final Artist artist; 
    
    public ArtistPanel(TempoTicketsWebsite ttw, Artist artist){
        super(ttw, artist); 
        this.ttw = ttw; 
        this.artist = artist; 
        artistInitialScreen(artist); 
    }

    private void artistInitialScreen(Artist artist) {
        setLayout(new BorderLayout()); 
        
        JPanel artistPanel = new JPanel(); 
        artistPanel.setLayout(new BoxLayout(artistPanel, BoxLayout.Y_AXIS)); 
        
        //displaying artist name
        JLabel name = new JLabel(artist.getArtistName());
        name.setFont(new Font("Garamond", Font.BOLD, 40)); 
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        artistPanel.add(name); 
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(30)); 
        
        //displaying genre
        JLabel genre = new JLabel("Genre: " + artist.getGenre());
        genre.setFont(new Font("Garamond", Font.PLAIN, 30)); 
        genre.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(genre);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying location
        JLabel loc = new JLabel("Location: " + artist.getLoc());
        loc.setFont(new Font("Garamond", Font.PLAIN, 30)); 
        loc.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(loc);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying date
        JLabel date = new JLabel("Date: " + artist.getDate());
        date.setFont(new Font("Garamond", Font.PLAIN, 30)); 
        date.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(date);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying time
        JLabel time = new JLabel("Time: " + artist.getTime());
        time.setFont(new Font("Garamond", Font.PLAIN, 30)); 
        time.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(time);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying price
        JLabel price = new JLabel("Price: $" + artist.getPrice());
        price.setFont(new Font("Garamond", Font.PLAIN, 30)); 
        price.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(price);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(20)); 
        
        //displaying disclaimer
        JLabel fyi = new JLabel("Disclaimer: All tickets sold are for standing areas.");
        fyi.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        fyi.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(fyi);
        JLabel fyi2 = new JLabel("However, we do provide wheelchair-accessible sections.");
        fyi2.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        fyi2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(fyi2);
        
        JLabel fyi3 = new JLabel("We apologise for any inconvenience");
        fyi3.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        fyi3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        artistPanel.add(fyi3);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(30)); 
        
        //centering information about artist
        add(artistPanel, BorderLayout.CENTER);
        
        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw); 
        homeButtonPanel.add(homeButton); 
        add(homeButtonPanel, BorderLayout.NORTH); 
        
        //adding in ticket button 
        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new BoxLayout(bookingPanel, BoxLayout.Y_AXIS));
        JButton bookingButton = Buttons.bookingStage(ttw, bookingPanel, artist); 
        bookingPanel.add(bookingButton); 
        artistPanel.add(bookingPanel);
    
    }
}
