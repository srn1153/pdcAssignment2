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
public class LoginForAccountDetails extends LoginPage {

    private TempoTicketsWebsite ttw;
    public Artist aInfo;
    public CustomerUpdate userInfo;

    public LoginForAccountDetails(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo) {
        super(ttw, aInfo, userInfo);
    }

    @Override
    protected ActionListener signInButton(JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton) {
        return (ActionEvent e) -> {
            System.out.println("hi");
        };
    }

    @Override
    protected ActionListener registerButton(JButton signButton, JLabel noSuchUser, JPanel loginPanel, JLabel registerText, JLabel or, JLabel email, JLabel phoneNo, JButton registerButton) {
        return (ActionEvent e) -> {
            System.out.println("hi");
        };
    }

}
