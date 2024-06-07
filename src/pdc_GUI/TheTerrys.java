/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

/**
 *
 * @author nikis
 */
public class TheTerrys extends ArtistPanel { //The Terrys is one of the artists 
    
    public CustomerUpdate userInfo; 

    public TheTerrys(TempoTicketsWebsite ttw, CustomerUpdate userInfo){
        //provides information that is needed to display on artist panel 
        super(ttw, new Artist("The Terrys","Metal", "The Power Station", "27th August 2024", "7pm-12am", 59.99), userInfo); 
    }
}
