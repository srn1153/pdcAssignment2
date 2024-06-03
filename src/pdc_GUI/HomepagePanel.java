/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
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

public class HomepagePanel extends JPanel {
    private TempoTicketsWebsite ttw; 
    
    public HomepagePanel(TempoTicketsWebsite ttw){
        this.ttw = ttw; 
        HomePage(); 
    }
    
    public void HomePage() {
        setLayout(new BorderLayout()); 
        
        //Homepage Panel 
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        panel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        //Adding the welcome to tempo tickets onto panel 
        JLabel welcome = new JLabel("Welcome to "); 
        welcome.setFont(new Font("Garamond", Font.BOLD, 26)); 
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(welcome); 
                
        JLabel tempoTickets = new JLabel("Tempo Tickets"); 
        tempoTickets.setFont(new Font("Garamond", Font.BOLD, 26)); 
        tempoTickets.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(tempoTickets); 
        
        //adding text 
        JLabel upcoming = new JLabel("Here are the upcoming events:"); 
        upcoming.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        upcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel clickArtist = new JLabel("Click on an artist to see more details!"); 
        clickArtist.setFont(new Font("Garamond", Font.PLAIN, 18)); 
        clickArtist.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(upcoming); 
        panel.add(clickArtist); 
        
        add(panel, BorderLayout.NORTH); 
        
        //Artist options 
        JPanel options = new JPanel(new GridLayout(2, 2)); 
        
        JButton artist1 = new JButton("The Terrys");
        JButton artist2 = new JButton("Soul Bosssa Duo"); 
        JButton artist3 = new JButton("Dylan"); 
        JButton artist4 = new JButton("Pink Peppers"); 
        
        artist1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new artist1(ttw).getContent());
            }
        });
        
        artist2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new artist2(ttw).getContent());
            }
        });
        
        artist3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new artist3(ttw).getContent());
            }
        });
        
        artist4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new artist4(ttw).getContent());
            }
        });
        
        options.add(artist1); 
        options.add(artist2); 
        options.add(artist3); 
        options.add(artist4); 
        
        add(options, BorderLayout.CENTER); 
    }
    
}
