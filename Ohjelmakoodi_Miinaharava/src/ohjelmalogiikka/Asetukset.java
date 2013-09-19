
package ohjelmalogiikka;

public class Asetukset {
    private int kentanLeveys;
    private int kentanKorkeus;
    private int miinoja;

    public Asetukset(int kentanLeveys, int kentanKorkeus, int miinoja) {
        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.miinoja = miinoja;
    }

    public void setKentanKorkeus(int kentanKorkeus) {
        this.kentanKorkeus = kentanKorkeus;
    }

    public void setKentanLeveys(int kentanLeveys) {
        this.kentanLeveys = kentanLeveys;
    }

    public void setMiinoja(int miinoja) {
        this.miinoja = miinoja;
    }

    public int getKentanKorkeus() {
        return kentanKorkeus;
    }

    public int getKentanLeveys() {
        return kentanLeveys;
    }

    public int getMiinoja() {
        return miinoja;
    }
    
    
}
