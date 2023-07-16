/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panely;

import enumy.Farba;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Miloš
 */
public class PanelSlovo extends JPanel implements IPanely {
    private int[] pocetCiar;
    private char[] znaky; 
    private final BufferedImage image;
    
    
    public PanelSlovo() throws IOException {
        super.setBackground(Farba.ZLTA.getFarba());
        this.image = ImageIO.read(new File("src/obrazky/tapety/tapeta.png"));
        super.setVisible(false);      
    }
    
    
    @Override
    public void zobraz() {
        super.setVisible(true);
        this.znaky = null;
        this.pocetCiar = null;
        super.repaint();
    }
    
    
    public void pridajUhadnutyZnak(char znak, int poradie) {
        this.znaky[poradie] = znak;
        super.repaint();
    }
    
    /**
     * vykreslí na panel pocet ciar na znaky slova
     * @param pocet 
     */
    public void pocetCiar(int[] pocet) {
        this.pocetCiar = pocet;
        this.znaky = new char[pocet.length];
        super.repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
        
        if (this.pocetCiar != null) {
            
            for (int i = 0; i < this.pocetCiar.length; i++) {
                
                String uhadnutyZnak = String.valueOf(this.znaky[i]);
                if (this.pocetCiar[i] == 0) {
                    g.drawString(uhadnutyZnak, 26 + (i * 30), 145);
                    g.drawLine(20 + (i * 30), 150, 40 + (i * 30), 150);
                }                
            }
        }
    }
    
    
   
}  
    
    

    

