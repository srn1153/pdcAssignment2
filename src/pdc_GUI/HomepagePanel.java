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
        
        //Adding the title to panel 
        JLabel title = new JLabel("Tempo Tickets"); 
        title.setFont(new Font("Arial", Font.BOLD, 24)); 
        title.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(title); 
        
        //adding text 
        JLabel upcoming = new JLabel("Here are the upcoming events:"); 
        upcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel clickArtist = new JLabel("Click on an artist to see more details!"); 
        
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(upcoming); 
        panel.add(clickArtist); 
        
        add(panel, BorderLayout.NORTH); 
        
        //Artist options 
        JPanel options = new JPanel(new GridLayout(2, 2)); 
        
        JButton artist1 = new JButton("Artist 1");
        JButton artist2 = new JButton("Artist 2"); 
        JButton artist3 = new JButton("Artist 3"); 
        JButton artist4 = new JButton("Artist 4"); 
        
        artist1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        artist2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        artist3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        artist4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        options.add(artist1); 
        options.add(artist2); 
        options.add(artist3); 
        options.add(artist4); 
    }
    
}
