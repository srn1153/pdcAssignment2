/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author nikis
 */
class buttons {
    
    public static JButton homePageButton(TempoTicketsWebsite ttw) {
        JButton homeButton = new JButton("<--- back to HomePage"); 
        homeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ttw.nextPage(new HomepagePanel(ttw));
            }
        }
        );
        return homeButton; 
    }
    
    public static JButton bookingStage(String bb){
        JButton bookingButton = new JButton(bb); 
        //adding in actionlistener later once new classes have been made
        return bookingButton; 
    }
    
    
}
