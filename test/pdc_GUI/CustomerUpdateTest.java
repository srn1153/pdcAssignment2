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
public class CustomerUpdateTest {
    //this is important to test as this class is referenced the most when retrieving details about the users
    
    private CustomerUpdate userInfo; 
    
    public CustomerUpdateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        userInfo = new CustomerUpdate(); 
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getUserId method, of class CustomerUpdate.
     */
    @Test
    public void testSetandGetUserId() { //set and get is very important with userId as it determines which customer we are dealing with
        System.out.println("Test for set and get UserId");
        CustomerUpdate instance = userInfo;
        instance.setUserId(400); 
        int result = instance.getUserId();
        assertEquals(400, result); 
    }
    /**
     * Test of getBooking_id method, of class CustomerUpdate.
     */
    @Test
    public void testSetandGetBooking_id() { //set and get is important for bookingId as it determines which specific purchase we are dealing with 
        System.out.println("Test for set and get Booking_id");
        CustomerUpdate instance = userInfo;
        instance.setBooking_id(2); 
        int result = instance.getBooking_id(); 
        assertEquals(2, result); 
    }
    
    /**
     * Test of getRefund_amount method, of class CustomerUpdate.
     */
    @Test
    public void testSetandGetRefund_amount() { //set and get refund amount is important to test. Because if incorrect information is displayed users could become confused
        System.out.println("Test for set and get refund amount");
        CustomerUpdate instance = userInfo;
        instance.setRefund_amount(40.0); 
        double result = instance.getRefund_amount(); 
        assertEquals(40.0, result, 0.001); 
        
    }

}
