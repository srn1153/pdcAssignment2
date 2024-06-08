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
    public void testDbSetup() {
        System.out.println("Test dbSetup");
        Database instance = db; 
        assertTrue(instance.checkTableExisting("Customer_Login")); 
        assertTrue(instance.checkTableExisting("Booking_Records")); 
    }

    /**
     * Test of checkName method, of class Database.
     */
    @Test
    public void testCheckName() {
        System.out.println("Test checkName");
        String username = "Nikisha123";
        String password = "ilovepdc";
        Database instance = db;
        CustomerUpdate result = instance.checkName(username, password);
        assertNotNull(result); 
        assertTrue(result.isLoginFlag()); 
    }   
    
    /**
     * Test of establishConnection method, of class Database.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("Test establishConnection");
        Database instance = db; 
        try {
            instance.establishConnection();
            assertTrue(true); 
        } catch (SQLException e){
            fail("Connection failed " + e.getMessage()); 
        }
    }    
}
