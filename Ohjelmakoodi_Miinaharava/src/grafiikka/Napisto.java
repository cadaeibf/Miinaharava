
package grafiikka;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import napinPainamiset.HiirenKuuntelija;
import ohjelmalogiikka.EiMiina;
import ohjelmalogiikka.Nappi;
import ohjelmalogiikka.Peli;

public class Napisto {
    private Peli peli;
    private ArrayList<GraafinenNappi> nappiLista;
    private JPanel jPanel;

    public Napisto(GraafinenKentta graafinenKentta, Peli peli) {
        this.peli = peli;
        this.nappiLista = new ArrayList();
        
        lisaaNapit();
        lisaaHiirenKuuntelijat(graafinenKentta);
        
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(this.peli.kentanKorkeus(), this.peli.kentanLeveys()));
        
        for (GraafinenNappi graafinenNappi1 : nappiLista) {
            jPanel.add(graafinenNappi1.getPainike());
        }
    }
    
    /*
     * Metodi palauttaa annetun napin ympärillä olevat napit listana
     * @param graafinenNappi GraafinenNappi, jonka ympärillä olevat napit selvitetään
     * @return lista ympärillä olevista napeista
     */
    public ArrayList<GraafinenNappi> ymparillaOlevat(GraafinenNappi graafinenNappi) {
        ArrayList<GraafinenNappi> ymparillaOlevat = new ArrayList();
        for (GraafinenNappi graafinenNappi1 : nappiLista) {
            if(peli.getKentta().ymparillaOlevat(graafinenNappi.getNappi()).contains(graafinenNappi1.getNappi())) {
                ymparillaOlevat.add(graafinenNappi1);
            }
        }
        return ymparillaOlevat;
    }
    
    /*
     * Metodi, joka kaivaa napistosta annetusta paikasta ja ilmoittaa kaivetun napin pelille 
     * Jos annetun napin ympärillä ei ole miinoja, kaivetaan kaikki muutkin miinattomat lähistön paikat
     * @param paikka, josta kaivetaan
     */
    public void kaiva(GraafinenNappi graafinenNappi) {
        if(!peli.onKaynnissa()) {
            return;
        }
        if(graafinenNappi.onNakyva()) {
            return;
        }
        graafinenNappi.teeNakyvaksi();
        peli.kaivettu(graafinenNappi.getNappi());
        
        if(graafinenNappi.eiMiinojaYmparilla()) {
            for (GraafinenNappi graafinenNappi1 : ymparillaOlevat(graafinenNappi)) {
                kaiva(graafinenNappi1);
            }
        }
    }
    
    /*
     * Metodi, joka lisää lipun annetun GraafisenNapin paikalle.
     * @param graafinenNappi paikka, johon lisätään lippu
     * @return totuusarvo siitä, onko peli voitettu
     */
    public void lippu(GraafinenNappi graafinenNappi) {
        if(peli.onKaynnissa()) {
                if(!graafinenNappi.onNakyva()) {
                    graafinenNappi.lisaaLippu();
                    peli.lippuLisatty(graafinenNappi.getNappi());
                }
            }
    }
    
    public void kaivaYmparilta(GraafinenNappi graafinenNappi) {
        if(!peli.onKaynnissa()) {
            return;
        }
        if(!graafinenNappi.onNakyva()) {
            return;
        }
        EiMiina eiMiina = (EiMiina) graafinenNappi.getNappi();
        if(eiMiina.getMiinojaYmparilla()==peli.getKentta().lippujaYmparilla(eiMiina)) {
            for (GraafinenNappi graafinenNappi1 : ymparillaOlevat(graafinenNappi)) {
                if(!graafinenNappi1.onLipullinen()) {
                    kaiva(graafinenNappi1);
                }
            }
        }
    }
    
    private void lisaaNapit() {
        GraafinenNappi graafinenNappi;
        
        for (Nappi nappi : peli.getKentta().getNapit()) {
            graafinenNappi = new GraafinenNappi(nappi);
            nappiLista.add(graafinenNappi);
        }
    }
    
    public GraafinenNappi nappiKoordinaatissa(int x, int y) {
        return nappiLista.get(x+y*peli.kentanLeveys());
    }
    
    private void lisaaHiirenKuuntelijat(GraafinenKentta graafinenKentta) {
        for (GraafinenNappi graafinenNappi : nappiLista) {
            graafinenNappi.getPainike().addMouseListener(new HiirenKuuntelija(graafinenKentta, graafinenNappi));
        }
    }

    public JPanel getJPanel() {
        return jPanel;
    }
    
    public void naytaMiinat() {
        for (GraafinenNappi graafinenNappi : nappiLista) {
            if(graafinenNappi.getNappi().onMiina()) {
                graafinenNappi.teeNakyvaksi();
            }
        }
    }
    
    public boolean peliVoitettu() {
        return this.peli.onVoitettu();
    }
    
    public boolean peliKaynnissa() {
        return this.peli.onKaynnissa();
    }
    
    public int miinojaJaljella() {
        return this.peli.miinojaJaljella();
    }

    public ArrayList<GraafinenNappi> getNappiLista() {
        return nappiLista;
    }

    public Peli getPeli() {
        return peli;
    }
    
    public void voitto() {
        for (GraafinenNappi graafinenNappi : nappiLista) {
            if(!graafinenNappi.onNakyva()) {
                graafinenNappi.lisaaLippu();
                peli.lippuLisatty(graafinenNappi.getNappi());
            }
        }
    }

    @Override
    public String toString() {
        String tuloste = "";
        for (GraafinenNappi graafinenNappi : nappiLista) {
            tuloste += graafinenNappi.toString();
        }
        return tuloste;
    }
    
}
