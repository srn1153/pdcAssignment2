/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nikis
 */
public class TempoTicketsWebsite extends JFrame {
    private JPanel currPanel; 
    
    public TempoTicketsWebsite() {
        setTitle("Tempo Tickets Website!"); 
        setSize(800, 800); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        
        //creating homepage window 
        HomepagePanel hpp = new HomepagePanel(this); 
        currPanel = hpp; 
        add(hpp); 
        
        setVisible(true); 
    }
}
