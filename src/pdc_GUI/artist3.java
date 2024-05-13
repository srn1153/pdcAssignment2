/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class artist3 extends JPanel implements BookingPage {
    private TempoTicketsWebsite ttw; 
    private HomepagePanel hpp; 

    @Override
    public JPanel getContent() {
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        JButton back = new JButton("<--"); 
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(hpp); 
            }
        }); 
        
        panel.add(back); 
        
        JLabel backLabel = new JLabel("go back to HomePage"); 
        backLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(backLabel); 
        
        add(panel, BorderLayout.NORTH);
        
        return panel; 
        
    }
    
}
