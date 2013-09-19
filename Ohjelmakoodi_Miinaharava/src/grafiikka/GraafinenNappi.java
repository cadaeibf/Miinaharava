
package grafiikka;

import javax.swing.JButton;
import ohjelmalogiikka.Nappi;

public class GraafinenNappi {
    private JButton painike;
    private Nappi nappi;

    public GraafinenNappi(Nappi nappi) {
        this.nappi =nappi;
    }

    public Nappi getNappi() {
        return nappi;
    }

    public JButton getPainike() {
        return painike;
    }
    
    
}
