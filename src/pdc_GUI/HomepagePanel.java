/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */

public class HomepagePanel extends JPanel implements PanelInterface{
    private TempoTicketsWebsite ttw; 
    public CustomerUpdate userInfo; 
    public Artist aInfo; 

    
    public HomepagePanel(TempoTicketsWebsite ttw, CustomerUpdate userInfo, Artist aInfo){
        this.ttw = ttw; 
        this.userInfo = userInfo;
        this.aInfo = aInfo; 
        panelDisplay(); 
    }
    
    public JPanel getContent(){
        return this; 
    }
    
    public void panelDisplay() {
        setLayout(new BorderLayout()); 
        
        //homepage Panel 
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        panel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.setBackground(new Color(235, 239, 242)); //light blue background
        
        //adding welcome title to panel 
        JLabel welcome = new JLabel("Welcome to"); 
        welcome.setFont(new Font("Garamond", Font.BOLD, 30)); 
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT); 
        welcome.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        panel.add(welcome); 
        JLabel tempoTickets = new JLabel("Tempo Tickets"); 
        tempoTickets.setFont(new Font("Garamond", Font.BOLD, 30)); 
        tempoTickets.setAlignmentX(Component.CENTER_ALIGNMENT); 
        tempoTickets.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        panel.add(tempoTickets); 
        
        //adding text 
        JLabel upcoming = new JLabel("Here are the upcoming events:"); 
        upcoming.setFont(new Font("Garamond", Font.PLAIN, 20)); 
        upcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel clickArtist = new JLabel("Click on an artist to see more details!"); 
        clickArtist.setFont(new Font("Garamond", Font.PLAIN, 20)); 
        clickArtist.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10)); 
        upcoming.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        clickArtist.setForeground(new Color(118, 149, 182)); //darker shade of blue button 
        panel.add(upcoming); 
        panel.add(clickArtist); 
        
        //manage account button in top corner
        JButton manageAccount = new JButton("Manage account here");
        manageAccount.setBounds(422, 5, 160, 25);
        manageAccount.setFont(new Font("Garamond", Font.BOLD, 13)); 
        manageAccount.setBackground(new Color(163, 194, 227)); //light blue 
        manageAccount.setForeground(Color.WHITE); //white text
        add(manageAccount);
        
        add(panel, BorderLayout.NORTH); 
        
        //artist options
        JPanel options = new JPanel(new GridLayout(2, 2)); 
        
        //Artist buttons
        JButton artist1 = new JButton("The Terrys");
        JButton artist2 = new JButton("Soul Bossa Duo"); 
        JButton artist3 = new JButton("Dylan"); 
        JButton artist4 = new JButton("Pink Peppers"); 
        
        artist1.setBackground(new Color(163, 194, 227)); //light blue 
        artist1.setFont(new Font("Garamond", Font.BOLD, 20)); 
        artist1.setForeground(Color.WHITE); //white text
        
        artist2.setBackground(new Color(163, 194, 227)); //light blue
        artist2.setFont(new Font("Garamond", Font.BOLD, 20)); 
        artist2.setForeground(Color.WHITE); //white text
        
        artist3.setBackground(new Color(163, 194, 227)); //light blue 
        artist3.setFont(new Font("Garamond", Font.BOLD, 20)); 
        artist3.setForeground(Color.WHITE); //white text
        
        artist4.setBackground(new Color(163, 194, 227)); //light blue 
        artist4.setFont(new Font("Garamond", Font.BOLD, 20)); 
        artist4.setForeground(Color.WHITE); //white text
        
        artist1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //displays artist panel with The Terrys info
                ttw.nextPage(new TheTerrys(ttw, userInfo).getContent());
            }
        });
        
        artist2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //displays artist panel with Soul Bossa Duo info
                ttw.nextPage(new SoulBossaDuo(ttw, userInfo).getContent());
            }
        });
        
        artist3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //displays artist panel with Dylan info
                ttw.nextPage(new Dylan(ttw, userInfo).getContent());
            }
        });
        
        artist4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //displays artist panel with PinkPeppers info
                ttw.nextPage(new PinkPeppers(ttw, userInfo).getContent());
            }
        });
        
        manageAccount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //goes to login page for further account details 
                ttw.nextPage(new LoginForAccountDetails(ttw, aInfo, userInfo) {}); 
            }
        }); 

        //adds artist buttons to gridlayout 
        options.add(artist1); 
        options.add(artist2); 
        options.add(artist3); 
        options.add(artist4); 
        //adds to panel 
        add(options, BorderLayout.CENTER); 
    }    

    @Override
    public boolean checkDetailRequirements() {
        return true; 
    }
}
