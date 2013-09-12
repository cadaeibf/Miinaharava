
package src;

import java.util.ArrayList;
import java.util.Random;

public class Kentta {
    int korkeus;
    int leveys;
    private ArrayList<Nappi> napit;

    public Kentta(int leveys, int korkeus) {
        this.napit = new ArrayList();
        this.korkeus = korkeus;
        this.leveys = leveys;
        int x=0;
        int y=0;
        
        for (int i = 0; i < korkeus*leveys; i++) {
            napit.add(new Nappi(x,y));
            x++;
            if(x==leveys) {
                x=0;
                y++;
            }
        }
    }
    
    public Kentta(int leveys, int korkeus, int miinoja) {
        this.napit = new ArrayList();
        this.korkeus = korkeus;
        this.leveys = leveys;
        int x=0;
        int y=0;
        Random random = new Random();
        
        for (int i = 0; i < korkeus*leveys; i++) {
            napit.add(new EiMiina(x,y));
            x++;
            if(x==leveys) {
                x=0;
                y++;
            }
        }
    }
    
    public ArrayList<Integer> arvoEriKoordinaatteja(int koordinaatteja) {
        ArrayList<Integer> koordinaatit = new ArrayList();
        
        
        return koordinaatit;
    }
    
    public void kaiva(int xKoordinaatti, int yKoordinaatti) {
        Nappi kaivettava = this.napit.get(xKoordinaatti+yKoordinaatti*this.leveys);
        kaivettava.teeNakyvaksi();
    }
    
    public void lisaaMiinaViereen(int x, int y) {
        for (Nappi nappi : ymparillaOlevat(x, y)) {
            nappi.lisaaMiinaViereen();
        }
    }
    
    public ArrayList<Nappi> ymparillaOlevat(int xKoordinaatti, int yKoordinaatti) {
        ArrayList<Nappi> ymparillaOlevat = new ArrayList();
        int indeksi = xKoordinaatti + yKoordinaatti * this.leveys;
        
        if(xKoordinaatti != 0) {
            ymparillaOlevat.add(napit.get(indeksi-1));
            if(yKoordinaatti != 0) {
                ymparillaOlevat.add(napit.get(indeksi-leveys-1));
            }
            if(yKoordinaatti != this.korkeus-1) {
                ymparillaOlevat.add(napit.get(indeksi+leveys-1));
            }
        }
        if(xKoordinaatti != this.leveys-1) {
            ymparillaOlevat.add(napit.get(indeksi+1));
            if(yKoordinaatti != 0) {
                ymparillaOlevat.add(napit.get(indeksi-leveys+1));
            }
            if(yKoordinaatti != this.korkeus-1) {
                ymparillaOlevat.add(napit.get(indeksi+leveys+1));
            }
        }
        if(yKoordinaatti != 0) {
            ymparillaOlevat.add(napit.get(indeksi-leveys));
        }
        if(yKoordinaatti != this.korkeus-1) {
            ymparillaOlevat.add(napit.get(indeksi+leveys));
        }
        
        return ymparillaOlevat;
    }
    
    @Override
    public String toString() {
        String tulostus = "";
        
        for (Nappi nappi : napit) {
            tulostus+=nappi.toString();
            if(nappi.getXkoordinaatti()==leveys-1) {
                tulostus += "\n";
            }
        }
        
        return tulostus;
    }
    
}
