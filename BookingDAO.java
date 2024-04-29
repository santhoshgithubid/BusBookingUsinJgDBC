package busbookingjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
public class BookingDAO {
	static Scanner sc=new Scanner(System.in);
	static int a=0;
	public int getbookingcount(int busno,Date date){
		
		try {
		String query="select count (passenger_name)from booking where busno=? and travel_date=?";
		Connection con=Dbconnection.getconnection();
		PreparedStatement st=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		st.setInt(1, busno);
		st.setDate(2,sqldate);
		ResultSet rs=st.executeQuery();
		rs.next();
		a=rs.getInt(1);
		}
		catch(SQLException e){
			
		}
		return a;
		
	
	}
	
	public static void addBooking(Booking booking) throws SQLException {
		
		String query="INSERT INTO booking(passenger_name, busno, travel_date) VALUES (?, ?, ?)";

		Connection con=Dbconnection.getconnection();
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, booking.pasangername);
		st.setInt(2, booking.busno);
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		st.setDate(3,sqldate);
		st.executeUpdate();
		String query2 = "SELECT * FROM booking WHERE passenger_name = ?";
		Connection con2 = Dbconnection.getconnection();
		PreparedStatement st2 = con2.prepareStatement(query2);
		st2.setString(1, booking.pasangername);
		ResultSet rs = st2.executeQuery();
		while(rs.next()) {
			System.out.println("your id is  "+rs.getInt(1));
	       }
		
		
	
     
}
	public static void view() throws SQLException {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter your id:");
	    int id = sc.nextInt();
	    sc.close(); 
	    

	   
	    String query = "select * from booking where id=?";
	    
	    try (Connection con = Dbconnection.getconnection();
	         PreparedStatement st = con.prepareStatement(query)) {
	        
	        st.setInt(1, id);
	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                System.out.println("******COLLECT TICKET*****");
	                System.out.println(" id   :" + rs.getInt(1));
	                System.out.println("NAME  :" + rs.getString(2));
	                System.out.println("busno : " + rs.getInt(3));
	                System.out.println("date  : " + rs.getDate(4));
	                System.out.println("**************************");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void cancel()throws SQLException {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter your id:");
	    int id = sc.nextInt();
	    sc.close();

	    String query = "DELETE FROM booking WHERE id=?";
	    Connection con = Dbconnection.getconnection();
	    
	    try (PreparedStatement st = con.prepareStatement(query)) {
	        st.setInt(1, id);
	        st.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.close();
	    }
	    System.out.println("your ticket is cancelled");
	}








}