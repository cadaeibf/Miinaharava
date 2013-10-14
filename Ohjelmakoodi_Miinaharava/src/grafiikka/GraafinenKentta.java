
package grafiikka;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import napinPainamiset.UusiPeli;
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Peli;

/**
 * Luokka, joka konstruoi ja ylläpitää pelin graafista käyttöliittymää.
 * @author Cadaei
 */
public class GraafinenKentta {
    private Container container;
    private Napisto napisto;
    private Asetukset asetukset;
    private JButton uusiPeli;
    private JLabel miinojaJaljella;
    
    
    public GraafinenKentta(Asetukset asetukset, Container container) {
        this.asetukset = asetukset;
        this.container = container;
        luoPeli();
    }
    
    private void luoPeli() {
        this.napisto = new Napisto(this, new Peli(asetukset));
        
        container.add(napisto.getJPanel(), BorderLayout.CENTER);
        container.add(luoYlapalkki(), BorderLayout.NORTH);
    }
    
    public void uusiPeli() {
        container.removeAll();
        container.revalidate();
        container.repaint();
        luoPeli();
    }
    
    private JPanel luoYlapalkki() {
        JPanel ylapalkki = new JPanel();
        this.uusiPeli = new JButton(":D");
        uusiPeli.addActionListener(new UusiPeli(this));
        this.miinojaJaljella = new JLabel(""+napisto.miinojaJaljella());
        
        ylapalkki.setLayout(new GridLayout(1,9));
        
        for (int i = 0; i < 9; i++) {
            if(i==4) {
                ylapalkki.add(uusiPeli);
            } else {
                ylapalkki.add(new JLabel());
            }
            if(i == 8) {
                ylapalkki.add(this.miinojaJaljella);
            }
        }
        return ylapalkki;
    }
    
    public void lippu(GraafinenNappi graafinenNappi) {
        napisto.lippu(graafinenNappi);
        
        miinojaJaljella.setText(""+napisto.miinojaJaljella());
        if(napisto.peliVoitettu()) {
            voitto();
        }
    }
    
    public void kaiva(GraafinenNappi graafinenNappi) {
        napisto.kaiva(graafinenNappi);
        if(napisto.peliVoitettu()) {
            voitto();
        } else if(!napisto.peliKaynnissa()) {
            havio();
        }
    }
    
    public void kaivaYmparilta(GraafinenNappi graafinenNappi) {
        napisto.kaivaYmparilta(graafinenNappi);
        if(napisto.peliVoitettu()) {
            voitto();
        } else if(!napisto.peliKaynnissa()) {
            havio();
        }
    }
    
    public void voitto() {
        napisto.voitto();
        miinojaJaljella.setText(""+napisto.miinojaJaljella());
        uusiPeli.setText("B-)");
    }
    
    public void havio() {
        uusiPeli.setText("X/");
        napisto.naytaMiinat();
    }

    public Asetukset getAsetukset() {
        return asetukset;
    }

    public Napisto getNapisto() {
        return napisto;
    }
    
    
    
}
