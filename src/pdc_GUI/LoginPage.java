/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
public abstract class LoginPage extends JPanel implements PanelInterface{
    private TempoTicketsWebsite ttw; 
    public Artist aInfo;
    public CustomerUpdate userInfo;
    public JTextField userText; 
    public JTextField passText; 
    public JLabel correctUserInput; 
    public JTextField emailText; 
    public JTextField phoneNoText; 
    
    public LoginPage(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo){
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
        
        //creates panel 
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        panel.setBackground(new Color(235, 239, 242)); //light blue background
        
        //adds title 
        JLabel title = new JLabel("Sign in/up here!"); 
        title.setFont(new Font("Garamond", Font.BOLD, 26)); 
        title.setAlignmentX(Component.CENTER_ALIGNMENT); 
        title.setForeground(new Color(118, 149, 182)); //dark blue 
        panel.add(title); 
        
        //prompts user to create an account 
        JLabel account = new JLabel("An account helps keep track of purchased tickets and new events!"); 
        account.setFont(new Font("Garamond", Font.BOLD, 18)); 
        account.setAlignmentX(Component.CENTER_ALIGNMENT);
        account.setForeground(new Color(118, 149, 182)); //dark blue 
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(account); 
                
        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo); 
        homeButtonPanel.add(homeButton); 
        add(homeButtonPanel, BorderLayout.NORTH);  
        
        //makes new Login panel
        JPanel loginPanel = new JPanel(); 
        loginPanel.setBackground(new Color(235, 239, 242)); //light blue background
        loginPanel.setLayout(null); 
        
        //asks for username
        JLabel user = new JLabel("Username:");
        user.setFont(new Font("Garamond", Font.BOLD, 16)); 
        user.setBounds(90, 35, 80, 25); 
        user.setForeground(new Color(118, 149, 182)); //dark blue 
        loginPanel.add(user); 
        //username text field 
        userText = new JTextField(20);
        userText.setBounds(300, 40, 165, 25); 
        loginPanel.add(userText);

        //asks for password
        JLabel pass = new JLabel("Password:");
        pass.setFont(new Font("Garamond", Font.BOLD, 16)); 
        pass.setBounds(90, 75, 80, 25); 
        pass.setForeground(new Color(118, 149, 182)); //dark blue 
        loginPanel.add(pass); 
        //password field 
        passText = new JPasswordField(20); 
        passText.setBounds(300, 80, 165, 25); 
        loginPanel.add(passText);
        
        //adding sign in/up button 
        JButton signButton = new JButton("Sign in/up");
        signButton.setFont(new Font("Garamond", Font.BOLD, 16)); 
        signButton.setBounds(90, 110, 150, 25);
        signButton.setBackground(new Color(163, 194, 227)); //light blue 
        signButton.setForeground(Color.WHITE); //light blue 
        loginPanel.add(signButton); 
        
        //creating empty label to display messgae later 
        JLabel noSuchUser = new JLabel(""); 
        noSuchUser.setFont(new Font("Garamond", Font.BOLD, 16)); 
        noSuchUser.setBounds(90, 140, 500, 25); 
        noSuchUser.setForeground(new Color(118, 149, 182)); //dark blue 
        loginPanel.add(noSuchUser); 
        
        //creating OR label to display message later
        JLabel or = new JLabel("OR"); 
        or.setFont(new Font("Garamond", Font.BOLD, 16)); 
        or.setForeground(new Color(118, 149, 182)); //dark blue 
        or.setBounds(90, 180, 500, 25); 
        
        //creating empty label to display message later
        JLabel registerText = new JLabel("");
        registerText.setFont(new Font("Garamond", Font.BOLD, 16)); 
        registerText.setBounds(90, 210, 500, 25); 
        registerText.setForeground(new Color(118, 149, 182)); //dark blue 
        loginPanel.add(registerText); 
        
