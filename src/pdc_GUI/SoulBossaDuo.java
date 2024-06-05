/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

/**
 *
 * @author nikis
 */
public class SoulBossaDuo extends ArtistPanel {
    
    public CustomerUpdate userInfo; 
    
    public SoulBossaDuo(TempoTicketsWebsite ttw, CustomerUpdate userInfo){
        super(ttw, new Artist("Soul Bossa Duo","Jazz", "Tuning Fork", "28th July 2024", "9pm-12am", 25.00), userInfo); 
    }
}
