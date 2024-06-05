/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author nikis
 */
public class TempoTicketsWebsite extends JFrame {
    private JPanel currPanel; 
    Database db; 
    CustomerUpdate userInfo; 
    
    public TempoTicketsWebsite(CustomerUpdate userInfo) {
        setTitle("Tempo Tickets Website!"); 
        setSize(600, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        
        db = new Database();
        this.userInfo = userInfo; 
 
        HomepagePanel hpp = new HomepagePanel(this, this.userInfo);
        this.nextPage(hpp);
        add(hpp); 

        setVisible(true); 
    }
    
    //go to new page
    public void nextPage(JPanel newPanel){
        getContentPane().removeAll(); 
        currPanel = newPanel; 
        add(newPanel); 
        revalidate(); 
        repaint(); 
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TempoTicketsWebsite(new CustomerUpdate()); 
            }
            
        }); 
    }
}
