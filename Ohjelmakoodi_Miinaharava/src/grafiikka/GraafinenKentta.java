
package grafiikka;

import dom.NapinPainaminen;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Kentta;
import ohjelmalogiikka.Nappi;
import ohjelmalogiikka.Peli;

/**
 * Kenttä-luokan graafinen toteutus
 * @author Cadaei
 */
public class GraafinenKentta {
    private Container container;
    private Peli peli;
    private Kentta kentta;
    private Asetukset asetukset;
    
    public GraafinenKentta(Peli peli, Container container, Asetukset asetukset) {
        this.peli = peli;
        this.asetukset=asetukset;
        kentta = new Kentta(asetukset);
        this.container=container;
        luoKentta();
    }
    
    public void luoKentta() {
        JPanel ylapalkki = new JPanel();
        ylapalkki.setLayout(new GridLayout(1,9));
        for (int i = 0; i < 9; i++) {
            if(i==4) {
                ylapalkki.add(new JButton(":D"));
            } else {
                ylapalkki.add(new JLabel());
            }
        }
        
        JPanel napisto = new JPanel();
        napisto.setLayout(new GridLayout(asetukset.getKentanKorkeus(),asetukset.getKentanLeveys()));
        for (Nappi nappi : kentta.getNapit()) {
            GraafinenNappi graafinenNappi = new GraafinenNappi(nappi);
            graafinenNappi.getPainike().addActionListener(new NapinPainaminen(peli, graafinenNappi));
            napisto.add(graafinenNappi.getPainike());
        }
        container.add(napisto, BorderLayout.CENTER);
        container.add(ylapalkki, BorderLayout.NORTH);
    } 
    
}
