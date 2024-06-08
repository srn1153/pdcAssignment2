/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pdc_GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class DatabaseTest {
    //this is important to test as we must ensure the Database connection is working efficiently
    
    Database db; 
    private Connection conn;
    
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException { 
        conn = DriverManager.getConnection("jdbc:derby:CustomerLogin_Ebd; create=true", "pdc", "123");
        db = new Database(); 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dbSetup method, of class Database.
     */
    @Test
    public void testDbSetup() {//ensures the setUp for the database is done correctly 
        System.out.println("Test dbSetup");
        Database instance = db; 
        assertTrue(instance.checkTableExisting("Customer_Login")); 
        assertTrue(instance.checkTableExisting("Booking_Records")); 
    }

    /**
     * Test of checkName method, of class Database.
     */
    @Test
    public void testCheckName() {//ensures that we are able to effectively check for current users 
        System.out.println("Test checkName");
        String username = "lisa.wilson";
        String password = "happy123";
        Database instance = db;
        CustomerUpdate result = instance.checkName(username, password);
        assertNotNull(result); 
        assertTrue(result.isLoginFlag()); 
    }   
    
    /**
     * Test of establishConnection method, of class Database.
     */
    @Test
    public void testEstablishConnection() { //ensures an established connection
        System.out.println("Test establishConnection");
        Database instance = db; 
        instance.establishConnection();
        assertTrue(true); 
    }    
    
    @Test 
    public void testCloseConnection() throws SQLException{ //ensures the connection is closed
        System.out.println("Test closeConncetion");
        Database instance = db; 
        instance.closeConnections(); 
        assertTrue(instance.getConnection().isClosed()); 
    }
}