
package napinPainamiset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import ohjelmalogiikka.Asetukset;
import main.Kayttoliittyma;

public class AsetustenLahettaminen implements ActionListener {
    private JTextArea x;
    private JTextArea y;
    private JTextArea miinoja;

    public AsetustenLahettaminen(JTextArea x, JTextArea y, JTextArea miinoja) {
        this.x = x;
        this.y = y;
        this.miinoja = miinoja;
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        int leveys = Integer.parseInt(x.getText());
        int korkeus = Integer.parseInt(y.getText());
        int miinojenLkm = Integer.parseInt(this.miinoja.getText());
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Asetukset(leveys,korkeus,miinojenLkm));
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
}
