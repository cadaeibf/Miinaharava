
package napinPainamiset;

import grafiikka.GraafinenKentta;
import grafiikka.GraafinenNappi;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class HiirenKuuntelija extends MouseAdapter {
    private GraafinenNappi graafinenNappi;
    private GraafinenKentta graafinenKentta;

    public HiirenKuuntelija(GraafinenKentta graafinenKentta, GraafinenNappi graafinenNappi) {
        this.graafinenKentta = graafinenKentta;
        this.graafinenNappi = graafinenNappi;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)) {
            graafinenKentta.kaiva(graafinenNappi);
        }
        if(SwingUtilities.isRightMouseButton(e)) {
            graafinenKentta.lippu(graafinenNappi);
        }
        if(SwingUtilities.isMiddleMouseButton(e)) {
            graafinenKentta.kaivaYmparilta(graafinenNappi);
        }
    }
}
