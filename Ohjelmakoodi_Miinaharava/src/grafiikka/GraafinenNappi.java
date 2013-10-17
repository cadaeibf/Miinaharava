
package grafiikka;

import javax.swing.JButton;
import ohjelmalogiikka.Nappi;

/**
 * Nappi-luokan graafinen toteutus. Luokka huolehtii pelitilanteen muutosten ilmoittamisesta ohjelmalogiikkaan Nappi-atribuutin avulla.
 * @author Cadaei
 */
public class GraafinenNappi {
    private JButton painike;
    private Nappi nappi;

    public GraafinenNappi(Nappi nappi) {
        this.nappi = nappi;
        this.painike=new JButton(" ");
    }
    
    /**
     * Metodi, asettaa muuttaa nappi-atribuutin näkyvyyttä, ja asettaa painikkeeseen napin mukaisen tekstin.
     */
    public void teeNakyvaksi() {
        this.nappi.teeNakyvaksi();
        painike.setText(this.nappi.toString());
    }
    
    /**
     * Metodi muuttaa painikkeen tekstiä tilanteen mukaisesti ja raportoi muutoksesta ohjelmalogiikkaan nappi-atribuutin välityksellä.
     */
    public void lisaaLippu() {
        if(this.onNakyva()) {
            return;
        }
        if(this.onLipullinen()) {
            this.painike.setText("");
        } else {
            this.painike.setText("L");
        }
        this.nappi.lisaaLippu();
    }
    
    public boolean eiMiinojaYmparilla() {
        return this.nappi.eiMiinojaYmparilla();
    }
    
    public boolean onLipullinen() {
        return this.nappi.onLipullinen();
    }
    
    public boolean onNakyva() {
        return this.nappi.onNakyva();
    }
    
    public boolean onMiina() {
        return this.nappi.onMiina();
    }

    public JButton getPainike() {
        return painike;
    }

    public Nappi getNappi() {
        return nappi;
    }

    @Override
    public String toString() {
        return this.nappi.toString();
    }
    
    
}
