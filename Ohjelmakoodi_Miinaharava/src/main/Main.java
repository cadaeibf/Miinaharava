
package main;

import javax.swing.SwingUtilities;
import ohjelmalogiikka.Asetukset;

/**
 * Pääluokka käynnistää ohjelman kutsumalla graafista käyttöliittymää
 * @author Cadaei
 */
public class Main {

    public static void main(String[] args) {
        AsetuksetRuutu asetuksetRuutu = new AsetuksetRuutu();
        asetuksetRuutu.run();
        
//        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Asetukset(40,32,200));
//        SwingUtilities.invokeLater(kayttoliittyma);
        
    }
}
