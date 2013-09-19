
package main;

import grafiikka.GraafinenNappi;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Nappi;
import ohjelmalogiikka.Peli;

class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Asetukset asetukset;
    private Peli peli;
    
    public Kayttoliittyma(Asetukset asetukset) {
        this.asetukset=asetukset;
    }
    
    @Override
    public void run() {
        peli=new Peli(asetukset);
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(50*asetukset.getKentanLeveys(),50*asetukset.getKentanKorkeus()));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(asetukset.getKentanLeveys(),asetukset.getKentanKorkeus()));
        for (int i = 0; i < asetukset.getKentanLeveys()*asetukset.getKentanKorkeus(); i++) {
            container.add(new JButton());
        }
    }
    
}
