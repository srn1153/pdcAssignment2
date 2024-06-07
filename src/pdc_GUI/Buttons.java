/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

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
    
    //homePage button for every panel/page
    public static JButton homePageButton(TempoTicketsWebsite ttw, Artist aInfo) {
        //creates button
        JButton homeButton = new JButton("<--- back to HomePage"); 
        homeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //once button is clicked it returns to the homepage 
                ttw.nextPage(new HomepagePanel(ttw, ttw.userInfo, aInfo));
            }
        }
        );
        return homeButton; 
    }
    
    //get tickets button for artist panel
    public static JButton bookingStage(TempoTicketsWebsite ttw, JPanel buttonPanel, Artist aInfo){
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    
        buttonPanel.add(Box.createVerticalStrut(30));
        JButton ticketButton = new JButton("Get Tickets!");
        //making button larger
        ticketButton.setPreferredSize(new Dimension(200, 50));
        ticketButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(ticketButton); //adds button to given panel in parameter
        
        ticketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerUpdate cu = ttw.userInfo;  
                //goes to Login in stage before final purchasing 
                ttw.nextPage(new LoginBeforeBooking(ttw, aInfo, cu) {}); 
            }
        }); 
        return ticketButton;    
    }    
}
