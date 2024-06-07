/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
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
        JButton homeButton = Buttons.homePageButton(ttw, aInfo); 
        homeButtonPanel.add(homeButton); 
        add(homeButtonPanel, BorderLayout.NORTH);  
        
        JPanel loginPanel = new JPanel(); 
        loginPanel.setLayout(null); 
        
        //username text 
        JLabel user = new JLabel("Username:"); 
        user.setBounds(90, 35, 80, 25); 
        loginPanel.add(user); 
        //username text field 
        userText = new JTextField(20);
        userText.setBounds(300, 40, 165, 25); 
        loginPanel.add(userText);

        //password text
        JLabel pass = new JLabel("Password:"); 
        pass.setBounds(90, 75, 80, 25); 
        loginPanel.add(pass); 
        //password field 
        passText = new JPasswordField(20); 
        passText.setBounds(300, 80, 165, 25); 
        loginPanel.add(passText);
        
        //adding sign in/up button 
        JButton signButton = new JButton("Sign in/up");
        signButton.setBounds(90, 110, 100, 25); 
        loginPanel.add(signButton); 
        
        //creating empty label to display messgae later 
        JLabel noSuchUser = new JLabel(""); 
        noSuchUser.setBounds(90, 150, 500, 25); 
        loginPanel.add(noSuchUser); 
        
        //creating empty label to display message later
        JLabel or = new JLabel("OR"); 
        or.setBounds(90, 180, 500, 25); 
        
        //creating empty label to display message later
        JLabel registerText = new JLabel(""); 
        registerText.setBounds(90, 210, 500, 25); 
        loginPanel.add(registerText); 
        
        //email text 
        JLabel email = new JLabel("Email:"); 
        email.setBounds(90, 240, 80, 25); 
        //username text field 
        emailText = new JTextField(50);
        emailText.setBounds(300, 240, 200, 25); 
        
        //phone number text 
        JLabel phoneNo = new JLabel("Phone number:"); 
        phoneNo.setBounds(90, 280, 100, 25); 
        //phone number text field 
        phoneNoText = new JTextField(50);
        phoneNoText.setBounds(300, 280, 200, 25); 
        
        //creating register button but not displaying it yet 
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(90, 320, 100, 25); 
        
        correctUserInput = new JLabel(""); 
        correctUserInput.setBounds(90, 350, 500, 25); 
        loginPanel.add(correctUserInput); 
        
        signButton.addActionListener(signInButton(noSuchUser, loginPanel, registerText, or, email, phoneNo, registerButton)); 
        registerButton.addActionListener(registerButton(signButton, noSuchUser, loginPanel, registerText, or, email, phoneNo, registerButton)); 
 
        panel.add(loginPanel,BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER); 
    }    
    
    protected abstract ActionListener signInButton(JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton); 
    protected abstract ActionListener registerButton(JButton signButton, JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton); 

    @Override
    public boolean checkDetailRequirements() {
        String usernameInput = userText.getText().trim(); 
        String passwordInput = passText.getText().trim(); 
        String emailInput = emailText.getText().trim(); 
        String phoneNoInput = phoneNoText.getText().trim(); 
        
        //checks that all JTextFields aren't left empty
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
        
        //ensures the phone number is 8 or mroe digits 
        if(phoneNoInput.length() < 8){
            correctUserInput.setText("Ensure your phone number is 8 or more digits"); 
            return false; 
        }
        
        //ensures the phone number is 8 or mroe digits 
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
        correctUserInput.setText(""); 
        return true; 
    }
}
