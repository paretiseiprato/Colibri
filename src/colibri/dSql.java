package colibri;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import ModbusServer.gui.NewJFrame;

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
	static int Errore;
	final String MachineNumber = "2";
	Modbus ModbusData = new Modbus();
	
	public void Connect() {
	
	try {
		
		//Inizializzazione del driver sqlserver
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		dbURL = "jdbc:sqlserver://192.168.56.133:1433;instance=SQLEXPRESS;databaseName=TestEssetre;user=takoda;password=tkd00tkd";
		Conn = DriverManager.getConnection(dbURL);
		if (Conn != null) {
		    System.out.println("Connected");
		    
		    Errore = 0;
		    
		}
		else {
			Errore = -1;
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		Errore = -2;
	}
	//return 0;
	}
///////////////////////////////////////////
	
	@Override
	public void run() {
	


	
		
		String SQL = "SELECT * FROM TblFlag WHERE idArrotolatore = " + MachineNumber;
		

		while (true) 
		{			
			try
			{
				//creo query ciclica x attivazione scrittura
				Stant = Conn.createStatement();			
				Result = Stant.executeQuery(SQL);
				
				if (Result.next()) {
					
		            System.out.println(Result.getString(3));
		            Disposizione = Result.getInt(3);
		            		            
		         }
				
	      
	            
				sleep(500);
			} catch (InterruptedException | SQLException e)
			{	
				Errore = -1;
				e.printStackTrace();
				
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
								String QueryDati = "UPDATE TblFlag SET Metri =" + Metri + ", Peso = " + Peso + " WHERE idArrotolatore = " + MachineNumber;//UPDATE TblFlag SET [IdArrotolatore] ='2' WHERE id = 2
								InvioDati = Conn.createStatement();										
								InvioDati.executeUpdate(QueryDati);
								sleep(500);
								ResetFlag = Conn.createStatement();
								String QueryReset = "UPDATE TblFlag SET FlagStato = '0' WHERE idArrotolatore = " + MachineNumber;																	
								ResetFlag.executeUpdate(QueryReset);
								
								/*if (Errore < 0) {
									Statement ErrorFlag = Conn.createStatement();
									String QueryError = "UPDATE TblFlag SET FlagStato = '-1' WHERE idArrotolatore = " + MachineNumber;																	
									ErrorFlag.executeUpdate(QueryError);
									
								}*/
							} catch (SQLException | InterruptedException e) {
								// TODO Auto-generated catch block
								Errore = -3;
								e.printStackTrace();
							}			
							
							break;
						case 2:
							break;
						case 3:
							int[] NumReset = {0,1};
							ModbusData.WriteRegisterString(6, NumReset);
				try {
					ResetFlag = Conn.createStatement();
					String QueryReset = "UPDATE TblFlag SET FlagStato = '0' WHERE idArrotolatore = " + MachineNumber;																	
					ResetFlag.executeUpdate(QueryReset);
				} catch (SQLException e) {
					// TODO Auto-generated catch blocktakoda
					Errore = -4;
					e.printStackTrace();
				}
					
							
							break;
						default:
							break;
						}			
			
		}
			
		}
	}
	

