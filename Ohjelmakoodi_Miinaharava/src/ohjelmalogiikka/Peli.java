
package ohjelmalogiikka;

/**
 * Luokka kuvaa Miinaharavapelin ohjelmalogiikkaa. Alussa luodaan pelin kenttä, ja jatkossa ylläpidetään peliä.
 * @author Cadaei
 */
public class Peli {
    private Kentta kentta;
    private boolean onKaynnissa;
    private int miinojaJaljella;

    public Peli(Asetukset asetukset) {
        this.kentta = new Kentta(asetukset);
        this.onKaynnissa = true;
        this.miinojaJaljella = asetukset.getMiinoja();
    }
    
    /*
     * Metodi päivittää jäljelläolevien miinojen lukumäärää.
     * @param nappi nappi, johon lippu on lisätty
     */
    public void lippuLisatty(Nappi nappi) {
        if(nappi.onLipullinen()) {
            miinojaJaljella--;
        } else {
            miinojaJaljella++;
        }
    }
    
    /*
     * Metodi tarkistaa, onko peli käynnissä, kun annetun napin paikasta on kaivettu
     * @param nappi nappi, jonka osoittamasta paikasta on kaivettu
     */
    public void kaivettu(Nappi nappi) {
        if(nappi.onMiina()) {
            lopetaPeli();
        }
    }
    
    public boolean onVoitettu() {
        return kentta.kenttaSelva();
    }

    public Kentta getKentta() {
        return kentta;
    }
    
    public void lopetaPeli() {
        this.onKaynnissa=false;
    }
    
    public boolean onKaynnissa() {
        return this.onKaynnissa;
    }
    
    public int miinojaJaljella() {
        return this.miinojaJaljella;
    }
    
    public int kentanLeveys() {
        return this.kentta.leveys();
    }
    
    public int kentanKorkeus() {
        return this.kentta.korkeus();
    }
}
