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
	final String MachineNumber = "AR01";

	
	
	Modbus ModbusData = new Modbus();
	
	public void Connect() {
	
	try {
		
		//Inizializzazione del driver sqlserver
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		//dbURL = "jdbc:sqlserver://10.10.10.233:1433;instance=SQLEXPRESS;databaseName=TestEssetre;user=takoda;password=tkd00tkd";
		dbURL = "jdbc:sqlserver://10.10.10.253:1433;instance=SQLEXPRESS;databaseName=ProduzioneEssetre;user=sa;password=azsx.2012";
		Conn = DriverManager.getConnection(dbURL);
		if (Conn != null) {
		    System.out.println("Connected");
		    
		    Flag.erroreDb = 0;
		    
		}
		else {
			Flag.erroreDb = -1;
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		Flag.erroreDb = -2;
	}
	//return 0;
	}
///////////////////////////////////////////
	
	@Override
	public void run() {
	


	
		
		String SQL = "SELECT * FROM Macchine WHERE IdMacchina = " + "'" + MachineNumber +"'" ;
		

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
				Flag.erroreDb = -1;
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
								String QueryDati = "UPDATE Macchine SET Metri =" + Metri + ", Peso = " + Peso + " WHERE IdMacchina = " + "'" + MachineNumber +"'";//UPDATE Macchine SET [IdMacchina] ='2' WHERE id = 2
								InvioDati = Conn.createStatement();										
								InvioDati.executeUpdate(QueryDati);
								sleep(500);
								ResetFlag = Conn.createStatement();
								String QueryReset = "UPDATE Macchine SET FlagStato = '2' WHERE IdMacchina = " + "'" + MachineNumber +"'";																	
								ResetFlag.executeUpdate(QueryReset);
								
								/*if (Errore < 0) {
									Statement ErrorFlag = Conn.createStatement();
									String QueryError = "UPDATE Dati SET FlagStato = '-1' WHERE IdMacchina = " + MachineNumber;																	
									ErrorFlag.executeUpdate(QueryError);
									
								}*/
							} catch (SQLException | InterruptedException e) {
								// TODO Auto-generated catch block
								Flag.erroreDb = -3;
								e.printStackTrace();
							}			
							
							break;
						case 2:
							break;
						case 3:
							
							int[] NumReset = {0,1};
							ModbusData.WriteRegisterString(6, NumReset);
				try {
					if (Integer.valueOf(dModbus.Metri)  < 1) {
						
						ResetFlag = Conn.createStatement();
						String QueryReset = "UPDATE Macchine SET Metri = '0', Peso = '0', FlagStato = '2' WHERE IdMacchina = " + "'" + MachineNumber +"'";																	
						ResetFlag.executeUpdate(QueryReset);					
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch blocktakoda
					Flag.erroreDb = -4;
					e.printStackTrace();
				}
					
							
							break;
						default:
							break;
						}			
			
		}
			
		}
	}
	

