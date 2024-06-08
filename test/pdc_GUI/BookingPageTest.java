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
public class BookingPageTest {
    //this is important to test as invalid input can cause lots of errors in the database section
    
    private BookingPage bookingPage; 
    private Artist aInfo;
    private CustomerUpdate userInfo;
    private TempoTicketsWebsite ttw;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        aInfo = new Artist("Soul Bossa Duo","Jazz", "Tuning Fork", "28th July 2024", "9pm-12am", 25.00); 
        userInfo = new CustomerUpdate(); 
        ttw = new TempoTicketsWebsite(userInfo, aInfo); 
        bookingPage = new BookingPage(ttw, aInfo, userInfo); 
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void testEmptyInput(){//tests for empty or partially empty test fields 
        System.out.println("Testing if input is empty");
        BookingPage instance = bookingPage; 
        instance.fNameText.setText(""); 
        instance.lNameText.setText(""); 
        assertFalse(bookingPage.checkDetailRequirements()); 
        
        instance.fNameText.setText("Jessica"); 
        instance.lNameText.setText(""); 
        assertFalse(bookingPage.checkDetailRequirements()); 
        
        instance.fNameText.setText(""); 
        instance.lNameText.setText("Eden"); 
        assertFalse(bookingPage.checkDetailRequirements()); 
    }
    
    @Test 
    public void testDigitsInNameArea(){ // testings for digits in incorrect area
        System.out.println("Testing input as digits");
        BookingPage instance = bookingPage; 
        instance.fNameText.setText("Luk3"); 
        instance.lNameText.setText("Smith"); 
        assertFalse(bookingPage.checkDetailRequirements()); 
        
        instance.fNameText.setText("Luke"); 
        instance.lNameText.setText("S4ith"); 
        assertFalse(bookingPage.checkDetailRequirements()); 
        
        instance.fNameText.setText("287492"); 
        instance.lNameText.setText("238437"); 
        assertFalse(bookingPage.checkDetailRequirements());       
    }
    
    @Test 
    public void testGetArtistName(){ // tests the get method for artistname 
        System.out.println("Testing get for artist name");
        BookingPage instance = bookingPage; 
        String expectedResult = instance.aInfo.getArtistName(); 
        String result = "Soul Bossa Duo"; 
        assertEquals(expectedResult, result); 
    }
    
    @Test 
    public void testComboBoxSelection(){//tests the selection on the combo boxes are efficient
        System.out.println("Testing combo box selection");
        BookingPage instance = bookingPage; 
        
        String ticketSelected = "Wheelchair Access Ticket"; 
        instance.ticketType.setSelectedItem(ticketSelected); 
        
        String result = instance.ticketType.getSelectedItem().toString();
        assertEquals(ticketSelected, result); 
    }   
}
