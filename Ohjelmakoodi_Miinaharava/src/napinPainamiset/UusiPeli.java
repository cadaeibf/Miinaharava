
package napinPainamiset;

import grafiikka.GraafinenKentta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tapahtumankuuntelija graafisen kentän napille, jonka painaminen aloittaa uuden pelin.
 * @author Cadaei
 */
public class UusiPeli implements ActionListener {
    private GraafinenKentta graafinenKentta;

    public UusiPeli(GraafinenKentta graafinenKentta) {
        this.graafinenKentta = graafinenKentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.graafinenKentta.uusiPeli();
    }
    
}
