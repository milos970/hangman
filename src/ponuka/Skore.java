/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponuka;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MiloÅ¡
 */
public class Skore implements Serializable {
    private final HashMap<String, Integer> hraci;
    
    public Skore () {
        this.hraci = new HashMap<>();
    }
    
    public boolean pridajMenoHraca(String meno) {
        if (!this.hraci.containsKey(meno)) {
            this.hraci.put(meno, 0);
            return true;
        }
        return false;
    }
    
    
    public void pridajBodyHracovi(String meno, int pocetBodov) {
        this.hraci.put(meno, this.hraci.get(meno) + pocetBodov);
    }
    
    
    public String vypis() {
        String text = "  Meno                                  Body";      
        for (Map.Entry<String, Integer> entry: this.hraci.entrySet()) {
            text += "\n";
            text += "  " + entry.getKey() + "                                  " + entry.getValue();           
        }
        return text;
    }
    
    
    
}
