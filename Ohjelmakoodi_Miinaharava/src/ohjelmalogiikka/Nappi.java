
package ohjelmalogiikka;

import java.awt.List;

public class Nappi {
    private int xkoordinaatti;
    private int ykoordinaatti;
    private Boolean onNakyva;
    private Boolean lipullinen;
    private String piilotettuTeksti;

    public Nappi(int xkoordinaatti, int ykoordinaatti) {
        this.xkoordinaatti = xkoordinaatti;
        this.ykoordinaatti = ykoordinaatti;
        this.onNakyva = false;
        this.lipullinen=false;
        this.piilotettuTeksti="O";
    }

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
