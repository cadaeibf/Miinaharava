
import java.util.ArrayList;
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Kentta;
import ohjelmalogiikka.Nappi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KenttaTests {
    Kentta kentta;
    Kentta kentta2;
    
    public KenttaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kentta = new Kentta(new Asetukset(3,4,0));
        kentta2 = new Kentta(new Asetukset(4,3,0));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kenttaOnMuotoaKorkeusKertaaLeveys1() {
        assertEquals("XXX\nXXX\nXXX\nXXX\n", kentta.toString());
    }
    
    @Test
    public void kenttaOnMuotoaKorkeusKertaaLeveys2() {
        assertEquals("XXXX\nXXXX\nXXXX\n", kentta2.toString());
    }
    
    @Test
    public void kentanKaivaminenToimii1() {
        kentta.kaiva(0, 0);
        assertEquals("OXX\nXXX\nXXX\nXXX\n", kentta.toString());
    }
    
    @Test
    public void kentanKaivaminenToimii2() {
        kentta.kaiva(1, 2);
        assertEquals("XXX\nXXX\nXOX\nXXX\n", kentta.toString());
    }
    
    @Test
    public void kentanKaivaminenToimii3() {
        kentta.kaiva(2, 3);
        assertEquals("XXX\nXXX\nXXX\nXXO\n", kentta.toString());
    }
    
    @Test
    public void ymparillaOlevatListanAlkioidenMaaraOikein1() {
        ArrayList<Nappi> ymparillaOlevat = kentta.ymparillaOlevat(1,1);
        assertEquals(8, ymparillaOlevat.size());
    }
    
    @Test
    public void ymparillaOlevatListanAlkioidenMaaraOikein2() {
        ArrayList<Nappi> ymparillaOlevat = kentta.ymparillaOlevat(0,1);
        assertEquals(5, ymparillaOlevat.size());
    }
    
    @Test
    public void ymparillaOlevatListanAlkioidenMaaraOikein3() {
        ArrayList<Nappi> ymparillaOlevat = kentta.ymparillaOlevat(2,3);
        assertEquals(3, ymparillaOlevat.size());
    }
    
    @Test
    public void ymparillaOlevatOikein() {
        for (Nappi nappi : kentta.ymparillaOlevat(1, 1)) {
            nappi.teeNakyvaksi();
        }
        assertEquals("OOO\nOXO\nOOO\nXXX\n", kentta.toString());
    }
    
    @Test
    public void randomKonstruktoriLisaaOikeanMaaranMiinojaListaan() {
        kentta= new Kentta(new Asetukset(10,5,5));
        assertEquals("5", ""+kentta.getMiinat().size());
    }
    
    @Test
    public void MiinalistanAlkiotKaikkiMiinoja() {
        kentta= new Kentta(new Asetukset(10,5,5));
        String tuloste="";
        for (Nappi nappi : kentta.getMiinat()) {
            nappi.teeNakyvaksi();
            tuloste+=nappi.toString();
        }
        assertEquals("MMMMM", tuloste);
    }
}