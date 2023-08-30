/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obesenec;

import ponuka.Skore;

import java.io.*;

/**
 *
 * @author Miloš
 */
public class Ukladanie {
    
    public static void zapis(Skore skore) throws IOException {
        File subor = new File("save/Skore.bin");
        FileOutputStream stream = new FileOutputStream(subor);
        try (ObjectOutputStream zapis = new ObjectOutputStream(stream)) {
            zapis.writeObject(skore);
        }
    }
    
    public static Skore nacitaj() throws IOException, ClassNotFoundException {
        Skore skore;
        File subor = new File("save/Skore.bin");
        if (subor.length() == 0) { // pokial je dany súbor prázdny tak sa nič nepokúša načítať
            return null;
        }
        FileInputStream stream = new FileInputStream(subor);
        try (ObjectInputStream citaj = new ObjectInputStream(stream)) {
            skore =  (Skore)citaj.readObject();
        }
        return skore;
    }
    
    
    
}