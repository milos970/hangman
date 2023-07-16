/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumy;

/**
 *
 * @author MiloÅ¡
 */
public enum Obtiaznost {
    STREDNA("stredna"),
    TAZKA("tazka");
    private final String obtiaznost;
    
    
    Obtiaznost(String obtiaznost) {
        this.obtiaznost = obtiaznost;
    }
    
    
    public String getObtiaznost() {
        return this.obtiaznost;
    }
    
    
    
}
