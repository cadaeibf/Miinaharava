
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Nappi;
import ohjelmalogiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTests {
    Peli peli1;
    Peli peli2;
    Nappi nappi1;
    
    public PeliTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        peli1 = new Peli(new Asetukset(2,2,2));
        peli2 = new Peli(new Asetukset(1,1,1));
        nappi1 = new Nappi(0,0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaLippu1() {
        peli1.lippuLisatty(nappi1);
        
        assertEquals("LX\nXX\n", peli1.getKentta().toString());
    }
    
    @Test
    public void lisaaLippu2() {
        peli1.lippuLisatty(nappi1);
        
        assertEquals(1, peli1.miinojaJaljella());
    }
    
    @Test
    public void lisaaJaPoistaLippu1() {
        peli1.lippuLisatty(nappi1);
        peli1.lippuLisatty(nappi1);
        
        assertEquals("XX\nXX\n", peli1.getKentta().toString());
    }
    
    @Test
    public void lisaaJaPoistaLippu2() {
        peli1.lippuLisatty(nappi1);
        peli1.lippuLisatty(nappi1);
        
        assertEquals(2, peli1.miinojaJaljella());
    }
    
    @Test
    public void peliLoppuuKunKaivetaanMiinasta() {
        peli2.kaivettu(nappi1);
        
        assertEquals(false, peli2.onKaynnissa());
    }
}