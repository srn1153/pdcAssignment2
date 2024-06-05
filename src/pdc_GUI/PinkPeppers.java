/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

/**
 *
 * @author nikis
 */
public class PinkPeppers extends ArtistPanel {
    public CustomerUpdate userInfo;
    
    public PinkPeppers(TempoTicketsWebsite ttw, CustomerUpdate userInfo){
        super(ttw, new Artist("Pink Peppers", "Kids Musical", "Town Hall", "7th September 2024", "4pm-7pm", 12.0), userInfo); 
    }
}
