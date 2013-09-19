
package ohjelmalogiikka;

import java.util.ArrayList;
import java.util.Random;

public class Kentta {
    private int korkeus;
    private int leveys;
    private ArrayList<Nappi> napit;
    private ArrayList<Nappi> miinat;
    private int x,y;

    public Kentta(int leveys, int korkeus) {
        this.napit = new ArrayList();
        this.miinat=new ArrayList();
        this.korkeus = korkeus;
        this.leveys = leveys;
        x=0;
        y=0;
        
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
        this.miinat = new ArrayList();
        this.korkeus = korkeus;
        this.leveys = leveys;
        x=0;
        y=0;
        ArrayList<Integer> miinojenKoodinaatit=arvoEriKoordinaatteja(miinoja);
        
        for (int i = 0; i < korkeus*leveys; i++) {
            if(miinojenKoodinaatit.contains(i)) {
                napit.add(new Miina(x,y));
                miinat.add(napit.get(napit.size()-1));
            } else {
                napit.add(new EiMiina(x,y));
            }
            x++;
            if(x==leveys) {
                x=0;
                y++;
            }
        }
        kasvataMiinaLkm();
    }
    
    public void kasvataMiinaLkm() {
        for (Nappi nappi : napit) {
            if(nappi.getPiilotettuTeksti().equals("M")) {
                lisaaMiinaViereen(nappi.getXkoordinaatti(), nappi.getYkoordinaatti());
            }
        }
    }
    
    public ArrayList<Integer> arvoEriKoordinaatteja(int koordinaatteja) {
        ArrayList<Integer> koordinaatit = new ArrayList();
        Random random = new Random();
        int koordinaatti=-1;
        
        for (int i = 0; i < koordinaatteja; i++) {
            koordinaatti=random.nextInt(this.korkeus*this.leveys);
            while(koordinaatit.contains(koordinaatti)) {
                koordinaatti=random.nextInt(this.korkeus*this.leveys);
            }
            koordinaatit.add(koordinaatti);
        }
        
        return koordinaatit;
    }
    
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
    
    public Nappi nappiKoordinaatissa(int x, int y) {
        return this.napit.get(x+y*this.leveys);
    }

    public ArrayList<Nappi> getMiinat() {
        return miinat;
    }
    
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
            if(nappi.getXkoordinaatti()==leveys-1) {
                tulostus += "\n";
            }
        }
        
        return tulostus;
    }
    
}
