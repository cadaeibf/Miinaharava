
package ohjelmalogiikka;

import java.awt.List;
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
     * @param xkoordinaatti
     * @param ykoordinaatti 
     */
    public Nappi(int xkoordinaatti, int ykoordinaatti) {
        this.xkoordinaatti = xkoordinaatti;
        this.ykoordinaatti = ykoordinaatti;
        this.onNakyva = false;
        this.lipullinen=false;
        this.piilotettuTeksti="O";
    }
    /**
     * 
     * @param xkoordinaatti
     * @param ykoordinaatti
     * @param piilotettuTeksti 
     */

    public Nappi(int xkoordinaatti, int ykoordinaatti, String piilotettuTeksti) {
        this.xkoordinaatti = xkoordinaatti;
        this.ykoordinaatti = ykoordinaatti;
        this.onNakyva = false;
        this.lipullinen=false;
        this.piilotettuTeksti = piilotettuTeksti;
    }
    
    
    
    public void setPiilotettuTeksti(String piilotettuTeksti) {
        this.piilotettuTeksti = piilotettuTeksti;
    }
    
    public void teeNakyvaksi() {
        this.onNakyva = true;
    }

    public int getXkoordinaatti() {
        return xkoordinaatti;
    }

    public int getYkoordinaatti() {
        return ykoordinaatti;
    }

    public Boolean getOnNakyva() {
        return onNakyva;
    }

    public String getPiilotettuTeksti() {
        return piilotettuTeksti;
    }
    
    public boolean lippu() {
        if(this.lipullinen) {
            this.lipullinen=false;
            return false;
        } else {
            this.lipullinen=true;
            return true;
        }
    }

    public Boolean getLipullinen() {
        return lipullinen;
    }
    
    
    
    public void lisaaMiinaViereen() {
        
    }
    
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
