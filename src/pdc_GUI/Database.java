/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author nikis
 */
public final class Database {
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "123";
    private static final String URL = "jdbc:derby:CustomerLogin_Ebd; create=true";

    private Connection conn;

    public Database() {
        establishConnection();
        dbSetup(); 
    }
    
    //initial db setup (creating tables to insert data in later on)
    public void dbSetup() {
        try { 
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
            Statement statement = conn.createStatement(); 
            String customerLoginTable = "Customer_Login"; 
            String BookingRecords = "Booking_Records"; 
                        
            if (!checkTableExisting(customerLoginTable)) {
                statement.executeUpdate("CREATE TABLE " + customerLoginTable + " (userid VARCHAR(12) PRIMARY KEY, username VARCHAR(30), password VARCHAR(30))");
            }

            if (!checkTableExisting(BookingRecords)) {
                statement.executeUpdate("CREATE TABLE " + BookingRecords + " (booking_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, userid VARCHAR(12), first_name VARCHAR(50), last_name VARCHAR(50), artist VARCHAR(100), ticket_type VARCHAR(50), number_of_tickets INT, total_cost DECIMAL(10, 2), booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, status VARCHAR(20) DEFAULT 'Booked', refund_amount DECIMAL(10, 2), refund_date TIMESTAMP)");
            }

            statement.close(); 
            
        }catch (Throwable e){
            System.out.println("Error when trying to setup DB");
            e.printStackTrace(); 
        }
    } 

    
    //checking if table already exists 
    private boolean checkTableExisting(String tableName) {
        try {

            System.out.println("check existing tables.... ");
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, new String[] {"TABLE"});

            while (rsDBMeta.next()) {
                String existingTableName = rsDBMeta.getString("TABLE_NAME");
                if (existingTableName.compareToIgnoreCase(tableName) == 0) {
                    System.out.println(tableName + "  is there");
                    return true;
                }
            }
            System.out.println(tableName + " not found");
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    //checking to see if account exists
    public CustomerUpdate checkName(String username, String password) {
        CustomerUpdate info = new CustomerUpdate();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password FROM Customer_Login WHERE username = '" + username + "'"); 
            if (rs.next()) {
                String pass = rs.getString("password"); 
                System.out.println("***" + pass);
                System.out.println("found user");
                if (password.compareTo(pass) == 0) {
                    info.userid = rs.getString("userid"); 
                    info.loginFlag = true; 
                } else {
                    info.loginFlag = false; 
                }
            } 
            statement.close(); // Close the statement after use
            rs.close();// Close the result set after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info; // Return the Data object
    }
    
    public CustomerUpdate createAccount(String username, String password){
        CustomerUpdate info = new CustomerUpdate(); 
        try {
            Statement statement = conn.createStatement(); 
            System.out.println("Creating account ");
            
            String userid = randomCode(); 
            
            statement.executeUpdate("INSERT INTO Customer_Login (userid, username, password) " + "VALUES('" + userid + "', '" + username + "', '" + password + "')"); 
            info.loginFlag = true; 
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return info; 
    }
    
    private String randomCode() {
        Random rand = new Random(); 
        int randNum = rand.nextInt(900000) + 100000;
        return String.valueOf(randNum); 
    }

    /*public static void main(String[] args) {
        Database dbManager = new Database();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }*/
    
    public void insertInfo(String fName, String lName, String email, String phoneNum){
        //Statement statement = conn.createStatement(); 
        
    }
    
    public void printCustomerLoginTable() {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer_Login");

            while (rs.next()) {
                String userid = rs.getString("userid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("userid: " + userid + ", username: " + username + ", password: " + password);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Establishing connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println("Database connection failed " + ex.getMessage());
            }
        }
    }

    //closing connection 
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
