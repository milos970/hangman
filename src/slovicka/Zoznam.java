/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slovicka;

import java.util.HashMap;

/**
 *
 * @author Miloš
 */
public class Zoznam {
    private final HashMap<String, Kategoria> kategorie;
    
    public Zoznam() {
        this.kategorie = new HashMap<>();
    }
    
    
    public void pridajKategoriu(Kategoria kategoria) {
        this.kategorie.put(kategoria.getNazov(), kategoria);
    }
    
    /**
     * da kategoriu podla jej názvu
     */
    public Kategoria getKategoriu (String nazov) {
        if (!this.kategorie.containsKey(nazov)) {
            return null;
        }
        return this.kategorie.get(nazov);
    }
    
    /**
     * da kategoriu podla slova ktoré sa v nej nachádza
     */
    public Kategoria getKategoriuPodlaSlova(String slovo) {
        String[] categories = this.getVsetkyKategorie();
        Kategoria k = null;
        for (String kategorie1 : categories) {
            k = this.getKategoriu(kategorie1);
            if (k.getSlovo(slovo)) {
                return k;               
            }
        }
        return k;
    }
    
       
    public String[] getVsetkyKategorie() {
        String[] zoznam = new String[this.kategorie.size()];
        int i = 0;
        for (String s: this.kategorie.keySet()) {
            zoznam[i] = s;
            i++;
        }
        return zoznam;
    } 
    
    
    
}
