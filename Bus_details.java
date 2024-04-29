package busbookingjdbc;
import java.util.Date;

	public class Bus_details {
		
		
		private int busno;
		private String b_type;
		private int capicity;
		//private String DriverName;
		Bus_details(int busno,String b_type,int capicity){
		
			this.busno=busno;
			this.b_type=b_type;
			this.capicity=capicity;
			//this.DriverName=DriverName;
			
		}

		public int getseat() {
			return capicity;
		}
		public void setseat() {
			capicity=capicity;
		}
		public int getbusno() {
			return busno;
		}
		public void setbusno() {
			busno=busno;
		}
		public String gettype() {
			return b_type;
		}
		public void settype() {
			b_type=b_type;
		}
//		public String getDriverName() {
//			return DriverName ;
//		}
//		public void setDriverName() {
//			DriverName=DriverName;
//		}
		
		
		
		
	}




