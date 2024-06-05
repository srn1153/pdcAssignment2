/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class Buttons {
        
    //homePage button for every stage
    public static JButton homePageButton(TempoTicketsWebsite ttw) {
        JButton homeButton = new JButton("<--- back to HomePage"); 
        homeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new HomepagePanel(ttw));
            }
        }
        );
        return homeButton; 
    }
    
    //ticketButton for artist panel
    public static JButton bookingStage(TempoTicketsWebsite ttw, JPanel buttonPanel, Artist artist){
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    
        buttonPanel.add(Box.createVerticalStrut(30));
        JButton ticketButton = new JButton("Get Tickets!");
        ticketButton.setPreferredSize(new Dimension(200, 50)); //making button bigger 
        //ticketButton.setForeground(Color.WHITE);
        //ticketButton.setBackground(new Color(120, 220, 120));
        ticketButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(ticketButton);
        
        ticketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new LoginPage(ttw, artist) {}); 
            }
        }); 
        return ticketButton;    
    }    
}
