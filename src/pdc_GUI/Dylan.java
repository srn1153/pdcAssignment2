/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

/**
 *
 * @author nikis
 */
public class Dylan extends ArtistPanel{
    
    public CustomerUpdate userInfo; 
    
    public Dylan(TempoTicketsWebsite ttw, CustomerUpdate userInfo){
        super(ttw, new Artist("Dylan", "Indie Rock", "Tuning Fork", "15th June 2024", "7pm-10pm", 45.50), userInfo);  
    }
}
