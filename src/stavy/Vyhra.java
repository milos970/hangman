/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stavy;

import enumy.Farba;
import gui.Hra;
import java.awt.Font;
import javax.swing.JLabel;
/**
 *
 * @author Miloš
 */
public class Vyhra extends StavHry {
    
    
    public Vyhra() {
        super(Farba.ZELENA.getFarba());
    }

    /**
     * odstráni všetko na panely
     * následne sa zobrazí 
     */
    @Override
    public void zobraz() {
        super.removeAll();
        super.revalidate();
        super.repaint();
        JLabel label = new JLabel("Gratulujem, dokončil si hru!");
        label.setFont(new Font("Sherif", Font.BOLD, 30));
        super.add(label);
        super.setVisible(true);
    }

    @Override
    public void vlozHru(Hra hra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
