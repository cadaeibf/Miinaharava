
package grafiikka;

import javax.swing.JButton;
import ohjelmalogiikka.Nappi;

/**
 * Nappi-luokan graafinen toteutus.
 * @author Cadaei
 */
public class GraafinenNappi {
    private JButton painike;
    private Nappi nappi;

    public GraafinenNappi(Nappi nappi) {
        this.nappi = nappi;
        this.painike=new JButton(" ");
    }
    
    public void teeNakyvaksi() {
        this.nappi.teeNakyvaksi();
        painike.setText(this.nappi.toString());
    }
    
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
