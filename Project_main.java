package busbookingjdbc;

import java.sql.SQLException;
import java.util.*;

public class Project_main {
	static Scanner sc=new Scanner(System.in);
	public static void main(String []args) throws SQLException  {
		
		System.out.println("1- book ticket\t 2- view your ticket\t3-cancel ticket\t 4-exit");	
		int select=sc.nextInt();
		switch(select) {
		case 1:
			BusDAO.displaybusinfo();
			Booking.bookingadd(); 
			break;
		case 2:
			BookingDAO.view();
			
			break;
		case 3:
			BookingDAO.cancel();
			break;
		case 4:
			System.out.println("Thankyou");
		    break;
		
		}
		
		
		
		sc.close();
		
		
	}

}







