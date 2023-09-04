/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumy;

import java.awt.Color;

/**
 *
 * @author Miloš¡
 */
public enum Farba {
    ZELENA(Color.green),
    CERVENA(Color.red),
    ORANZOVA(Color.orange),
    MODRA(Color.blue),
    BIELA(Color.white),
    ZLTA(Color.yellow);
    private final Color farba;
            
    
    Farba(Color farba) {
        this.farba = farba;
    }
    
    
    public Color getFarba() {
        return this.farba;
    }
    
    
    
}
