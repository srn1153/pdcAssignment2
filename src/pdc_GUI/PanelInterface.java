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
interface PanelInterface { //interface used by most panels
    
    //gets content 
    JPanel getContent(); 
        
    //how it displays components
    void panelDisplay(); 
    
    //ensures user enters valid input
    boolean checkDetailRequirements(); 
    
}
