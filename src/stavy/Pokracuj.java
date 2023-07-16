/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stavy;

import enumy.Farba;
import gui.Hra;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author Miloš
 */
public class Pokracuj extends StavHry  implements ActionListener {
    private  Hra hra;
    
    /**
     *
     */
    public Pokracuj() {
        super(Farba.ORANZOVA.getFarba());
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
        JButton button = new JButton("Pokračuj");
        button.setFont(new Font("Arial", Font.BOLD, 30));
        super.add(button, new BorderLayout());
        button.addActionListener(this);
        super.setVisible(true);
    }
    
    /** 
     * spusti hru po kliknuti mysou na button
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.hra.start();
    }
    
    /**
     *
     * @param hra
     */
    @Override
    public void vlozHru(Hra hra) {
        this.hra = hra;
    }
   
    
      
}
