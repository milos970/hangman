/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panely;


import gui.Hra;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Objects;

/**
 *
 * @author Miloš¡
 */
public class PanelHangMan extends JLabel implements IPanely {
    private final Hra hra;
    private int pocet;
    
    
    public PanelHangMan(Hra hra) {
        this.hra = hra;
        super.setVisible(false);
    }
    
    
    @Override
    public void zobraz() {
        this.pocet = 2;
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/obrazky/obesenec/1.png"))));
        super.setVisible(true);
    }
    
    
    public void vykresliCast() {        
        if (this.pocet < 7) {
            setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/obrazky/obesenec/" + this.pocet + ".png"))));
            this.pocet++;
        } else {
            setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/obrazky/obesenec/" + this.pocet + ".png"))));
            this.koniec();
        }
    }
    
    
    private void koniec() {
        this.hra.znizPokusy();
    }
    
    
    
}
