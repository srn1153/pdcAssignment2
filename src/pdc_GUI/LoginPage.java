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
    private Artist artist; 
    CustomerUpdate userInfo; 
    
    public LoginPage(TempoTicketsWebsite ttw, Artist artist, CustomerUpdate userInfo){
        this.ttw = ttw; 
        this.artist = artist; 
        this.userInfo = userInfo; 
        LoginPanel(); 
    }
    
    public void LoginPanel() {
        setLayout(new BorderLayout()); 
        
        //creating panel 
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        
        JLabel welcome = new JLabel("Sign in/up here!"); 
        welcome.setFont(new Font("Garamond", Font.BOLD, 26)); 
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(welcome); 
        
        //adding sign in test
        JLabel upcoming = new JLabel("Owning an account can help keep track of purchased tickets and new events!"); 
        upcoming.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        upcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(upcoming); 
                
        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw); 
        homeButtonPanel.add(homeButton); 
        add(homeButtonPanel, BorderLayout.NORTH);  
        
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
        registerText.setBounds(10, 140, 500, 25); 
        loginPanel.add(registerText); 
        
        //email text 
        JLabel email = new JLabel("Email:"); 
        email.setBounds(10, 170, 80, 25); 
        //username text field 
        JTextField emailText = new JTextField(50);
        emailText.setBounds(150, 170, 200, 25); 
        
        //phone number text 
        JLabel phoneNo = new JLabel("Phone number:"); 
        phoneNo.setBounds(10, 200, 100, 25); 
        //phone number text field 
        JTextField phoneNoText = new JTextField(50);
        phoneNoText.setBounds(150, 200, 200, 25); 
        
        //creating register button but not displaying it yet 
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 230, 100, 25); 

        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText(); 
                String pass = passText.getText(); 
                
                Database db = new Database(); 
                CustomerUpdate info = db.checkName(user, pass); 
             
                if(info.loginFlag) {//if username and password match
                    noSuchUser.setText("Login successful!"); 
                    ttw.nextPage(new BookingPage(ttw, artist, userInfo) {}); 
                } else{ //if username and password do not match, display messages and register button
                    noSuchUser.setText("Your username or password was incorrect"); 
                    registerText.setText("Sign up by filling in details below and clicking the 'Register' button!"); 
                    
                    loginPanel.add(email); 
                    loginPanel.add(emailText);
                    loginPanel.add(phoneNo); 
                    loginPanel.add(phoneNoText);
                    
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
                String email = emailText.getText();  
                String phoneNumber = phoneNoText.getText();  
                
                Database db = new Database(); 
                db.createAccount(user, pass, email, phoneNumber); 
                System.out.println("Account created");
                db.printCustomerLoginTable();
                ttw.nextPage(new BookingPage(ttw,artist,userInfo){});
            }
        }); 
           
        panel.add(loginPanel,BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER); 
    }        
}
