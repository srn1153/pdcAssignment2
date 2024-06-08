/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author nikis
 */
public class TempoTicketsWebsite extends JFrame {

    private JPanel currPanel;
    Database db;
    CustomerUpdate userInfo;
    Artist aInfo;

    public TempoTicketsWebsite(CustomerUpdate userInfo, Artist aInfo) {
        //sets title to name of website
        setTitle("Tempo Tickets Website!");
        //sets size of frame
        setSize(600, 600);
        //ensure user can exit program at any time
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //starts the connection for the database
        db = new Database();
        //initialises userInfo
        this.userInfo = userInfo;
        this.aInfo = aInfo;

        //goes to Homepage panel first 
        HomepagePanel hpp = new HomepagePanel(this, this.userInfo, this.aInfo);
        this.nextPage(hpp);
        add(hpp);

        setVisible(true);
    }

    //goes to new page without creating a new window
    public void nextPage(JPanel newPanel) {
        getContentPane().removeAll();
        currPanel = newPanel;
        add(newPanel);
        revalidate();
        repaint();
    }

    //the main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TempoTicketsWebsite(new CustomerUpdate(), new Artist("Artist Name", "Genre", "Location", "Date", "Time", 50.0));
            }
        }
        );
    }
}
