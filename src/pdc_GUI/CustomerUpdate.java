/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nikis
 */
public class CustomerUpdate { 

//this class gets and sets important customer details
    
    //variables for customer login table 
    private int userId; 
    private boolean loginFlag = false;
    
    //variables for booking records table
    private int booking_id; 
    public String fName; 
    public String lName;
    private String artist;
    private String location; 
    private String date; 
    private String time; 
    private String ticket_type; 
    private int number_of_tickets; 
    private double total_cost; 
    public Date booking_date; 
    public String status; 
    public double refund_amount;    
    public Date refund_date; 
    
    private List<Integer> bookingIds = new ArrayList<>(); 
    private List<String> artists = new ArrayList<>(); 
    private List<String> locations = new ArrayList<>(); 
    private List<String> dates = new ArrayList<>(); 
    private List<String> times = new ArrayList<>(); 
    private List<String> ticketTypes = new ArrayList<>(); 
    private List<Integer> numberOfTickets = new ArrayList<>(); 
    private List<Double> totalCosts = new ArrayList<>(); 

    
    public void addBookingDetails(int bookingId, String artist,String location, String date, String time, String ticketType, int numberOfTickets, double totalCost){
        this.getBookingIds().add(bookingId); 
        this.getArtists().add(artist); 
        this.getLocations().add(location); 
        this.getDates().add(date); 
        this.getTimes().add(time); 
        this.getTicketTypes().add(ticketType); 
        this.getNumberOfTickets().add(numberOfTickets); 
        this.getTotalCosts().add(totalCost); 
    }
    
    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the loginFlag
     */
    public boolean isLoginFlag() {
        return loginFlag;
    }

    /**
     * @param loginFlag the loginFlag to set
     */
    public void setLoginFlag(boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

    /**
     * @return the booking_id
     */
    public int getBooking_id() {
        return booking_id;
    }

    /**
     * @param booking_id the booking_id to set
     */
    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the ticket_type
     */
    public String getTicket_type() {
        return ticket_type;
    }

    /**
     * @param ticket_type the ticket_type to set
     */
    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    /**
     * @return the number_of_tickets
     */
    public int getNumber_of_tickets() {
        return number_of_tickets;
    }

    /**
     * @param number_of_tickets the number_of_tickets to set
     */
    public void setNumber_of_tickets(int number_of_tickets) {
        this.number_of_tickets = number_of_tickets;
    }

    /**
     * @return the total_cost
     */
    public double getTotal_cost() {
        return total_cost;
    }

    /**
     * @param total_cost the total_cost to set
     */
    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }
    
    /**
     * @return the bookingIds
     */
    public List<Integer> getBookingIds() {
        return bookingIds;
    }

    /**
     * @return the artists
     */
    public List<String> getArtists() {
        return artists;
    }
    
    
    /**
     * @return the locations
     */
    public List<String> getLocations() {
        return locations;
    }

    /**
     * @return the dates
     */
    public List<String> getDates() {
        return dates;
    }
    /**
     * @return the times
     */
    public List<String> getTimes() {
        return times;
    }
    
    /**
     * @return the ticketTypes
     */
    public List<String> getTicketTypes() {
        return ticketTypes;
    }

    /**
     * @return the numberOfTickets
     */
    public List<Integer> getNumberOfTickets() {
        return numberOfTickets;
    }

    /**
     * @return the totalCosts
     */
    public List<Double> getTotalCosts() {
        return totalCosts;
    }
}
