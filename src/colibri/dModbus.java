package colibri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import javax.swing.JDialog;

public class dModbus extends Thread{
	
	static String Metri;
	static String Peso;
	
	
	
	Modbus ModData = new  Modbus();
	
	public int Connect() {
	
	return 0;
	}
	
	
	@Override
	public void run() {		
	
		while (true) {
			
			try {
				if	( Flag.senzaPeso == true){
					
					Peso = ModData.ReadRegisterString(4);
					sleep(50);
					
				}

				if (Flag.senzaMetri == true) {
					
					Metri = ModData.ReadRegisterString(2);
					sleep(50);
					
					
				}
				

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
