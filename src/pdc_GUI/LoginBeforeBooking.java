/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class LoginBeforeBooking extends LoginPage{ //doesn't implement PanelInterface as no new components are being added so can purely use LoginPage

    private TempoTicketsWebsite ttw;
    public Artist aInfo;
    public CustomerUpdate userInfo;
    
    public LoginBeforeBooking(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo){
        //displays login page, only difference is what happens when the signin or register button is clicked 
        super(ttw, aInfo, userInfo); 
        this.ttw = ttw; 
        this.aInfo = aInfo; 
        this.userInfo = userInfo; 
    }
    
    @Override
    protected ActionListener signInButton(JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton) {
        return (ActionEvent e) -> {
            String user = userText.getText();
            String pass = passText.getText();
            
            //checks if user already exists 
            userInfo = ttw.db.checkName(user, pass);
            
            if (userInfo.isLoginFlag()) {//if username and password match
                noSuchUser.setText("Login successful!");
                //takes user to booking page, as they have already selected an artist based on the page before
                ttw.nextPage(new BookingPage(ttw, aInfo, userInfo) {
                });
            } else { //if username and password do not match, display input messages and register button
                noSuchUser.setText("Your username or password was incorrect, please re-enter");
                loginPanel.add(or);
                registerText.setText("Sign up by filling in details below and clicking the 'Register' button!");
                
                //adds JLables and JTextFields to panel
                //user can fill in details if needed (unless they accidentally entered the wrong username/password
                loginPanel.add(email);
                loginPanel.add(emailText);
                loginPanel.add(phoneNo);
                loginPanel.add(phoneNoText);
                
                //displays register button to create a new account 
                loginPanel.add(registerButton);
                loginPanel.revalidate();
                loginPanel.repaint();
            }
        };
    }

    @Override
    protected ActionListener registerButton(JButton signButton, JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton) {
        return (ActionEvent e) -> {
            //checks if registering requirements are met before continuing 
            if (checkDetailRequirements()) {
                String user = userText.getText();
                String pass = passText.getText();
                String email1 = emailText.getText();
                String phoneNumber = phoneNoText.getText();
                //creates account as all input is valid 
                userInfo = ttw.db.createAccount(user, pass, email1, phoneNumber);
                if (userInfo.isLoginFlag()) {
                    //flag should be set to true if account was created
                    //goes to booking page (further questions)
                    ttw.nextPage(new BookingPage(ttw, aInfo, userInfo) {
                    });
                }
            }   
        };
    }
}
