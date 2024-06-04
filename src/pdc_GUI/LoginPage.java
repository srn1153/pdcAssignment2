/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author nikis
 */
public class LoginPage extends JPanel{
    private TempoTicketsWebsite ttw; 
    
    public LoginPage(TempoTicketsWebsite ttw){
        this.ttw = ttw; 
        LoginPanel(); 
    }
    
    public void LoginPanel() {
        setLayout(new BorderLayout()); 
        
        //creating panel 
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        panel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        //adding the welcome to tempo tickets onto panel 
        JLabel welcome = new JLabel("Welcome to "); 
        welcome.setFont(new Font("Garamond", Font.BOLD, 26)); 
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(welcome); 
                
        JLabel tempoTickets = new JLabel("Tempo Tickets"); 
        tempoTickets.setFont(new Font("Garamond", Font.BOLD, 26)); 
        tempoTickets.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(tempoTickets); 
        
        //adding sign in test
        JLabel upcoming = new JLabel("Sign in/up with us to see the upcoming events!"); 
        upcoming.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        upcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(upcoming); 
        
        add(panel, BorderLayout.NORTH); 
        JPanel loginPanel = new JPanel(); 
        loginPanel.setLayout(null); 
        
        //username text 
        JLabel user = new JLabel("Username:"); 
        user.setBounds(10, 20, 80, 25); 
        loginPanel.add(user); 
        //username text field 
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25); 
        loginPanel.add(userText);

        //password text
        JLabel pass = new JLabel("Password:"); 
        pass.setBounds(10, 50, 80, 25); 
        loginPanel.add(pass); 
        //password field 
        JPasswordField passText = new JPasswordField(20); 
        passText.setBounds(100, 50, 165, 25); 
        loginPanel.add(passText);
        
        //adding sign in/up button 
        JButton signButton = new JButton("Sign in/up");
        signButton.setBounds(10, 80, 100, 25); 
        loginPanel.add(signButton); 
        
        //creating empty label to display messgae later 
        JLabel noSuchUser = new JLabel(""); 
        noSuchUser.setBounds(10, 110, 300, 25); 
        loginPanel.add(noSuchUser); 
        
        //creating empty label to display message later
        JLabel registerText = new JLabel(""); 
        registerText.setBounds(10, 140, 300, 25); 
        loginPanel.add(registerText); 
        
        //creating register button but not displaying it yet 
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 170, 100, 25); 
        
        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText(); 
                String pass = passText.getText(); 
                
                Database db = new Database(); 
                CustomerUpdate info = db.checkName(user, pass); 
             
                if(info.loginFlag) {//if username and password match
                    noSuchUser.setText("Login successful!"); 
                } else{ //if username and password do not match, display messages and register button
                    noSuchUser.setText("Your username or password was incorrect"); 
                    registerText.setText("Sign up by clicking button below!"); 
                    loginPanel.add(registerButton); 
                    loginPanel.revalidate(); 
                    loginPanel.repaint(); 
                }
            }
        }); 
        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText(); 
                String pass = passText.getText(); 
                
                Database db = new Database(); 
                db.createAccount(user, pass); 
                System.out.println("Account created");
                db.printCustomerLoginTable();
                //add in next page here
            }
        }); 
           
        add(loginPanel,BorderLayout.CENTER);
    }        
}
