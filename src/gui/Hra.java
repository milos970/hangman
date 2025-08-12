/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import enumy.Farba;
import enumy.Obtiaznost;
import enumy.StavyHry;
import obesenec.Ukladanie;
import panely.*;
import ponuka.Skore;
import slovicka.Kategoria;
import slovicka.Kontrola;
import slovicka.Zoznam;
import stavy.StavHry;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Miloš
 */
public class Hra extends javax.swing.JFrame {
    private PanelHangMan hangman;
    private PanelSlovo slovo;
    private Kontrola kontrola;
    private PanelCasovac casovac;
    private PanelKlavesnica klavesnica;
    private PanelPokusy pokusy;
    private final Zoznam zoznam;
    private int pocetHier;
    private int pocetSlov;
    private final List list;
    private final Color color;
    private final String meno;
    private boolean koniec;
    private final Skore skore;
    private int pocetPokusov;
    private final HlavneMenu menu;
    private int bonusoveBody;
    private boolean priratajBody;

    /**
     * Creates new form HlavneMenu
     */

    public Hra(String meno, Obtiaznost obtiaznost, Color color, Skore skore, HlavneMenu menu) throws IOException {
        ImageIcon icon = new ImageIcon("src/obrazky/ikony/ikona.png");
        super.setIconImage(icon.getImage());
        super.setVisible(false);

        this.meno = meno;

        if (Obtiaznost.TAZKA == obtiaznost) {
            this.casovac = new PanelCasovac(this);
            this.pocetPokusov = 2;
            this.bonusoveBody = 3;

        } else {
            this.pocetPokusov = 3;
            this.bonusoveBody = 0;
        }


        this.color = color;

        this.skore = skore;

        this.menu = menu;


        this.zoznam = new Zoznam();
        this.zoznam.pridajKategoriu(new Kategoria("src/subory_slovicok/Hardware.txt"));
        this.zoznam.pridajKategoriu(new Kategoria("src/subory_slovicok/Software.txt"));

        String[] nazvyKategorii = this.zoznam.getVsetkyKategorie();

        for (String nazvyKategorii1 : nazvyKategorii) {
            Kategoria kategoria = this.zoznam.getKategoriu(nazvyKategorii1);
            this.pocetSlov += kategoria.getPocetSlov();
        }
        this.pocetHier = this.pocetSlov;

        List<String> nahodneSlova = new LinkedList<>();

        for (String nazvyKategorii1 : nazvyKategorii) {
            Kategoria kategoria = this.zoznam.getKategoriu(nazvyKategorii1);
            for (int j = 0; j < kategoria.getPocetSlov(); j++) {
                nahodneSlova.add(kategoria.getSlovo(j));
            }
        }


        this.list = new ArrayList<String>();
        for (int i = 0; i < this.pocetSlov; i++) {
            this.list.add(nahodneSlova.get(i));
        }
        Collections.shuffle(this.list);
        this.priratajBody = false;

        this.initComponents();
    }


    private Hra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void zmenFarbuPozadia() {
        if (null != this.color) {
            this.jPanel1.setBackground(this.color);
        }
    }

