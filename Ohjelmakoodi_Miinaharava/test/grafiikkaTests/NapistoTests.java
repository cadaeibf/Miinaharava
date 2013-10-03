
package grafiikkaTests;

import grafiikka.GraafinenKentta;
import grafiikka.GraafinenNappi;
import grafiikka.Napisto;
import java.awt.Container;
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cadaei
 */
public class NapistoTests {
    Asetukset asetukset1;
    Asetukset asetukset2;
    Asetukset asetukset3;
    Napisto napisto1;
    Napisto napisto2;
    Napisto napisto3;
    
    
    public NapistoTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        asetukset1 = new Asetukset(2,2,0);
        asetukset2 = new Asetukset(1,1,1);
        asetukset3 = new Asetukset(4,4,0);
        napisto1 = new Napisto(new GraafinenKentta(asetukset1, new Container()), new Peli(asetukset1));
        napisto2 = new Napisto(new GraafinenKentta(asetukset2, new Container()), new Peli(asetukset2));
        napisto3 = new Napisto(new GraafinenKentta(asetukset3, new Container()), new Peli(asetukset3));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ymparillaOlevatToimiiOikein() {
        String tulostus = "";
        for (GraafinenNappi graafinenNappi : napisto1.ymparillaOlevat(napisto1.getNappiLista().get(0))) {
            tulostus += graafinenNappi.toString();
        }
        
        assertEquals("XXX", tulostus);
    }
    
    @Test
    public void kaivaToimii1() {
        napisto2.kaiva(napisto2.getNappiLista().get(0));
        assertEquals("M", napisto2.toString());
    }
    
    @Test
    public void kaivaToimii2() {
        napisto1.kaiva(napisto1.getNappiLista().get(0));
        assertEquals("0000", napisto1.toString());
    }
}