/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pdc_GUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nikis
 */
public class ArtistTest { 
//this class is important to test as it's referenced multiple times in different classes to access information about the user 
    
    private Artist artistTest; 
    
    public ArtistTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        artistTest = new Artist("Soul Bossa Duo","Jazz", "Tuning Fork", "28th July 2024", "9pm-12am", 25.00); 
    }
    
    @After
    public void tearDown() {
        artistTest = null; 
    }
    
    @Test 
    public void testConstructor(){ //testing constructor
        Artist instance = artistTest; 
        assertEquals("Soul Bossa Duo", instance.getArtistName()); 
        assertEquals("Jazz", instance.getGenre()); 
        assertEquals("Tuning Fork", instance.getLoc()); 
        assertEquals("28th July 2024", instance.getDate()); 
        assertEquals("9pm-12am", instance.getTime()); 
        assertEquals(25.00, instance.getPrice(), 0.001); 
    }
    
    @Test 
    public void testGetAndSetArtistName() {//testing both get and set methods for artist name
        System.out.println("Testing get and set for artist name");
        Artist instance = artistTest; 
        instance.setArtistName("PinkPeppers"); 
        assertEquals("PinkPeppers", instance.getArtistName()); 
    }
    
    @Test 
    public void testGetAndSetGenre() {//testing both get and set methods for genre
        System.out.println("Testing get and set for genre");
        Artist instance = artistTest; 
        instance.setGenre("Metal"); 
        assertEquals("Metal", instance.getGenre()); 
    }
    
    @Test 
    public void testGetAndSetLoc() {//testing both get and set methods for location
        System.out.println("Testing get and set for location");
        Artist instance = artistTest; 
        instance.setLoc("At Home"); 
        assertEquals("At Home", instance.getLoc()); 
    }
    
    
    @Test 
    public void testGetAndSetDate() {//testing both get and set methods for date
        System.out.println("Testing get and set for date");
        Artist instance = artistTest; 
        instance.setDate("tomorrow"); 
        assertEquals("tomorrow", instance.getDate()); 
    }
    
    @Test 
    public void testGetAndSetTime() {//testing both get and set methods for time
        System.out.println("Testing get and set for time");
        Artist instance = artistTest; 
        instance.setTime("7pm-7am"); 
        assertEquals("7pm-7am", instance.getTime()); 
    }
    
    @Test 
    public void testGetAndSetPrice() {//testing both get and set methods for price
        System.out.println("Testing get and set for price");
        Artist instance = artistTest; 
        instance.setPrice(44.55); 
        assertEquals(44.55, instance.getPrice(), 0.001); 
    }
}