package busbookingjdbc;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
	 static Scanner sc=new Scanner(System.in);
	
	 static  String pasangername;
	 static int busno;
	 static Date date;
	
     public static void bookingadd() throws SQLException{
    	
 				
 			
 		
    	 System.out.println("enter the busno");
    	 busno=sc.nextInt() ;
    	 
    	 System.out.println("enter the name");
    	 pasangername=sc.next();
    	 
    	 System.out.println("enter the date dd-mm-yyyy");
    	 String dateinput=sc.next();
    	 
    	 SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
    	 
    	 try {
			date=dateformat.parse(dateinput);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
    	 Booking booking=new Booking();
			
			if(booking.isAvailable()) {
				BookingDAO bookingdao=new BookingDAO();
				bookingdao.addBooking(booking);
				
			}
			
    	
    
    	 
    }
     public static boolean isAvailable() throws SQLException {
    	 BusDAO busdao=new BusDAO();
    	 BookingDAO booking=new BookingDAO();
    	 int capacity=busdao.getCapacity(busno);
    	 int booked=booking.getbookingcount(busno,date);
       
    	 return  booked<capacity;



    		
    	
    	 
     }
	
	

}
