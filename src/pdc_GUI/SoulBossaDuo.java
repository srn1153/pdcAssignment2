/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

/**
 *
 * @author nikis
 */
public class SoulBossaDuo extends ArtistPanel { //Soul Bossa Duo is one of the artists 
    
    public CustomerUpdate userInfo; 
    
    public SoulBossaDuo(TempoTicketsWebsite ttw, CustomerUpdate userInfo){
        //provides information that is needed to display on artist panel 
        super(ttw, new Artist("Soul Bossa Duo","Jazz", "Tuning Fork", "28th July 2024", "9pm-12am", 25.00), userInfo); 
    }
}