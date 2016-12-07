package colibri;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class dSql extends Thread{
	
	Connection Conn = null;
	Statement Stant = null;
	ResultSet Result = null;
	static String Disposizione;
	
	public int Connect() {
	
	try {
		
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		String dbURL = "jdbc:sqlserver://WIN-8TQS8MD3J80\\SQLEXPRESS;user=takoda;password=tkd00tkd";
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
	


	
		
		String SQL = "SELECT Disposizione FROM TblFlag";
		
		
		try {
			Stant = Conn.createStatement();
			Result = Stant.executeQuery(SQL);
			while (Result.next()) {
	            System.out.println(Result.getString(1));
	         }
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
		while (true) 
		{			
			try
			{
				sleep(500);
			} catch (InterruptedException e)
			{				
				e.printStackTrace();
			}			
		}
			
		}
	}
	

