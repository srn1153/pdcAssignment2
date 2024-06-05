/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import javax.swing.JPanel;

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
        
    }
    
}
