package colibri;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class dSql extends Thread{
	
	Connection Conn = null;
	Statement Stant = null;
	ResultSet Result = null;
	
	public int Connect() {
	
	try {
		
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		String dbURL = "jdbc:sqlserver://localhost\\sqlexpress;user=sa;password=secret";
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
	

		try {
			while (Result.next()) {
				System.out.println(Result.getString(4) + " " + Result.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int I = 0;
		
		String SQL = "SELECT TOP 10 * FROM Person.Contact";
		
		try {
			Stant = Conn.createStatement();
			Result = Stant.executeQuery(SQL);
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
	
		while (true) {
			I++;
			System.out.println("Task" + I );
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		}
	}
	

