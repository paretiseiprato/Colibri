/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colibri;
import java.io.IOException;

import ModbusClient.ModbusClient;

/**
 *
 * @author Damiano Pareti
 */
public class Modbus{
    
    ModbusClient modbusClient;
    public Modbus() {
        modbusClient = new ModbusClient("127.0.0.1", 502);
        modbusClient.setConnectionTimeout(3000);
        try {
			modbusClient.Connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
    
    
    
}
