
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
        this.nappi =nappi;
        this.painike=new JButton();
    }

    public Nappi getNappi() {
        return nappi;
    }

    public JButton getPainike() {
        return painike;
    }
    
    
}
