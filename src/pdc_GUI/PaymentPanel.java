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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nikis
 */
public class PaymentPanel extends JPanel implements PanelInterface{
    
    protected final TempoTicketsWebsite ttw; 
    public Artist aInfo; 
    public CustomerUpdate userInfo; 
    
    public PaymentPanel(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo)
    {
        this.ttw = ttw; 
        this.aInfo = aInfo; 
        this.userInfo = userInfo; 
        System.out.println("Userid is: " + userInfo.getUserid());
        panelDisplay(); 
    }

    @Override
    public JPanel getContent() {
        return this; 
    }

    @Override
    public void panelDisplay() {
        setLayout(new BorderLayout()); 
        
        JPanel titlePanel = new JPanel(); 
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS)); 
                
        //adding in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BorderLayout());
        JButton homeButton = Buttons.homePageButton(ttw); 
        homeButtonPanel.add(homeButton, BorderLayout.WEST); 
        titlePanel.add(homeButtonPanel); 
        
        //displaying title after confirming booking details 
        JLabel loggedIn = new JLabel("Payment Proccess:");
        loggedIn.setFont(new Font("Garamond", Font.BOLD, 28)); 
        loggedIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(loggedIn); 
        
        titlePanel.add(Box.createVerticalStrut(20)); 
        
        //adding in text before card details 
        JLabel title = new JLabel("Please fill in the details below:");
        title.setFont(new Font("Garamond", Font.BOLD, 20)); 
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);
        
        titlePanel.add(Box.createVerticalStrut(20)); 
               
        add(titlePanel, BorderLayout.NORTH);
        
        JPanel paymentPanel = new JPanel(); 
        paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
        paymentPanel.setLayout(null);
        
        //Asking for card number
        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setBounds(50, 40, 200, 25); 
        paymentPanel.add(cardNo); 
        //Enter card number
        JTextField cardNoText = new JTextField(30);
        cardNoText.setBounds(300, 40, 250, 25); 
        paymentPanel.add(cardNoText);
        
        //Asking for name on card 
        JLabel nameOnCard = new JLabel("Name on card:");
        nameOnCard.setBounds(50, 80, 200, 25); 
        paymentPanel.add(nameOnCard); 
        //Enter name on card 
        JTextField nameOnCardText = new JTextField(30);
        nameOnCardText.setBounds(300, 80, 250, 25); 
        paymentPanel.add(nameOnCardText);
        
        //expiry date
        JLabel expiry = new JLabel("Expiry:");
        expiry.setBounds(50, 120, 200, 25); 
        paymentPanel.add(expiry); 
        //Enter expiry
        JTextField expiryText = new JTextField(30);
        expiryText.setBounds(300, 120, 250, 25); 
        paymentPanel.add(expiryText);
        
        //CVC
        JLabel cvc = new JLabel("Expiry:");
        cvc.setBounds(50, 160, 200, 25); 
        paymentPanel.add(cvc); 
        //Enter CVC
        JTextField cvcText = new JTextField(30);
        cvcText.setBounds(300, 160, 250, 25); 
        paymentPanel.add(cvcText);

        JButton submitPayment = new JButton("Submit Payment!"); 
        submitPayment.setBounds(50, 200, 200, 25); 
        paymentPanel.add(submitPayment);
        
        //added after button is clicked 
        JLabel successful = new JLabel(""); 
        successful.setBounds(50, 240, 200, 25);
        paymentPanel.add(successful); 
                
        JButton goBackToHomePage = Buttons.homePageButton(ttw); 
        goBackToHomePage.setBounds(190, 290, 200, 25); 
        
        JButton exitButton = new JButton("Exit the website"); 
        exitButton.setBounds(190, 350, 200, 25); 
        
        
        submitPayment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (userInfo != null) {
                int userid = userInfo.getUserid(); 
                    System.out.println("user id is here!" + userid);
                } else { 
                    System.out.println("user id is null girl");
                }
                
                /*String fName = fNameText.getText(); 
                String lName = lNameText.getText();
                String artist = aInfo.getArtistName(); 
                String ticketTypeRecorded = ticketType.getSelectedItem().toString(); 
                int intNumberOfTicketsRecorded = Integer.parseInt(numberOfTickets.getSelectedItem().toString()); 
                double doubleTotalCost = aInfo.getPrice() * intNumberOfTicketsRecorded; 
                ttw.db.insertInfo(userid, fName, lName, artist, ticketTypeRecorded, intNumberOfTicketsRecorded, doubleTotalCost);*/
                
                successful.setText("Payment was successful!");
                paymentPanel.add(goBackToHomePage); 
                paymentPanel.add(exitButton); 
                revalidate(); 
                repaint(); 
            }
        }); 
        
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
            
        }); 

        add(paymentPanel, BorderLayout.CENTER);
    }    
}
