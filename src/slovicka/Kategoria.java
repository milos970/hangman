/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slovicka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Miloš
 */
public class Kategoria {
    private String nazov;
    private final ArrayList<String> slova;
    private int pocetSlov;
    private final int [] pouziteIndexy;
    
            
    public Kategoria(String cestaKSuboru) throws FileNotFoundException {
        File file = new File(cestaKSuboru);
        try (Scanner scanner = new Scanner(file)) {
            this.slova = new ArrayList<>();
            // uloží názov súboru
            if (file.getName().indexOf(".") > 0) { 
                this.nazov = file.getName().substring(0, file.getName().lastIndexOf(".")); 
            }
            this.pocetSlov = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) { // preskočí prázdny riadok
                    continue;
                }
                if (line.length() > 15 ) { // načíta len neprázdny riadok s dlžkou max 15 znakov
                    continue;
                }
                this.slova.add(line);
                this.pocetSlov++;
            }
            scanner.close();
        }
        this.pouziteIndexy = new int[this.pocetSlov];
    }   
    
    
    public String getSlovo(int index) {
        return this.slova.get(index);     
    }
    
    
    public boolean getSlovo(String slovo) {
        return this.slova.contains(slovo);
    }
    
       
    public int getPocetSlov() {
        return this.pocetSlov;
    }
    
    
    public String getNazov() {
        return this.nazov;
    }
    
    
    
}
