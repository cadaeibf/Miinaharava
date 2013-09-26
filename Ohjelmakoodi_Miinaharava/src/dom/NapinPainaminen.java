
package dom;

import grafiikka.GraafinenNappi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ohjelmalogiikka.Peli;

public class NapinPainaminen implements ActionListener {
    private Peli peli;
    private GraafinenNappi graafinenNappi;

    public NapinPainaminen(Peli peli, GraafinenNappi graafinenNappi) {
        this.peli = peli;
        this.graafinenNappi = graafinenNappi;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        graafinenNappi.getPainike().setText(graafinenNappi.getNappi().getPiilotettuTeksti());
        if(graafinenNappi.getNappi().toString()=="M") {
            peli.lopetaPeli();
        }
    }
    
}
