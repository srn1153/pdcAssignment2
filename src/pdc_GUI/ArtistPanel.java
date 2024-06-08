/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class ArtistPanel extends JPanel implements PanelInterface{
    private final TempoTicketsWebsite ttw; 
    private final Artist aInfo;
    public CustomerUpdate userInfo; 
    
    public ArtistPanel(TempoTicketsWebsite ttw, Artist aInfo,CustomerUpdate userInfo){
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
                
        //creating an panel for artist's info
        JPanel artistPanel = new JPanel(); 
        artistPanel.setLayout(new BoxLayout(artistPanel, BoxLayout.Y_AXIS)); 
        artistPanel.setBackground(new Color(235, 239, 242)); //light blue background
        
        //displays artist's name
        JLabel name = new JLabel(aInfo.getArtistName());
        name.setFont(new Font("Garamond", Font.BOLD, 40)); 
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(name); 
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(30)); 
        
        //displaying artist's genre
        JLabel genre = new JLabel("Genre: " + aInfo.getGenre());
        genre.setFont(new Font("Garamond", Font.BOLD, 30)); 
        genre.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        genre.setForeground(new Color(118, 149, 182)); //dark blue 
        artistPanel.add(genre);
        
        //adding gaps between info
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying location
        JLabel loc = new JLabel("Location: " + aInfo.getLoc());
        loc.setFont(new Font("Garamond", Font.BOLD, 30)); 
        loc.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        loc.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(loc);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying date
        JLabel date = new JLabel("Date: " + aInfo.getDate());
        date.setFont(new Font("Garamond", Font.BOLD, 30)); 
        date.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        date.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(date);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying time
        JLabel time = new JLabel("Time: " + aInfo.getTime());
        time.setFont(new Font("Garamond", Font.BOLD, 30)); 
        time.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        time.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(time);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(15)); 
        
        //displaying price
        JLabel price = new JLabel("Price: $" + aInfo.getPrice());
        price.setFont(new Font("Garamond", Font.BOLD, 30)); 
        price.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        price.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(price);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(20)); 
        
        //displaying disclaimer
        JLabel fyi = new JLabel("Disclaimer: All tickets sold are for standing areas.");
        fyi.setFont(new Font("Garamond", Font.BOLD, 18)); 
        fyi.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        fyi.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(fyi);
        
        JLabel fyi2 = new JLabel("However, we do provide wheelchair-accessible sections.");
        fyi2.setFont(new Font("Garamond", Font.BOLD, 18)); 
        fyi2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        fyi2.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(fyi2);
        
        JLabel fyi3 = new JLabel("We apologise for any inconvenience");
        fyi3.setFont(new Font("Garamond", Font.BOLD, 18)); 
        fyi3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        fyi3.setForeground(new Color(118, 149, 182)); //dark blue
        artistPanel.add(fyi3);
        
        //adding gaps between info 
        artistPanel.add(Box.createVerticalStrut(30)); 
        
        //centering information about artist
        add(artistPanel, BorderLayout.CENTER);
        
        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo); 
        homeButtonPanel.add(homeButton); 
        add(homeButtonPanel, BorderLayout.NORTH); 
        
        //adds booking button 
        Buttons.bookingStage(ttw, artistPanel, aInfo);
    }

    @Override
    public boolean checkDetailRequirements() {
        return true; 
    }
}