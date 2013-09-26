
package ohjelmalogiikka;
/**
 * Luokan Nappi aliluokka, joka kuvaa Nappeja, jotka ovat Miinoja. Kun Miinan kohdasta kaivetaan peli loppuu.
 * @author Cadaei
 */
public class Miina extends Nappi {
    private int xkoordinaatti;
    private int ykoordinaatti;
    private Boolean onNakyva;
    private Boolean lipullinen;
    private String piilotettuTeksti;
    
    public Miina(int xkoordinaatti, int ykoordinaatti) {
        super(xkoordinaatti, ykoordinaatti, "M");
    }
}
