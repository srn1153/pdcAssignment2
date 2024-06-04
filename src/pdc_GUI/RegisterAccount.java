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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class RegisterAccount {
    private TempoTicketsWebsite ttw; 
    
    public RegisterAccount(TempoTicketsWebsite ttw){
        this.ttw = ttw; 
        RegisterPanel(); 
    }
    
    public void RegisterPanel() {      
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        panel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        //Adding the welcome to tempo tickets onto panel 
        JLabel welcome = new JLabel("Welcome to "); 
        welcome.setFont(new Font("Garamond", Font.BOLD, 26)); 
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(welcome); 
                
        JLabel tempoTickets = new JLabel("Tempo Tickets"); 
        tempoTickets.setFont(new Font("Garamond", Font.BOLD, 26)); 
        tempoTickets.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(tempoTickets); 
        
        //adding text 
        JLabel upcoming = new JLabel("Sign in/up with us to see the upcoming events!"); 
        upcoming.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        upcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(upcoming); 
        
        //add(panel, BorderLayout.NORTH); 
        JPanel loginPanel = new JPanel(); 
        loginPanel.setLayout(null);
    }
    
}
