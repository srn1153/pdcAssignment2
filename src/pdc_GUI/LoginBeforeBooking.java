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
public class LoginBeforeBooking extends LoginPage {

    private TempoTicketsWebsite ttw;
    public Artist aInfo;
    public CustomerUpdate userInfo;
    
    public LoginBeforeBooking(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo){
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
            
            userInfo = ttw.db.checkName(user, pass);
            
            if (userInfo.isLoginFlag()) {//if username and password match
                noSuchUser.setText("Login successful!");
                ttw.nextPage(new BookingPage(ttw, aInfo, userInfo) {
                });
            } else { //if username and password do not match, display messages and register button
                noSuchUser.setText("Your username or password was incorrect, please re-enter");
                loginPanel.add(or);
                registerText.setText("Sign up by filling in details below and clicking the 'Register' button!");
                
                loginPanel.add(email);
                loginPanel.add(emailText);
                loginPanel.add(phoneNo);
                loginPanel.add(phoneNoText);
                
                loginPanel.add(registerButton);
                loginPanel.revalidate();
                loginPanel.repaint();
            }
        };
    }

    @Override
    protected ActionListener registerButton(JButton signButton, JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton) {
        return (ActionEvent e) -> {
            if (checkDetailRequirements()) {
                String user = userText.getText();
                String pass = passText.getText();
                String email1 = emailText.getText();
                String phoneNumber = phoneNoText.getText();
                userInfo = ttw.db.createAccount(user, pass, email1, phoneNumber);
                if (userInfo.isLoginFlag()) {
                    System.out.println("Account created");
                    ttw.db.printCustomerLoginTable();
                    ttw.nextPage(new BookingPage(ttw, aInfo, userInfo) {
                    });
                }
            }   
        };
    }

}
