/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panely;

import enumy.Farba;
import gui.Hra;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Miloš
 */
public class PanelPokusy extends JPanel implements IPanely {
    private final Hra hra;
    private int pocet;
    
    
    public PanelPokusy(Hra hra, int pocet) {
        this.hra = hra;
        super.setBackground(Farba.ZELENA.getFarba());
        Dimension dimension = new Dimension(0, 60);
        super.setPreferredSize(dimension);
        super.setVisible(false);
        this.pocet = pocet;
    }
    
    
    @Override
    public void zobraz() {
        super.setVisible(true);
    }
    
    
    public int getPocetPokusov() {
        return this.pocet;
    }
    
    
    public void zniz() {
        this.pocet--;
        super.repaint();
        if (this.pocet < 0) {
            this.pocet = 0;
            try {
                this.koniec();
            } catch (IOException ex) {
                Logger.getLogger(PanelPokusy.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }       
    }
    
    
    
    private void koniec() throws IOException {
        this.hra.koniecHry();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Verdana", Font.BOLD, 20);
        String m = String.valueOf(this.pocet);
        String text = "Počet pokusov:";
        g.setFont(font); 
        g.drawString(text, 20, 35);
        g.setColor(Color.red);
        g.drawString(m, 200, 35);
    }
    
    
    
}
