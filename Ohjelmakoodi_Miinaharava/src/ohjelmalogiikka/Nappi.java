
package ohjelmalogiikka;

/**
 * Luokka kuvaa kaikkia pelissä olevia nappeja, eli paikkoja joista voidaan kaivaa. 
 * Jokaisella Napilla on koodinaattien lisäksi tieto siitä, onko Nappi näkyvä, ja onko siihen asetettu lippu.
 * Lisäksi Napeilla on piilotettu teksti, joka näkyy, kun Nappi on näkyvä. Luokka Nappi on yliluokka luokille Miina ja EiMiina.
 * @author Cadaei
 */
public class Nappi {
    private int xkoordinaatti;
    private int ykoordinaatti;
    private Boolean onNakyva;
    private Boolean lipullinen;
    private String piilotettuTeksti;

    /**
     * Konsturktori ohjelman testausta varten. Konstruktori luo uuden napin, annettujen koordinaattien osoittamaan paikkaan.
     * @param xkoordinaatti Napin x-koordinaatti
     * @param ykoordinaatti Napin y-koordinaatti
     */
    public Nappi(int xkoordinaatti, int ykoordinaatti) {
        this.xkoordinaatti = xkoordinaatti;
        this.ykoordinaatti = ykoordinaatti;
        this.onNakyva = false;
        this.lipullinen=false;
        this.piilotettuTeksti="O";
    }
    /**
     * Konstruktori, joka luo uuden Napin, jonka piilotettu teksti on annettu
     * @param xkoordinaatti Napin x-koordinaatti
     * @param ykoordinaatti Napin y-koordinaatti
     * @param piilotettuTeksti Napin piilotettu teksti
     */

    public Nappi(int xkoordinaatti, int ykoordinaatti, String piilotettuTeksti) {
        this.xkoordinaatti = xkoordinaatti;
        this.ykoordinaatti = ykoordinaatti;
        this.onNakyva = false;
        this.lipullinen=false;
        this.piilotettuTeksti = piilotettuTeksti;
    }
    
    /**
     * Metodi, joka laskee kahden Napin etäisyyksien neliön Pythagoraan lauseen avulla
     * @param nappi Nappi, jonka etäisyys kyseisestä napista lasketaan
     * @return nappien etäisyyden neliö
     */
    public int etaisyydenNelio(Nappi nappi) {
        return (this.xkoordinaatti-nappi.xkoordinaatti)*(this.xkoordinaatti-nappi.xkoordinaatti)
                + (this.ykoordinaatti-nappi.ykoordinaatti)*(this.ykoordinaatti-nappi.ykoordinaatti);
    }
    
    public void setPiilotettuTeksti(String piilotettuTeksti) {
        this.piilotettuTeksti = piilotettuTeksti;
    }
    
    public void teeNakyvaksi() {
        this.onNakyva = true;
    }

    public int xKoordinaatti() {
        return xkoordinaatti;
    }

    public int yKoordinaatti() {
        return ykoordinaatti;
    }

    public Boolean onNakyva() {
        return onNakyva;
    }
    
    public boolean eiMiinojaYmparilla() {
        return this.piilotettuTeksti.equals("0");
    }
    
    public Boolean onMiina() {
        return this.piilotettuTeksti.equals("M");
    }

    public String getPiilotettuTeksti() {
        return piilotettuTeksti;
    }
    
    /**
     * Metodi, joka lisää tai poistaa lipun napista riippuen siitä, onko napissa lippua. 
     */
    public void lisaaLippu() {
        if(this.lipullinen) {
            this.lipullinen=false;
        } else {
            this.lipullinen=true;
        }
    }

    public boolean onLipullinen() {
        return lipullinen;
    }
    
    public void lisaaMiinaViereen() {}
    
    @Override
    public String toString() {
        if(!onNakyva) {
            if(lipullinen) {
                return "L";
            }
            return "X";
        }
        return this.piilotettuTeksti;
    }
}
