package jdbcMarch17;
import java.sql.*;
public class Demo2 {

	public static void main(String[] args)  throws SQLException{
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/parties";
		Connection con = DriverManager.getConnection(url,"root","Janvi@123");
		
		System.out.println("Connection ho gaya");
		
		Statement st = con.createStatement();
		
	    System.out.println("Statement object created");
	    
	    ResultSet rs=st.executeQuery("select max(salary) from jdbc1");
	    
	    while(rs.next()) {
	    	
	    	System.out.println("Max Salary : "+rs.getInt(1));
	    	
	    }
	}

}