        //asks for email
        JLabel email = new JLabel("Email:"); 
        email.setFont(new Font("Garamond", Font.BOLD, 16)); 
        email.setBounds(90, 240, 80, 25); 
        email.setForeground(new Color(118, 149, 182)); //dark blue 
        //email text field 
        emailText = new JTextField(50);
        emailText.setBounds(300, 240, 200, 25); 
        
        //asks for phone number
        JLabel phoneNo = new JLabel("Phone number:"); 
        phoneNo.setFont(new Font("Garamond", Font.BOLD, 16)); 
        phoneNo.setBounds(90, 280, 150, 25); 
        phoneNo.setForeground(new Color(118, 149, 182)); //dark blue 
        //phone number text field 
        phoneNoText = new JTextField(50);
        phoneNoText.setBounds(300, 280, 200, 25); 
        
        //creates register button but not displaying it yet 
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Garamond", Font.BOLD, 16)); 
        registerButton.setBounds(90, 320, 100, 25); 
        registerButton.setBackground(new Color(163, 194, 227)); //light blue
        registerButton.setForeground(Color.WHITE); //light blue 

        
        //message that will be set of user's input is incorrect 
        correctUserInput = new JLabel(""); 
        correctUserInput.setFont(new Font("Garamond", Font.BOLD, 16)); 
        correctUserInput.setBounds(90, 350, 500, 25);
        correctUserInput.setForeground(new Color(118, 149, 182)); //dark blue 
        loginPanel.add(correctUserInput); 
        
        //adding actionlistener for sign in button
        signButton.addActionListener(signInButton(noSuchUser, loginPanel, registerText, or, email, phoneNo, registerButton)); 
        //adding actionlistener for register button
        registerButton.addActionListener(registerButton(signButton, noSuchUser, loginPanel, registerText, or, email, phoneNo, registerButton)); 
 
        //adds components to panel 
        panel.add(loginPanel,BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER); 
    }    
    
    //abstract method for actionlistener for sign in button
    protected abstract ActionListener signInButton(JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton); 
    //abstract method for actionlistener for register button
    protected abstract ActionListener registerButton(JButton signButton, JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton); 

    @Override
    public boolean checkDetailRequirements() { //ensures all details are correct, returns true or false based on user's input 
        String usernameInput = userText.getText().trim(); 
        String passwordInput = passText.getText().trim(); 
        String emailInput = emailText.getText().trim(); 
        String phoneNoInput = phoneNoText.getText().trim(); 
        
        //ensures that all JTextFields aren't left empty
        if(usernameInput.isEmpty() || passwordInput.isEmpty() || emailInput.isEmpty() || phoneNoInput.isEmpty()){
            correctUserInput.setText("Please do not leave any details empty"); 
            return false; 
        }
        
        //ensures that username and password is more than 8 characters
        if(usernameInput.length() < 8 || passwordInput.length() < 8){
            correctUserInput.setText("Ensure you have a minimum of 8 characters for your username and password"); 
            return false; 
        }
        
        //ensures that the email is valid with "@" sign
        if (!emailInput.contains("@")){
            correctUserInput.setText("Ensure email is valid"); 
            return false; 
        }
        
        //ensures the phone number is 8 or more digits 
        if(phoneNoInput.length() < 8){
            correctUserInput.setText("Ensure your phone number is 8 or more digits"); 
            return false; 
        }
        
        //ensures the phone number is less than 13 digits 
        if(phoneNoInput.length() > 13){
            correctUserInput.setText("Ensure your phone number is less than 13 digits"); 
            return false; 
        }
        
        //checks that the phone number input can be parsed to an int, this way I know that the phone number is valid (not letters)
        try {
            Double.parseDouble(phoneNoInput); 
        } catch (NumberFormatException ex){
            correctUserInput.setText("Please enter digits for a valid phone number"); 
            return false; 
        }
        //if all user input sections are valid then no correction message is displayed
        correctUserInput.setText(""); 
        return true; 
    }
}