    private void vlozDoPanelov() {
        if (this.pokusy == null) {
            this.pokusy = new PanelPokusy(this, this.pocetPokusov);
            this.jPanel5.add(this.pokusy, BorderLayout.NORTH);
        }

        if (this.klavesnica == null) {
            this.klavesnica = new PanelKlavesnica(this);
            this.jPanel4.add(this.klavesnica, BorderLayout.CENTER);

        }

        if (this.casovac != null) {
            this.casovac = new PanelCasovac(this);
            this.jPanel5.add(this.casovac, BorderLayout.SOUTH);
        }

        if (this.hangman == null) {
            this.hangman = new PanelHangMan(this);
            this.jPanel2.add(this.hangman, BorderLayout.NORTH);
        }

        if (this.slovo == null) {
            try {
                this.slovo = new PanelSlovo();
            } catch (IOException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jPanel6.add(this.slovo, BorderLayout.CENTER);
        }

    }


    public void pridajBody() {
        this.skore.pridajBodyHracovi(this.meno, 1);
    }

    /**
     * spusti hru
     */
    public void start() {

        if (this.klavesnica != null) {
            this.obnovKlavesnicu();

        }

        if (this.casovac != null) {
            this.casovac.stop();
        }
        this.vlozDoPanelov();

        this.zmenFarbuPozadia();
        this.jTextField1.setBackground(Farba.BIELA.getFarba());
        this.jButton1.setBackground(Farba.BIELA.getFarba());

        this.pridajBodyHracovi();

        if (this.pocetHier == 0) {

            this.vyhra();
            return;
        }

        if (this.koniec) {

            this.prehra();
            return;
        }

        if (this.pokusy.getPocetPokusov() < this.pocetPokusov) {

            this.pokracuj();
            this.priratajBody = false;
            this.pocetPokusov = this.pokusy.getPocetPokusov();
            return;
        }


        if (this.pocetHier == this.pocetSlov) {
            this.kontrola = new Kontrola(this);
            this.hangman.zobraz();
            this.pokusy.zobraz();
            this.obnovKlavesnicu();

            this.slovo.zobraz();

            if (this.casovac != null) {
                this.casovac.nastavMinuty(0);
                this.casovac.nastavSekundy(10);
                this.casovac.zobraz();
            }


            String g = (String) this.list.get(this.pocetHier - 1);
            this.pocetHier--;
            this.list.remove(g);
            try {

                this.vlozSlovoZKategorie(g, this.zoznam.getKategoriuPodlaSlova(g).getNazov());
            } catch (IOException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.casovac != null) {
                this.casovac.nastavMinuty(1);
                this.casovac.nastavSekundy(30);
                this.casovac.zobraz();
            }

        } else {
            if (this.casovac != null) {

                this.casovac.nastavSekundy(30);
                this.casovac.nastavMinuty(1);
                this.casovac.zobraz();

            }
            this.obnovKlavesnicu();
            this.hangman.zobraz();
            this.pokusy.zobraz();
            this.slovo.zobraz();


            String g = (String) this.list.get(this.pocetHier - 1);
            this.pocetHier--;
            this.list.remove(g);
            try {

                this.vlozSlovoZKategorie(g, this.zoznam.getKategoriuPodlaSlova(g).getNazov());
            } catch (IOException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }

    private void pridajBodyHracovi() {
        if (this.priratajBody) {
            this.skore.pridajBodyHracovi(this.meno, 1);
        }
    }

    public void zobraz() {
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    /**
     * metoda vloží do panela 4 panel prehra
     * zastaví časovač
     * ukáže hladané slovo
     * uloži skore
     * zmení text tlacidla tejto instancie na spať
     */
    private void prehra() {
        if (this.casovac != null) {
            this.casovac.stop();
        }

        try {
            Ukladanie.zapis(this.skore);
        } catch (IOException ex) {
            Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
        }


        this.priratajBody = false;
        this.pridajBodyHracovi();
        StavHry stav = StavyHry.PREHRA.getStavHry();
        this.obnovPanel4();
        this.jPanel4.add(stav);
        stav.zobraz();
        this.jButton1.setText("Spať do menu");
        this.ukazHladaneSlovo();
    }

    private void obnovKlavesnicu() {

        this.obnovPanel4();
        this.jPanel4.add(this.klavesnica);
        this.klavesnica.zobraz();
    }

    /**
     * prekresli panel pre nové komponenty
     */
    private void obnovPanel4() {
        this.jPanel4.removeAll();
        this.jPanel4.revalidate();
        this.jPanel4.repaint();
    }

    /**
     * metoda vloží do panela 4 panel vyhra
     * zastaví časovač
     * zapíše body hráčovi a uloží
     */
    private void vyhra() {

        if (this.casovac != null) {
            this.casovac.stop();
        }
        this.skore.pridajBodyHracovi(this.meno, this.bonusoveBody);
        try {
            Ukladanie.zapis(this.skore);
        } catch (IOException ex) {
            Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
        }


        StavHry stav = StavyHry.VYHRA.getStavHry();
        this.obnovPanel4();
        this.jPanel4.add(stav);
        stav.zobraz();

        if (this.pocetPokusov < 0) {
            this.ukazHladaneSlovo();
        }
        this.jButton1.setText("Spať do menu");
        this.jTextField1.setVisible(false);
        this.jTextField1.setEditable(false);

        this.pridajBodyHracovi();

    }

    /**
     * metoda vloží do panela 4 panel pokracuj
     * zastaví časovač
     * ukáže hladané slovo
     */
    private void pokracuj() {

        if (this.casovac != null) {
            this.casovac.stop();
        }
        this.priratajBody = false;
        this.pridajBodyHracovi();
        StavHry stav = StavyHry.POKRACUJ.getStavHry();
        this.obnovPanel4();
        this.jPanel4.add(stav);
        stav.vlozHru(this);
        stav.zobraz();
        this.ukazHladaneSlovo();
        this.klavesnica.zobraz();

    }


    public void znizPokusy() {
        this.priratajBody = false;
        this.pokusy.zniz();
        this.start();
    }

    private void vlozSlovoZKategorie(String slovoZKategorie, String nazovKategorie) throws IOException {
        this.jTextField1.setText(nazovKategorie);
        this.jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
        this.jTextField1.setVisible(true);
        this.jTextField1.setEditable(false);


        slovoZKategorie = slovoZKategorie.toUpperCase();
        char[] slovo1 = slovoZKategorie.toCharArray();
        this.kontrola.pridajSlovo(slovo1);
        this.slovo.pocetCiar(this.kontrola.getPocetZnakovSlova());
    }


    public void hadaj(char znak) {
        try {
            if (!this.kontrola.hadajPismeno(znak)) {
                this.hangman.vykresliCast();

                this.klavesnica.setColorOfButton(znak, false);
            } else {

                for (int i = 0; i < this.kontrola.getSuradnice().length; i++) { //7

                    if (this.kontrola.getSuradnice()[i] == 1) {
                        this.slovo.pridajUhadnutyZnak(znak, i);

                    }
                }
                this.kontrola.uhadol();
                this.klavesnica.setColorOfButton(znak, true);

            }
        } catch (IOException ex) {
            Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ukazHladaneSlovo() {
        this.jTextField1.setText("Hladane slovo bolo: " + this.kontrola.getHadaneSlovo());
        this.jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
        this.jTextField1.setVisible(true);
        this.jTextField1.setEditable(false);
    }

    public void koniecHry() {
        this.koniec = true;
        this.start();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Obesenec");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(765, 490));
        setPreferredSize(new java.awt.Dimension(765, 490));
        setResizable(false);
        setSize(new java.awt.Dimension(765, 490));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Ukončiť");
        jButton1.addActionListener(evt -> jButton1ActionPerformed());
        jPanel2.add(jButton1, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(490, 140, 250, 300);

        jPanel3.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 0));
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 0, 470, 270);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(0, 300, 470, 2);

        jTextField1.addActionListener(evt -> jTextField1ActionPerformed());
        jPanel3.add(jTextField1);
        jTextField1.setBounds(0, 270, 470, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 300, 470, 130);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 10, 470, 430);

        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel5);
        jPanel5.setBounds(490, 10, 250, 120);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 750, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed() {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.jButton1.getText().equals("Ukončiť")) {
            try {
                this.menu.zobraz();
                super.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        if (this.jButton1.getText().equals("Spať do menu")) {
            try {
                this.menu.zobraz();
                super.dispose();

            } catch (InterruptedException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed() {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Hra().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables


}
