
package napinPainamiset;

import grafiikka.GraafinenKentta;
import grafiikka.GraafinenNappi;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HiirenKuuntelija extends MouseAdapter {
    private GraafinenNappi graafinenNappi;
    private GraafinenKentta graafinenKentta;

    public HiirenKuuntelija(GraafinenKentta graafinenKentta, GraafinenNappi graafinenNappi) {
        this.graafinenKentta = graafinenKentta;
        this.graafinenNappi = graafinenNappi;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) {
            graafinenKentta.kaiva(graafinenNappi);
        }
        if(e.getButton() == MouseEvent.BUTTON3) {
            graafinenKentta.lippu(graafinenNappi);
        }
    }
}
