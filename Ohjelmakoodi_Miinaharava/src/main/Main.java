
package main;

import javax.swing.SwingUtilities;
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Peli;

/**
 * Pääluokka käynnistää ohjelman kutsumalla graafista käyttöliittymää
 * @author Cadaei
 */
public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Asetukset(20,16,5));
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
