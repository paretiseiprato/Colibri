package colibri;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class dSql extends Thread{
	
	Connection Conn = null;
	Statement Stant = null;
	ResultSet Result = null;
	static String Disposizione;
	String dbURL;
	
	public int Connect() {
	
	try {
		
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		dbURL = "jdbc:sqlserver://192.168.56.133:1433;instance=SQLEXPRESS;databaseName=TestEssetre;user=takoda;password=tkd00tkd";
		Conn = DriverManager.getConnection(dbURL);
		if (Conn != null) {
		    System.out.println("Connected");
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return 0;
	}
	
	
	@Override
	public void run() {
	


	
		
		String SQL = "SELECT *FROM TblFlag";
		

		while (true) 
		{			
			try
			{
				Stant = Conn.createStatement();			
				Result = Stant.executeQuery(SQL);
				
				while (Result.next()) {
					
		            System.out.println(Result.getString(1));
		            Disposizione = Result.getString(2);
		            
		         }
				sleep(500);
			} catch (InterruptedException | SQLException e)
			{				
				e.printStackTrace();
			}			
		}
			
		}
	}
	

