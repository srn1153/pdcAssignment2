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
import javax.swing.JTextField;

/**
 *
 * @author nikis
 */
public class RefundPage extends JPanel implements PanelInterface {
    
    private TempoTicketsWebsite ttw;
    public Artist aInfo;
    private CustomerUpdate userInfo;
    public JTextField userBookingId; 

    public RefundPage(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo) {
        this.ttw = ttw;
        this.aInfo = aInfo;
        this.userInfo = userInfo;
        //retrieves user's information
        this.userInfo = ttw.db.retrieveBookings(userInfo.getUserId());
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

        //adding title 
        JLabel title = new JLabel("Lets refund your tickets!");
        title.setFont(new Font("Garamond", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        //describing purpose of this page 
        JLabel purpose = new JLabel("Enter your booking id below to refund your tickets");
        purpose.setFont(new Font("Garamond", Font.PLAIN, 18));
        purpose.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(purpose);

        //adds in homepage button 
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setLayout(new BoxLayout(homeButtonPanel, BoxLayout.Y_AXIS));
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton);

        //adding homebutton to screen
        add(homeButtonPanel, BorderLayout.NORTH);
        
        //creating new panel for user input 
        JPanel refundInput = new JPanel();
        refundInput.setLayout(new BoxLayout(refundInput, BoxLayout.Y_AXIS));
        refundInput.setLayout(null);
        
        //go view ticket details 
        JButton viewMyTickets = new JButton("Can't remember your booking id? Click here!");
        viewMyTickets.setBounds(150, 20, 300, 25);
        refundInput.add(viewMyTickets);

        //asking for booking id
        JLabel bookingIdText = new JLabel("Booking Id:");
        bookingIdText.setBounds(100, 70, 200, 25);
        refundInput.add(bookingIdText);
        //enter first name 
        userBookingId = new JTextField(20);
        userBookingId.setBounds(300, 70, 200, 25);
        refundInput.add(userBookingId);
        
        viewMyTickets.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new ViewMyTickets(ttw, aInfo, userInfo));
            }
        }); 
        
        panel.add(refundInput, BorderLayout.SOUTH); 
        //adding components to panel 
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public boolean checkDetailRequirements() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
}
