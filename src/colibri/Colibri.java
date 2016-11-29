/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colibri;

import javax.swing.JFrame;
import javax.swing.JRootPane;

/**
 *
 * @author Damiano Pareti
 */
public class Colibri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gui PanelMaster = new Gui();
        PanelMaster.setResizable(false);
       PanelMaster.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      PanelMaster.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
       PanelMaster.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        PanelMaster.setVisible(true);
    }
    
}
