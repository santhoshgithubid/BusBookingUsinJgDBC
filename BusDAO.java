package busbookingjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {

	public static void displaybusinfo() throws SQLException {
		String query="select * from bus";
		Connection con=Dbconnection.getconnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
	     
		while(rs.next()) {
			System.out.println("id is         :"+rs.getInt(1));
			System.out.println("type is       :"+rs.getString(2));
			System.out.println("capacity is   :"+rs.getInt(3));
			System.out.println("********************************");
		}
	
		
	}
	public static int  getCapacity(int id) throws SQLException {
		String query="select capacity from bus where id="+id;
		Connection con=Dbconnection.getconnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	

	
	
}
