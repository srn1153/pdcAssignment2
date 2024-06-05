/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.util.Date;

/**
 *
 * @author nikis
 */
public class CustomerUpdate {
    
    //variables for customer login table 
    public int userid; 
    boolean loginFlag = false;
    
    //variables for booking records table
    public int booking_id; 
    public String fName; 
    public String lName;
    public String artist;
    public String ticket_type; 
    public int number_of_tickets; 
    public double total_cost; 
    public Date booking_date; 
    public String status; 
    public double refund_amount;    
    public Date refund_date; 
}
