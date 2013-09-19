
package ohjelmalogiikka;

import java.util.Scanner;

public class Peli {
    private Kentta kentta;
    private boolean onKaynnissa;
    private Scanner scanner;
    private String komento;
    private Asetukset asetukset;
    private int miinojaJaljella;

    public Peli(Asetukset asetukset) {
        this.asetukset=asetukset;
        scanner = new Scanner(System.in);
    }
    
    public void run() {
        uusiPeli(asetukset.getKentanLeveys(), asetukset.getKentanKorkeus(), asetukset.getMiinoja());
        
        while(onKaynnissa) {
            tulostaKentta();
            pelaaVuoro();
            if(kentta.kaikkiNapitNakyvia()) {
                lopetaPeli();
                System.out.println("Voitit pelin!");
            }
        }
    }
    
    public void uusiPeli(int kentanLeveys, int kentanKorkeus, int miinoja) {
        this.kentta=new Kentta(kentanLeveys, kentanKorkeus, miinoja);
        this.onKaynnissa=true;
        this.miinojaJaljella=miinoja;
        tulostaKomennot();
    }
    
    public void kaiva() {
        int x,y;
        System.out.print("x: ");
        x= Integer.parseInt(scanner.nextLine());
        System.out.print("y: ");
        y=Integer.parseInt(scanner.nextLine());
        
        if(this.kentta.kaiva(x, y)==false) {
            
            lopetaPeli();
        }
    }
    
    public void lippu() {
        int x,y;
        System.out.print("x: ");
        x= Integer.parseInt(scanner.nextLine());
        System.out.print("y: ");
        y=Integer.parseInt(scanner.nextLine());
        if(this.kentta.lippu(x,y)) {
            miinojaJaljella--;
        }else {
            miinojaJaljella++;
        }
    }
    
    public void lopetaPeli() {
        tulostaKentta();
        System.out.println("Hävisit pelin!");
        this.onKaynnissa=false;
    }
    
    public void tulostaKentta() {
        System.out.println("Miinoja Jäljellä: " + miinojaJaljella);
        System.out.println(this.kentta.toString());
    }
    
    public void tulostaKomennot() {
        System.out.println("Komennot:\n--------\nn : uusi peli\nk : kaiva\nl : lippu(aseta/poista)\nx : lopeta\n--------");
    }

    private void pelaaVuoro() {
        System.out.print("Komento: ");
        komento=scanner.nextLine();
        if(komento.equals("n")) {
            uusiPeli(asetukset.getKentanLeveys(), asetukset.getKentanKorkeus(), asetukset.getMiinoja());
        } if(komento.equals("k")) {
            kaiva();
        } if(komento.equals("l")) {
            lippu();
        } if(komento.equals("x")) {
            lopetaPeli();
        }
    }
}
