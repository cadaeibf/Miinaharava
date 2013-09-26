
package ohjelmalogiikka;

/**
 * Luokka hallinnoi kulloisenkin pelin asetuksia
 * @author Cadaei
 */

public class Asetukset {
    private int kentanLeveys;
    private int kentanKorkeus;
    private int miinoja;

    /**
     * Luo uudet asetukset käyttäjän antamien, tai oletusarvoisten asetusten perusteella
     * @param kentanLeveys Määrittää pelin kentän leveyden
     * @param kentanKorkeus Määrittää pelin kentän korkeuden
     * @param miinoja  Määrittää pelin miinojen lukumäärän
     */
    public Asetukset(int kentanLeveys, int kentanKorkeus, int miinoja) {
        if(miinoja>kentanLeveys*kentanKorkeus) {
            throw new IllegalArgumentException();
        }
        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.miinoja = miinoja;
    }

    public int getKentanKorkeus() {
        return kentanKorkeus;
    }
    /**
     * Metodi palauttaa kentän leveyden asetusksista muille luokille
     * @return kentän leveys
     */
    
    public int getKentanLeveys() {
        return kentanLeveys;
    }
    /**
     * Metodi palauttaa pelin miinojen lukumäärän asetuksista muille luokille
     * @return miinojen lukumäärä
     */

    public int getMiinoja() {
        return miinoja;
    }
    
    
}
