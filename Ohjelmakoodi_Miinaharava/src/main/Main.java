
package main;

import javax.swing.SwingUtilities;
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Peli;

public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Asetukset(10,8,5));
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
