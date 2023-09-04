/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panely;

import enumy.Farba;
import gui.Hra;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Miloš¡
 */
public class PanelCasovac extends JPanel implements IPanely, ActionListener {
    private int minuty;
    private int sekundy;
    private final Hra hra;
    private final Timer timer;
    
    public PanelCasovac(Hra hra) {
        this.hra = hra;
        super.setBackground(Farba.ORANZOVA.getFarba());
        Dimension dimension = new Dimension(0, 60);
        super.setPreferredSize(dimension);
        super.setVisible(false);
        this.timer = new Timer(1000, this);
    }
    
    
    @Override
    public void zobraz() {   
        this.setVisible(true);
        this.timer.start();
        super.repaint();    
    }
    
    
    public void stop() {
        this.timer.stop();
        super.repaint();
    }
    
    
    private void ukonci() {
        this.hra.znizPokusy();
    }
    
    
    public void nastavMinuty(int pocet) {
        if (pocet <= 9) {
            this.minuty = pocet;
        }
    }
    
    
    public void nastavSekundy(int pocet) {
        if (pocet <= 60) {
            this.sekundy = pocet;
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        String s;
        String m;
        Font font = new Font("Verdana", Font.BOLD, 20);

        if (this.minuty < 10) {
            m = String.valueOf("0" + this.minuty);
        } else {
            m = String.valueOf(this.minuty);
        }
        g.setFont(font); 
        g.drawString(m, 90, 35);
        g.drawString(" : ", 115, 35);

        if (this.sekundy < 10) {
            s = String.valueOf("0" + this.sekundy);
        } else {
            s = String.valueOf(this.sekundy);
        }

        g.drawString(s, 130, 35);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.sekundy--;
        super.repaint();
         
        if (this.sekundy < 0) {
            this.minuty--;
            super.repaint();
            if (this.minuty < 0) {
                this.minuty = 0;
                this.sekundy = 0;
                this.timer.stop();
                this.ukonci();
            } else {
                this.sekundy = 59;
                super.repaint();
            }
        }       
    } 
    
    
    
}
        
    

