
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class mainihealth {

    public static void main(String[] args) {
        Logininpage lp = new Logininpage();
        lp.setVisible(true);

        Notification();
    }

    public static void Notification() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        String date = s.format(d);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihealth?useTimezone=true&serverTimezone=UTC", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM appointmentbookings");

            while (rs.next()) {
                String daterecord = rs.getString("Appointment Date");
                if (date.equals(daterecord)) {
                    String reminder = "Hi, " + rs.getString("Patient Name") + ". Don't forget that :" + "\nYou have an appointment at " 
                            + rs.getString("Appointment Start Time") + " - " + rs.getString("Appointment End Time");
                    JOptionPane.showMessageDialog(null, reminder, "R E M I N D E R ! ! !", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops Sorry!");
        }
    }
}
