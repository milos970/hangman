/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panely;

import enumy.Farba;
import gui.Hra;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Miloš
 */
public class PanelKlavesnica extends javax.swing.JPanel implements IPanely {
    private final Hra hra;
    /**
     * Creates new form Klavesnica
     * @param hra
     */
    public PanelKlavesnica(Hra hra) {
        this.hra = hra;
        super.setVisible(false);
        super.setBackground(Farba.ZLTA.getFarba());
        Dimension dimension = new Dimension(0, 0);
        super.setPreferredSize(dimension);
        this.initComponents();
    }
    
    
    @Override
    public void zobraz() {
        
        this.povolVsetkyTlacidla();
        
        super.setVisible(true);
    }
    
    /**
     * sprístupní všetky odkliknuté buttony
     * nastaví ich farbu
     */
    private void povolVsetkyTlacidla() {
        JButton button = null;
        Component[] components = this.getComponents();
        for (int i = 0; i < 26; i++) {
            if (components[i].getClass().equals(JButton.class) ) {
                components[i].setEnabled(true);
                components[i].setBackground(Farba.BIELA.getFarba());
                
            } 
        }
        
        
    }
    
    /**
     * zmení farbu kliknutého buttona 
     * podla správneho znaku
     * @param znak
     * @param spravneTlacidlo 
     */
    public void setColorOfButton(char znak, boolean spravneTlacidlo) {    
        switch (znak) {
            case 'A':
                if (!spravneTlacidlo) {
                    this.jButton1.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton1.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'B':
                if (!spravneTlacidlo) {
                    this.jButton2.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton2.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'C':
                if (!spravneTlacidlo) {
                    this.jButton3.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton3.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'D':
                if (!spravneTlacidlo) {
                    this.jButton4.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton4.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'E':
                if (!spravneTlacidlo) {
                    this.jButton5.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton5.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'F':
                if (!spravneTlacidlo) {
                    this.jButton6.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton6.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'G':
                if (!spravneTlacidlo) {
                    this.jButton7.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton7.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'H':
                if (!spravneTlacidlo) {
                    this.jButton8.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton8.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'I':
                if (!spravneTlacidlo) {
                    this.jButton9.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton9.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'J':
                if (!spravneTlacidlo) {
                    this.jButton10.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton10.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'K':
                if (!spravneTlacidlo) {
                    this.jButton11.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton11.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'L':
                if (!spravneTlacidlo) {
                    this.jButton12.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton12.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'M':
                if (!spravneTlacidlo) {
                    this.jButton13.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton13.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'N':
                if (!spravneTlacidlo) {
                    this.jButton14.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton14.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'O':
                if (!spravneTlacidlo) {
                    this.jButton15.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton15.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'P':
                if (!spravneTlacidlo) {
                    this.jButton16.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton16.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'Q':
                if (!spravneTlacidlo) {
                    this.jButton17.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton17.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'R':
                if (!spravneTlacidlo) {
                    this.jButton18.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton18.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'S':
                if (!spravneTlacidlo) {
                    this.jButton19.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton19.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'T':
                if (!spravneTlacidlo) {
                    this.jButton20.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton20.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'U':
                if (!spravneTlacidlo) {
                    this.jButton21.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton21.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'V':
                if (!spravneTlacidlo) {
                    this.jButton22.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton22.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'W':
                if (!spravneTlacidlo) {
                    this.jButton23.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton23.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'X':
                if (!spravneTlacidlo) {
                    this.jButton24.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton24.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'Y':
                if (!spravneTlacidlo) {
                    this.jButton25.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton25.setBackground(Farba.ZELENA.getFarba());
                }
                break;
                
            case 'Z':
                if (!spravneTlacidlo) {
                    this.jButton26.setBackground(Farba.CERVENA.getFarba());
                } else {
                    this.jButton26.setBackground(Farba.ZELENA.getFarba());
                }
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(470, 130));
        setMinimumSize(new java.awt.Dimension(470, 130));
        setOpaque(false);

        jButton1.setText("A");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);

        jButton2.setText("B");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);

        jButton3.setText("C");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);

        jButton4.setText("D");
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);

        jButton5.setText("E");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);

        jButton6.setText("F");
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);

        jButton7.setText("G");
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7);

        jButton8.setText("H");
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8);

        jButton9.setText("I");
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9);

        jButton10.setText("J");
        jButton10.setFocusPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        add(jButton10);

        jButton11.setText("K");
        jButton11.setFocusPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        add(jButton11);

        jButton12.setText("L");
        jButton12.setFocusPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        add(jButton12);

        jButton13.setText("M");
        jButton13.setFocusPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        add(jButton13);

        jButton14.setText("N");
        jButton14.setFocusPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        add(jButton14);

        jButton15.setText("O");
        jButton15.setFocusPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        add(jButton15);

        jButton16.setText("P");
        jButton16.setFocusPainted(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        add(jButton16);

        jButton17.setText("Q");
        jButton17.setFocusPainted(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        add(jButton17);

        jButton18.setText("R");
        jButton18.setFocusPainted(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        add(jButton18);

        jButton19.setText("S");
        jButton19.setFocusPainted(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        add(jButton19);

        jButton20.setText("T");
        jButton20.setFocusPainted(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        add(jButton20);

        jButton21.setText("U");
        jButton21.setFocusPainted(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        add(jButton21);

        jButton22.setText("V");
        jButton22.setFocusPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        add(jButton22);

        jButton23.setText("W");
        jButton23.setFocusPainted(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        add(jButton23);

        jButton24.setText("X");
        jButton24.setFocusPainted(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        add(jButton24);

        jButton25.setText("Y");
        jButton25.setFocusPainted(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        add(jButton25);

        jButton26.setText("Z");
        jButton26.setFocusPainted(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        add(jButton26);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jButton1.setEnabled(false);
        this.hra.hadaj('A');
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jButton2.setEnabled(false);
        this.hra.hadaj('B');
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jButton3.setEnabled(false);
        this.hra.hadaj('C');
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.jButton4.setEnabled(false);
        this.hra.hadaj('D');
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.jButton5.setEnabled(false);
        this.hra.hadaj('E');
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.jButton6.setEnabled(false);
        this.hra.hadaj('F');
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.jButton7.setEnabled(false);
        this.hra.hadaj('G');
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.jButton8.setEnabled(false);
        this.hra.hadaj('H');
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.jButton9.setEnabled(false);
        this.hra.hadaj('I');
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.jButton10.setEnabled(false);
        this.hra.hadaj('J');
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.jButton11.setEnabled(false);
        this.hra.hadaj('K');
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        this.jButton12.setEnabled(false);
        this.hra.hadaj('L');
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        this.jButton13.setEnabled(false);
        this.hra.hadaj('M');
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        this.jButton14.setEnabled(false);
        this.hra.hadaj('N');
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        this.jButton15.setEnabled(false);
        this.hra.hadaj('O');
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.jButton16.setEnabled(false);
        this.hra.hadaj('P');
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        this.jButton17.setEnabled(false);
        this.hra.hadaj('Q');
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        this.jButton18.setEnabled(false);
        this.hra.hadaj('R');
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        this.jButton19.setEnabled(false);
        this.hra.hadaj('S');
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        this.jButton20.setEnabled(false);
        this.hra.hadaj('T');
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        this.jButton21.setEnabled(false);
        this.hra.hadaj('U');
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        this.jButton22.setEnabled(false);
        this.hra.hadaj('V');
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        this.jButton23.setEnabled(false);
        this.hra.hadaj('W');
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        this.jButton24.setEnabled(false);
        this.hra.hadaj('X');
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        this.jButton25.setEnabled(false);
        this.hra.hadaj('Y');
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        this.jButton26.setEnabled(false);
        this.hra.hadaj('Z');
    }//GEN-LAST:event_jButton26ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables
}
