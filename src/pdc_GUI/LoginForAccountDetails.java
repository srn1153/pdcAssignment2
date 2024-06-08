/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class LoginForAccountDetails extends LoginPage implements PanelInterface {

    private TempoTicketsWebsite ttw;
    public Artist aInfo;
    public CustomerUpdate userInfo;
    public JButton viewMyTickets;
    public JButton refundTickets;

    public LoginForAccountDetails(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo) {
        super(ttw, aInfo, userInfo);
        this.ttw = ttw;
        this.aInfo = aInfo;
        this.userInfo = userInfo;
    }

    @Override
    public JPanel getContent() {
        return this;
    }

    @Override
    public void panelDisplay() {
        //displays loginpage initially 
        super.panelDisplay();

        //creates view my tickets button 
        viewMyTickets = new JButton("View my Tickets");
        viewMyTickets.setBounds(190, 250, 200, 25);

        //creates refund/cancel booking button 
        refundTickets = new JButton("Refund/Cancel Booking");
        refundTickets.setBounds(190, 320, 200, 25);

        viewMyTickets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //takes user to view my tickets panel, where their details are listed
                ttw.nextPage(new ViewMyTickets(ttw, aInfo, userInfo));
            }
        });

        refundTickets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //goes to refund page
                ttw.nextPage(new RefundPage(ttw, aInfo, userInfo));
            }
        });
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
                //adds buttons to panel if login is successful
                loginPanel.add(viewMyTickets);
                loginPanel.add(refundTickets);

                //remove components from screen when login is successful
                loginPanel.remove(or);
                loginPanel.remove(email);
                loginPanel.remove(emailText);
                loginPanel.remove(phoneNo);
                loginPanel.remove(phoneNoText);
                loginPanel.remove(registerButton);
                registerText.setText("");
                loginPanel.revalidate();
                loginPanel.repaint();

            } else { //if username and password do not match, display messages and register button
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
                    //adds buttons for user to choose from
                    loginPanel.add(viewMyTickets);
                    loginPanel.add(refundTickets);
                    
                    //remove components from screen when login is successful
                    loginPanel.remove(or);
                    loginPanel.remove(email);
                    loginPanel.remove(emailText);
                    loginPanel.remove(phoneNo);
                    loginPanel.remove(phoneNoText);
                    loginPanel.remove(registerButton);
                    registerText.setText("");
                    loginPanel.revalidate();
                    loginPanel.repaint();
                    loginPanel.revalidate();
                    loginPanel.repaint();
                }
            }
        };
    }

    @Override
    public boolean checkDetailRequirements() {
        //checks true or false from LoginPage class
        return super.checkDetailRequirements();
    }
}
