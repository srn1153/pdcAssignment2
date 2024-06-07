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
                statement.executeUpdate("CREATE TABLE " + customerLoginTable + 
                        " (userid INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                                + "username VARCHAR(30) NOT NULL, "
                                + "password VARCHAR(30) NOT NULL , "
                                + "email VARCHAR(100) UNIQUE NOT NULL, "
                                + "phone_number VARCHAR(15))");
            }

            if (!checkTableExisting(BookingRecords)) {
                statement.executeUpdate("CREATE TABLE " + BookingRecords + 
                        " (booking_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                                + "userid INT, "
                                + "first_name VARCHAR(50), "
                                + "last_name VARCHAR(50), "
                                + "artist VARCHAR(50), "
                                + "ticket_type VARCHAR(50), "
                                + "number_of_tickets INT, "
                                + "total_cost DECIMAL(10, 2), "
                                + "booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                                + "status VARCHAR(20) DEFAULT 'Booked', "
                                + "refund_amount DECIMAL(10, 2), "
                                + "refund_date TIMESTAMP, "
                                + "FOREIGN KEY (userid) REFERENCES Customer_Login(userid))");
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
                    int userId = rs.getInt("userid"); 
                    info.setUserid(userId);
                    System.out.println("User id set to: " + userId);
                    info.setLoginFlag(true); 
                } else {
                    info.setLoginFlag(false); 
                }
            } else {
                System.out.println("User not found ... ");
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {  
            e.printStackTrace();
        }
        System.out.println("User id is: " + info.getUserid());
        return info;
    }
    
    public CustomerUpdate createAccount(String username, String password, String email, String phoneNumber){
        CustomerUpdate info = new CustomerUpdate(); 
        try {
            Statement statement = conn.createStatement(); 
            System.out.println("Creating account ");
                        
            int rowsInserted = statement.executeUpdate("INSERT INTO Customer_Login (username, password, email, phone_number) VALUES('" 
                    + username + "', '" + password + "', '" + email + "', '" + phoneNumber + "')"); 
            
            if(rowsInserted > 0){
                ResultSet rs = statement.executeQuery("SELECT userid FROM Customer_Login WHERE username = '" + username + "'"); 
                if(rs.next()) {
                    int userId = rs.getInt("userid"); 
                    info.setUserid(userId);
                    System.out.println("New user ID: " + userId);
                } else {
                    System.out.println("No user ID found :( ");
                }
                rs.close(); 
            } else {
                System.out.println("No rows inserted");
            }
            info.setLoginFlag(true); 
            statement.close(); 
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return info; 
    }

    /*public Connection getConnection() {
        return this.conn;
    }*/
    
    public void insertInfo(int userid, String fName, String lName, String artist, String ticketType, int numOfTickets, double totalCost){
        CustomerUpdate info = new CustomerUpdate(); 
        try {
            Statement statement = conn.createStatement(); 
            System.out.println("inserting info ");
                        
            statement.executeUpdate("INSERT INTO Booking_Records (userid, first_name, last_name, artist, ticket_type, number_of_tickets, total_cost) VALUES(" 
                    + userid + ", '" + fName + "', '" + lName + "', '" + artist + "', '" + ticketType + "', " + numOfTickets + ", " + totalCost + ")"); 
            info.setLoginFlag(true); 
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        //return info; 
    }
    
    /*public static void main(String[] args) {
        Database db = new Database(); 
        System.out.println("CustomerLogin table:");
        db.printCustomerLoginTable();     
        System.out.println("\nBooking records:");
        db.printBookingRecordsTable();
        
    }*/
    
    public void printCustomerLoginTable() {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer_Login");

            while (rs.next()) {
                int userid = rs.getInt("userid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email"); 
                String phoneNumber = rs.getString("phone_number"); 
                System.out.println("userid: " + userid + ", username: " + username + ", password: " + password + ", email: " + email + ", phone number: " + phoneNumber);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void printBookingRecordsTable() {
    try {
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Booking_Records");

        while (rs.next()) {
            int bookingId = rs.getInt("booking_id");
            int userId = rs.getInt("userid");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String artist = rs.getString("artist");
            String ticketType = rs.getString("ticket_type");
            int numberOfTickets = rs.getInt("number_of_tickets");
            double totalCost = rs.getDouble("total_cost");
            String bookingDate = rs.getString("booking_date");
            String status = rs.getString("status");
            double refundAmount = rs.getDouble("refund_amount");
            String refundDate = rs.getString("refund_date");

            System.out.println("Booking ID: " + bookingId + ", User ID: " + userId + ", First Name: " + firstName +
                    ", Last Name: " + lastName + ", Artist: " + artist + ", Ticket Type: " + ticketType +
                    ", Number of Tickets: " + numberOfTickets + ", Total Cost: " + totalCost +
                    ", Booking Date: " + bookingDate + ", Status: " + status + ", Refund Amount: " + refundAmount +
                    ", Refund Date: " + refundDate);
        }

        rs.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    /*public static void main(String[] args) {
    Database dbManager = new Database();
    dbManager.printCustomerLoginTable();
    dbManager.printBookingRecordsTable();
    dbManager.closeConnections(); // Close connections after use
}*/
    
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
