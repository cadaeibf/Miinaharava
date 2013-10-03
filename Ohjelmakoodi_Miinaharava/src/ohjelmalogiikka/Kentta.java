
package ohjelmalogiikka;

import java.util.ArrayList;
import java.util.Random;
/**
 * Luokka, joka konstruoi pelin alussa nappien sijainnit, ja tarkistaa pelin aikana pelitilanteen
 * @author Cadaei
 */
public class Kentta {
    private ArrayList<Nappi> napit;
    private int leveys;
    private int korkeus;
    
    /**
     * Konstruktori luo uuden kentän parametrina annettujen asetusten perusteella. 
     * Kentän napit säilötään yksiulotteiseen taulukkoon järjestämällä ne rivi kerrallaan.
     * @param asetukset Pelin asetukset
     */
    public Kentta(Asetukset asetukset) {
        this.napit = new ArrayList();
        this.leveys = asetukset.getKentanLeveys();
        this.korkeus = asetukset.getKentanKorkeus();
        sijoitaNapit(asetukset);
        kasvataMiinaLkm();
    }
    
    /**
     * Metodi kasvattaa kaikkien Miinojen ympärillä olevien EiMiinojen lukumäärää metodin lisaaMiinaViereen avulla
     */
    private void kasvataMiinaLkm() {
        for (Nappi nappi : napit) {
            if(nappi.onMiina()) {
                lisaaMiinaViereen(nappi);
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
        int koordinaatti;
        
        for (int i = 0; i < koordinaatteja; i++) {
            koordinaatti=random.nextInt(korkeus*leveys);
            while(koordinaatit.contains(koordinaatti)) {
                koordinaatti=random.nextInt(korkeus*leveys);
            }
            koordinaatit.add(koordinaatti);
        }
        
        return koordinaatit;
    }
    
    /**
     * Metodi arpoo miinojen sijainnit ja sijoittaa uudet napit kentälle.
     * @param asetukset asetukset, joiden mukaan miinoja arvotaan
     */
    private void sijoitaNapit(Asetukset asetukset) {
        int x=0;
        int y=0;
        ArrayList<Integer> miinojenKoodinaatit = arvoEriKoordinaatteja(asetukset.getMiinoja());
        
        for (int i = 0; i < asetukset.getKentanKorkeus()*asetukset.getKentanLeveys(); i++) {
            if(miinojenKoodinaatit.contains(i)) {
                napit.add(new Miina(x,y));
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
    
    public void lisaaMiinaViereen(Nappi nappi) {
        for (Nappi ymparilla : ymparillaOlevat(nappi)) {
            ymparilla.lisaaMiinaViereen();
        }
    }
    
    /**
     * Apumetodi, joka palauttaa jossain koordinaatissa olevan napin ympärillä olevat napit listana
     * @param nappi kysytty nappi
     * @return lista kysytyn napin ympärillä olevista napeista
     */
    public ArrayList<Nappi> ymparillaOlevat(Nappi nappi) {
        ArrayList<Nappi> ymparillaOlevat = new ArrayList();
        
        for (Nappi nappi1 : napit) {
            if(nappi.etaisyydenNelio(nappi1)<3) {
                ymparillaOlevat.add(nappi1);
            }
        }
        ymparillaOlevat.remove(nappi);
        
        return ymparillaOlevat;
    }
    
    public Nappi nappiKoordinaatissa(int x, int y) {
        return this.napit.get(x+y*leveys);
    }

    public ArrayList<Nappi> getNapit() {
        return napit;
    }

    public int leveys() {
        return leveys;
    }
    
    public int korkeus() {
        return korkeus;
    }
    
    /**
     * Metodi, joka palauttaa totuusarvon siitä, onko kaikki napit näkyviä ja kaikki miinat lipullisia
     * @return onko kaikki napit näkyviä
     */
    public boolean kenttaSelva() {
        for (Nappi nappi : napit) {
            if(!nappi.onMiina() && !nappi.onNakyva()) {
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
            if(nappi.xKoordinaatti()== leveys-1) {
                tulostus += "\n";
            }
        }
        
        return tulostus;
    }
    
}
