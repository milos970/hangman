/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slovicka;

import gui.Hra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miloš
 */
public class Kontrola {
    private char uhadnutyZnak;
    private final char[] abeceda;
    private char[] slovo;
    private List<Character> znakySlova;
    private int[] pocetZnakov;
    private int[] suradnice;
    private String hadaneSlovo;
    private final Hra hra;
    private char[] poskladaneSlovo;
    
    public Kontrola(Hra hra) {
        this.hra = hra; 
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "; 
        this.abeceda = abc.toCharArray();
    }
    
    
    public void pridajSlovo(char[] slovo) { 
        this.znakySlova = new ArrayList<>();
        this.suradnice = null;
        
        this.hadaneSlovo = new String(slovo); 
        
        this.pocetZnakov = new int[slovo.length];
        this.poskladaneSlovo = new char[slovo.length];
        this.slovo = slovo; 
        for (int i = 0; i < slovo.length; i++) {
            if (slovo[i] == ' ') {
                this.poskladaneSlovo[i] = ' ';
                this.pocetZnakov[i] = 1; 
            } else {
                this.pocetZnakov[i] = 0;
            }
        }

        for (char c : this.abeceda) {
            for (int i = 0; i < this.slovo.length; i++) {
                if (c == slovo[i]) {
                    this.znakySlova.add(slovo[i]);
                }
            }
        }      
    }
    
    
    public String getHadaneSlovo() {
        return this.hadaneSlovo;
    }
    
    
    public int[] getPocetZnakovSlova() {
        return this.pocetZnakov;
    }
    
    
    public boolean hadajPismeno(char znak) throws IOException {
        if (this.znakySlova.contains(znak)) {   
            this.uhadnutyZnak = znak;
            this.suradniceZnakov();
            return true; 
        } else {
            return false;
        }
    }
    
    
    public void uhadol() throws IOException {
        
        String slovo1 = new String(this.poskladaneSlovo) ;
        
        
        if (this.hadaneSlovo.equals(slovo1)) {
            this.hra.pridajBody();
            this.hra.start();
        }
    }
    
    /**
     nájde súradnicu uhádnutého znaku
     daný znak vloží do pola medzi ostatné
    */
    private void suradniceZnakov() {
        int[] suradnice1 = new int[this.pocetZnakov.length];   
        for (int i = 0; i < this.slovo.length ; i++) {           
            if (this.uhadnutyZnak == this.slovo[i]) {
                suradnice1[i] = 1;  
                
                this.poskladaneSlovo[i] = this.uhadnutyZnak;
                
            }
        }       
        this.suradnice = suradnice1;        
    }
    
          
    public int[] getSuradnice() {
        return this.suradnice;
    } 
    
    
    
}
