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
public class PaymentPanel extends JPanel implements PanelInterface {

    protected final TempoTicketsWebsite ttw;
    public Artist aInfo;
    public CustomerUpdate userInfo;
    public BookingPage bp;
    private JTextField cardNoText;
    private JTextField nameOnCardText;
    private JTextField expiryText;
    private JTextField cvcText;
    private JLabel inputMessage;

    public PaymentPanel(TempoTicketsWebsite ttw, Artist aInfo, CustomerUpdate userInfo, BookingPage bp) {
        this.ttw = ttw;
        this.aInfo = aInfo;
        this.userInfo = userInfo;
        this.bp = bp; 
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
        JButton homeButton = Buttons.homePageButton(ttw, aInfo);
        homeButtonPanel.add(homeButton, BorderLayout.WEST);
        titlePanel.add(homeButtonPanel);

        //displaying title after confirming booking details 
        JLabel paymentProcessText = new JLabel("Payment Proccess:");
        paymentProcessText.setFont(new Font("Garamond", Font.BOLD, 28));
        paymentProcessText.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(paymentProcessText);

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
        cardNoText = new JTextField(30);
        cardNoText.setBounds(300, 40, 250, 25);
        paymentPanel.add(cardNoText);

        //Asking for name on card 
        JLabel nameOnCard = new JLabel("Name on card:");
        nameOnCard.setBounds(50, 80, 200, 25);
        paymentPanel.add(nameOnCard);
        //Enter name on card 
        nameOnCardText = new JTextField(30);
        nameOnCardText.setBounds(300, 80, 250, 25);
        paymentPanel.add(nameOnCardText);

        //expiry date
        JLabel expiry = new JLabel("Expiry:");
        expiry.setBounds(50, 120, 200, 25);
        paymentPanel.add(expiry);
        //Enter expiry
        expiryText = new JTextField(30);
        expiryText.setBounds(300, 120, 250, 25);
        paymentPanel.add(expiryText);

        //CVC
        JLabel cvc = new JLabel("CVC:");
        cvc.setBounds(50, 160, 200, 25);
        paymentPanel.add(cvc);
        //Enter CVC
        cvcText = new JTextField(30);
        cvcText.setBounds(300, 160, 250, 25);
        paymentPanel.add(cvcText);

        inputMessage = new JLabel("");
        inputMessage.setBounds(50, 190, 500, 25);
        paymentPanel.add(inputMessage);

        JButton submitPayment = new JButton("Submit Payment!");
        submitPayment.setBounds(50, 220, 200, 25);
        paymentPanel.add(submitPayment);

        //added after button is clicked 
        JLabel successful = new JLabel("");
        successful.setBounds(220, 260, 200, 25);
        paymentPanel.add(successful);

        JButton goBackToHomePage = Buttons.homePageButton(ttw, aInfo);
        goBackToHomePage.setBounds(190, 300, 200, 25);

        JButton exitButton = new JButton("Exit the website");
        exitButton.setBounds(190, 350, 200, 25);

        submitPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkDetailRequirements()) {
                    successful.setText("Payment was successful!");
                    paymentPanel.add(goBackToHomePage);
                    paymentPanel.add(exitButton);
                    revalidate();
                    repaint();

                    //debugging null issue:
                    if (bp == null) {
                        System.out.println("bp is null");
                    } else if (bp.fNameText == null) {
                        System.out.println("bp.fNameText is null");
                    } else if (ttw == null) {
                        System.out.println("ttw is null");
                    } else if (ttw.db == null) {
                        System.out.println("ttw.db is null");
                    }

                    String fName = bp.fNameText.getText();
                    String lName = bp.lNameText.getText();
                    String artist = aInfo.getArtistName();
                    String ticketTypeRecorded = bp.ticketType.getSelectedItem().toString();
                    int intNumberOfTicketsRecorded = Integer.parseInt(bp.numberOfTickets.getSelectedItem().toString());
                    double doubleTotalCost = aInfo.getPrice() * intNumberOfTicketsRecorded;
                    ttw.db.insertInfo(userInfo.getUserid(), fName, lName, artist, ticketTypeRecorded, intNumberOfTicketsRecorded, doubleTotalCost);
                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        add(paymentPanel, BorderLayout.CENTER);
    }

    @Override
    public boolean checkDetailRequirements() {
        String cardNoInput = cardNoText.getText().trim();
        String nameOnCardInput = nameOnCardText.getText().trim();
        String expiryInput = expiryText.getText().trim();
        String cvcInput = cvcText.getText().trim();

        //checks that all JTextFields aren't left empty
        if (cardNoInput.isEmpty() || nameOnCardInput.isEmpty() || expiryInput.isEmpty() || cvcInput.isEmpty()) {
            inputMessage.setText("Please do not leave any details empty");
            return false;
        }

        //ensures that username and password is more than 8 characters
        if (cardNoInput.length() != 16) {
            inputMessage.setText("Ensure your card number is 16 digits");
            return false;
        }

        if (nameOnCardInput.matches("-?[0-9]+")) {
            inputMessage.setText("Please enter letters when entering name on card");
            return false;
        }

        //ensures the phone number is 8 or mroe digits 
        if (!(expiryInput.matches("^\\d{2}/\\d{2}$") && expiryInput.length() == 5)) { //this specific part of code was sourced from chatgpt "\\d(2)/\\d{2}$"
            inputMessage.setText("Expiry must include '/' between month and year and have a total of 4 digits, e.g. 02/27");
            return false;
        }

        //ensures the cvc is 3 digits in length and includes only digits 
        if (!(cvcInput.matches("-?[0-9]+") && cvcInput.length() == 3)) {
            inputMessage.setText("Please enter 3 digits");
            return false;
        }

        inputMessage.setText("");
        return true;
    }

}
