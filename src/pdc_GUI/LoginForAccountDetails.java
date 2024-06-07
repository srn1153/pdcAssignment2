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
        super.panelDisplay();

        viewMyTickets = new JButton("View my Tickets");
        viewMyTickets.setBounds(190, 250, 200, 25);

        refundTickets = new JButton("Refund/Cancel Booking");
        refundTickets.setBounds(190, 320, 200, 25);

        viewMyTickets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new ViewMyTickets(ttw, aInfo, userInfo));
            }
        });

        refundTickets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ttw.nextPage(new ViewMyTickets(ttw, aInfo, userInfo));
            }
        });
    }

    @Override
    protected ActionListener signInButton(JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton) {
        return (ActionEvent e) -> {
            String user = userText.getText();
            String pass = passText.getText();

            userInfo = ttw.db.checkName(user, pass);

            if (userInfo.isLoginFlag()) {//if username and password match
                noSuchUser.setText("Login successful!");
                loginPanel.add(viewMyTickets);
                loginPanel.add(refundTickets);
                loginPanel.revalidate();
                loginPanel.repaint();
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
                    loginPanel.add(viewMyTickets);
                    loginPanel.add(refundTickets);
                    loginPanel.revalidate();
                    loginPanel.repaint();
                }
            }
        };
    }

    @Override
    public boolean checkDetailRequirements() {
        return true;
    }
}
