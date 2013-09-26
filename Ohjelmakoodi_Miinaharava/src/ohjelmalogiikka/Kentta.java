
package ohjelmalogiikka;

import java.util.ArrayList;
import java.util.Random;
/**
 * Luokka, joka hallinnoi pelin Nappeja
 * @author Cadaei
 */
public class Kentta {
    private Asetukset asetukset;
    private ArrayList<Nappi> napit;
    private ArrayList<Nappi> miinat;
    
    /**
     * Konstruktori luo uuden kentän parametrina annettujen asetusten perusteella. 
     * Kentän napit säilötään yksiulotteiseen taulukkoon järjestämällä ne rivi kerrallaan.
     * @param asetukset Pelin asetukset
     */
    public Kentta(Asetukset asetukset) {
        this.asetukset = asetukset;
        this.napit = new ArrayList();
        this.miinat = new ArrayList();
        sijoitaNapit();
        kasvataMiinaLkm();
    }
    
    /**
     * Metodi kasvattaa kaikkien Miinojen ympärillä olevien EiMiinojen lukumäärää metodin lisaaMiinaViereen avulla
     */
    public void kasvataMiinaLkm() {
        for (Nappi nappi : napit) {
            if(nappi.getPiilotettuTeksti().equals("M")) {
                lisaaMiinaViereen(nappi.getXkoordinaatti(), nappi.getYkoordinaatti());
            }
        }
    }
    
    /**
     * Metodi arpoo annetun määrän verran eri koordinaatteja
     * @param koordinaatteja Annettu määrä jonka verran eri koordinaatteja arvotaan
     * @return lista arvotuista koordinaateista muunnettuna yksiulotteisen taulukon indekseiksi
     */
    public ArrayList<Integer> arvoEriKoordinaatteja(int koordinaatteja) {
        ArrayList<Integer> koordinaatit = new ArrayList();
        Random random = new Random();
        int koordinaatti=-1;
        
        for (int i = 0; i < koordinaatteja; i++) {
            koordinaatti=random.nextInt(asetukset.getKentanKorkeus()*asetukset.getKentanLeveys());
            while(koordinaatit.contains(koordinaatti)) {
                koordinaatti=random.nextInt(asetukset.getKentanKorkeus()*asetukset.getKentanLeveys());
            }
            koordinaatit.add(koordinaatti);
        }
        
        return koordinaatit;
    }
    
    /**
     * Metodi sijoittaa uudet napit kentälle
     */
    public void sijoitaNapit() {
        int x=0;
        int y=0;
        ArrayList<Integer> miinojenKoodinaatit=arvoEriKoordinaatteja(asetukset.getMiinoja());
        
        for (int i = 0; i < asetukset.getKentanKorkeus()*asetukset.getKentanLeveys(); i++) {
            if(miinojenKoodinaatit.contains(i)) {
                napit.add(new Miina(x,y));
                miinat.add(napit.get(napit.size()-1));
            } else {
                napit.add(new EiMiina(x,y));
            }
            x++;
            if(x==asetukset.getKentanLeveys()) {
                x=0;
                y++;
            }
        }
    }
    
    /**
     * Muuttaa annetussa koordinaatissa olevan napin näkyvyyden.
     * @param x kaivettavan paikan x-koordinaatti
     * @param y kaivettavan paikan y-koordinaatti
     * @return totuusarvo siitä, jatkuuko peli vai ei
     */
    public boolean kaiva(int x, int y) {
        nappiKoordinaatissa(x, y).teeNakyvaksi();
        
        if(nappiKoordinaatissa(x, y).getPiilotettuTeksti().equals("M")) {
            return false;
        }
        
        return true;
    }
    
    public boolean lippu(int x, int y) {
        return nappiKoordinaatissa(x, y).lippu();
    }
    
    public void lisaaMiinaViereen(int x, int y) {
        for (Nappi nappi : ymparillaOlevat(x, y)) {
            nappi.lisaaMiinaViereen();
        }
    }
    
    /**
     * Apumetodi, joka palauttaa jossain koordinaatissa olevan napin ympärillä olevat napit listana
     * @param xKoordinaatti kysytyn napin x-koordinaatti
     * @param yKoordinaatti kysytyn napin y-koordinaatti
     * @return lista kysytyn napin ympärillä olevista napeista
     */
    public ArrayList<Nappi> ymparillaOlevat(int xKoordinaatti, int yKoordinaatti) {
        ArrayList<Nappi> ymparillaOlevat = new ArrayList();
        int indeksi = xKoordinaatti + yKoordinaatti * asetukset.getKentanLeveys();
        
        if(xKoordinaatti != 0) {
            ymparillaOlevat.add(napit.get(indeksi-1));
            if(yKoordinaatti != 0) {
                ymparillaOlevat.add(napit.get(indeksi-asetukset.getKentanLeveys()-1));
            }
            if(yKoordinaatti != this.asetukset.getKentanKorkeus()-1) {
                ymparillaOlevat.add(napit.get(indeksi+asetukset.getKentanLeveys()-1));
            }
        }
        if(xKoordinaatti != this.asetukset.getKentanLeveys()-1) {
            ymparillaOlevat.add(napit.get(indeksi+1));
            if(yKoordinaatti != 0) {
                ymparillaOlevat.add(napit.get(indeksi-asetukset.getKentanLeveys()+1));
            }
            if(yKoordinaatti != this.asetukset.getKentanKorkeus()-1) {
                ymparillaOlevat.add(napit.get(indeksi+asetukset.getKentanLeveys()+1));
            }
        }
        if(yKoordinaatti != 0) {
            ymparillaOlevat.add(napit.get(indeksi-asetukset.getKentanLeveys()));
        }
        if(yKoordinaatti != asetukset.getKentanKorkeus()-1) {
            ymparillaOlevat.add(napit.get(indeksi+asetukset.getKentanLeveys()));
        }
        
        return ymparillaOlevat;
    }
    
    public Nappi nappiKoordinaatissa(int x, int y) {
        return this.napit.get(x+y*asetukset.getKentanLeveys());
    }

    public ArrayList<Nappi> getMiinat() {
        return miinat;
    }

    public ArrayList<Nappi> getNapit() {
        return napit;
    }
    
    /**
     * Metodi, joka palauttaa totuusarvon siitä, onko kaikki napit näkyviä ja kaikki miinat lipullisia
     * @return onko kaikki napit näkyviä
     */
    public boolean kaikkiNapitNakyvia() {
        for (Nappi nappi : napit) {
            if(!nappi.getOnNakyva()&&nappi.getPiilotettuTeksti()!="M") {
                return false;
            }
        }
        for (Nappi nappi : miinat) {
            if(!nappi.getLipullinen()) {
                return false;
            }
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        String tulostus = "";
        
        for (Nappi nappi : napit) {
            tulostus+=nappi.toString();
            if(nappi.getXkoordinaatti()==asetukset.getKentanLeveys()-1) {
                tulostus += "\n";
            }
        }
        
        return tulostus;
    }
    
}
