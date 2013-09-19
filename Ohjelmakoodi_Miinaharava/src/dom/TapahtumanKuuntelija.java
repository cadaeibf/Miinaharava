
package dom;

import grafiikka.GraafinenNappi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TapahtumanKuuntelija implements ActionListener {
    private GraafinenNappi graafinenNappi;

    @Override
    public void actionPerformed(ActionEvent e) {
        graafinenNappi.getPainike().setText(graafinenNappi.getNappi().getPiilotettuTeksti());
    }
    
}
