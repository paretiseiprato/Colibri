package colibri;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class dSql extends Thread{
	
	Connection Conn = null;
	Statement Stant = null;
	ResultSet Result = null;
	Statement InvioDati;
	Statement ResetFlag;
	ResultSet Risultatidati;
	static int Disposizione;
	String dbURL;
	int Status;
	
	public int Connect() {
	
	try {
		
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		dbURL = "jdbc:sqlserver://192.168.56.133:1433;instance=SQLEXPRESS;databaseName=TestEssetre;user=takoda;password=tkd00tkd";
		Conn = DriverManager.getConnection(dbURL);
		if (Conn != null) {
		    System.out.println("Connected");
		    return 0;
		    
		}
		else {
			return -1;
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return -2;
	}
	//return 0;
	}
	
	
	@Override
	public void run() {
	


	
		
		String SQL = "SELECT * FROM TblFlag WHERE id = 2";
		

		while (true) 
		{			
			try
			{
				Stant = Conn.createStatement();			
				Result = Stant.executeQuery(SQL);
				
				if (Result.next()) {
					
		            System.out.println(Result.getString(3));
		            Disposizione = Result.getInt(3);
		            		            
		         }
				
	      
	            
				sleep(500);
			} catch (InterruptedException | SQLException e)
			{				
				e.printStackTrace();
				Disposizione = -1;
			}
			
		      switch (Disposizione) {
						case -1:
							
							break;
						case 0:
							break;
						case 1:
							
							   String Metri = dModbus.Metri;
	        			       String Peso = dModbus.Peso;
							try {
								String QueryDati = "UPDATE TblFlag SET Metri =" + Metri + ", Peso = " + Peso + " WHERE idArrotolatore = 2";//UPDATE TblFlag SET [IdArrotolatore] ='2' WHERE id = 2
								InvioDati = Conn.createStatement();										
								InvioDati.executeUpdate(QueryDati);
								sleep(500);
								ResetFlag = Conn.createStatement();
								String QueryReset = "UPDATE TblFlag SET FlagStato = '0' WHERE idArrotolatore = 2";																	
								ResetFlag.executeUpdate(QueryReset);
							} catch (SQLException | InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}			
							
							break;
						case 2:
							break;
						case 3:
							break;
						default:
							break;
						}			
			
		}
			
		}
	}
	

