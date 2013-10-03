
package main;

import grafiikka.GraafinenKentta;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import ohjelmalogiikka.Asetukset;

/**
 * Luokka, joka luo ja ylläpitää uutta graafista käyttöliittymää
 * @author Cadaei
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Asetukset asetukset;
    private GraafinenKentta kentta;
    
    /**
     * luo uuden käyttöliittymän annettujen asetusten perusteella
     * @param asetukset annetut asetukset
     */
    public Kayttoliittyma(Asetukset asetukset) {
        this.asetukset = asetukset;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(25*asetukset.getKentanLeveys(),25*asetukset.getKentanKorkeus()));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        this.kentta = new GraafinenKentta(asetukset, container);
    }
    
}
