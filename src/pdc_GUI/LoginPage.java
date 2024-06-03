/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author nikis
 */
public class LoginPage extends JPanel{
    private TempoTicketsWebsite ttw; 
    private Database db; 
    private HomepagePanel hpp; 
    
    public LoginPage(TempoTicketsWebsite ttw, Database db){
        this.ttw = ttw; 
        this.db = db; 
        LoginPanel(); 
    }
    
    public void LoginPanel() {
        setLayout(new BorderLayout()); 
        
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
        
        add(panel, BorderLayout.NORTH); 
        
        JPanel loginPanel = new JPanel(); 
        loginPanel.setLayout(new GridLayout(2, 2, 10, 10)); 
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel unLabel = new JLabel("Username:"); 
        unLabel.setHorizontalAlignment(SwingConstants.RIGHT); 
        loginPanel.add(unLabel); 
        
        JTextField usernameField = new JTextField(20);
        loginPanel.add(usernameField);

        JLabel passLabel = new JLabel("Password:"); 
        passLabel.setHorizontalAlignment(SwingConstants.RIGHT); 
        loginPanel.add(passLabel); 
        
        JTextField passwordField = new JTextField(20);
        loginPanel.add(passwordField);
        
        add(loginPanel, BorderLayout.CENTER); 

        JButton loginButton = new JButton("Login/Sign up");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }); 
        loginPanel.add(loginButton); 
        
        add(loginPanel,BorderLayout.CENTER);
    }
}
