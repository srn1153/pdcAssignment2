/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

/**
 *
 * @author nikis
 */
public class Dylan extends ArtistPanel{ //Dylan is one of the artists 
    
    public CustomerUpdate userInfo; 
    
    public Dylan(TempoTicketsWebsite ttw, CustomerUpdate userInfo){
        //provides information that is needed to display on artist panel 
        super(ttw, new Artist("Dylan", "Indie Rock", "Tuning Fork", "15th June 2024", "7pm-10pm", 45.50), userInfo);  
    }
}
