/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colibri;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import Exceptions.ModbusException;
import ModbusClient.ModbusClient;

/**
 *
 * @author Damiano Pareti
 */
public class Modbus{
    
    
	ModbusClient modbusClient;
	ModbusClient modbusWrite;
	static int Error;
	//int[] Uno = {1};
	
	//int InvertData = ModbusClient.ConvertRegistersToDouble(Uno, ModbusClient.RegisterOrder.HighLow);
	
	 
    public Modbus() {
        modbusClient = new ModbusClient("127.0.0.1", 502);
        modbusClient.setConnectionTimeout(3000);
        modbusWrite = new ModbusClient("127.0.0.1", 502);
	    modbusWrite.setConnectionTimeout(3000);
	        
        try {
			modbusClient.Connect();
			Error = 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if (!modbusClient.isConnected()){}
			Error = -1;
			e.printStackTrace();
		}
        try {
			modbusWrite.Connect();
			Error = 2;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Error = -2;
			e.printStackTrace();
		}
    }
    
    public String ReadRegisterString(int RegNumber){
    try {
          
 //Write Float value to Register 10 and 11
          int[] Register = modbusClient.ReadHoldingRegisters(RegNumber, 2) ;
          int  RetRegister = ModbusClient.ConvertRegistersToDouble(Register, ModbusClient.RegisterOrder.HighLow);
          return String.valueOf(RetRegister);
          
        } catch (Exception e) {
            return "ERROR";
            
        }
    }
	 public void WriteRegisterString(int RegNumber,int[] DataWrite){
		 
		 
		// modbusReset = new ModbusClient("127.0.0.1", 502);
	      //  modbusReset.setConnectionTimeout(3000);
	        try {
				modbusWrite.Connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	try {
		modbusWrite.WriteMultipleRegisters(RegNumber,DataWrite);//ModbusClient.ConvertDoubleToTwoRegisters(1, ModbusClient.RegisterOrder.LowHigh)
		// TODO Auto-generated catch block
		
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ModbusException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
    
    
    
}
