/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumy;

import stavy.Pokracuj;
import stavy.Prehra;
import stavy.StavHry;
import stavy.Vyhra;

/**
 *
 * @author MiloÅ¡
 */
public enum StavyHry {
    VYHRA(new Vyhra()),
    PREHRA(new Prehra()),
    POKRACUJ(new Pokracuj());
    private final StavHry stav;
    
    
    StavyHry(StavHry stav) {
        this.stav = stav;
    }
    
    
    public  StavHry getStavHry() {
        return this.stav;
    }
    
    
    
}
