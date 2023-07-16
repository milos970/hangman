/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stavy;

import gui.Hra;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author MiloÅ¡
 */
public abstract class StavHry extends JPanel {
    
    public StavHry(Color color) {
        super.setVisible(false);
        super.setBackground(color);
        Dimension d = new Dimension(470, 130);
        super.setPreferredSize(d);
    }
    
       
    public abstract void zobraz();
    
    public abstract void vlozHru(Hra hra);
    
    
}
