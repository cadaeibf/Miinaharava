
package ohjelmalogiikka;
/**
 * Luokan Nappi aliluokka, joka kuvaa Nappeja, jotka eivät ole Miinoja. EiMiinat tietävät ympärillänsä olevien miinojen lukumäärän.
 * @author Cadaei
 */
public class EiMiina extends Nappi {
    private int xkoordinaatti;
    private int ykoordinaatti;
    private Boolean onNakyva;
    private Boolean lipullinen;
    private String piilotettuTeksti;
    private int miinojaYmparilla;

    /**
     * Luo uuden EiMiinan annettujen koordinaattien sijaintiin, ja alustaa ympärillä olevien miinojen määrän nollaksi.
     * @param xkoordinaatti EiMiinan leveyskoordinaatti pelikentällä
     * @param ykoordinaatti EiMiinan korkeuskoordinaatti pelikentällä
     */
    public EiMiina(int xkoordinaatti, int ykoordinaatti) {
        super(xkoordinaatti, ykoordinaatti, 0+"");
        
    }
    /**
     * Kasvattaa ympärillä olevien miinojen määrää yhdellä.
     */
    @Override
    public void lisaaMiinaViereen() {
        this.miinojaYmparilla++;
        setPiilotettuTeksti(this.miinojaYmparilla+"");
    }

    public int getMiinojaYmparilla() {
        return miinojaYmparilla;
    }
}
