/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slovicka;

/**
 *
 * @author MiloÅ¡
 */
public class Parser {
    private  char[] znaky;
    
    public Parser() {
        this.znaky = null;
    }
    
    /**
     * prevedie string na pole znakov
     * @param slovo
     * @return 
     */
    public char[] prevedSlovo(String slovo) {
        slovo = slovo.toUpperCase();
        this.znaky = slovo.toCharArray();
        return this.znaky;       
    } 
    
    
}
