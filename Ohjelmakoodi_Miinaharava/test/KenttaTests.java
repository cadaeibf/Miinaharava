
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
    public void ymparillaOlevatListanAlkioidenMaaraOikein1() {
        ArrayList<Nappi> ymparillaOlevat = kentta.ymparillaOlevat(kentta.nappiKoordinaatissa(1,1));
        assertEquals(8, ymparillaOlevat.size());
    }
    
    @Test
    public void ymparillaOlevatListanAlkioidenMaaraOikein2() {
        ArrayList<Nappi> ymparillaOlevat = kentta.ymparillaOlevat(kentta.nappiKoordinaatissa(0,1));
        assertEquals(5, ymparillaOlevat.size());
    }
    
    @Test
    public void ymparillaOlevatListanAlkioidenMaaraOikein3() {
        ArrayList<Nappi> ymparillaOlevat = kentta.ymparillaOlevat(kentta.nappiKoordinaatissa(2,3));
        assertEquals(3, ymparillaOlevat.size());
    }
    
    @Test
    public void ymparillaOlevatOikein() {
        for (Nappi nappi : kentta.ymparillaOlevat(kentta.nappiKoordinaatissa(1, 1))) {
            nappi.teeNakyvaksi();
        }
        assertEquals("000\n0X0\n000\nXXX\n", kentta.toString());
    }
    
    @Test
    public void randomKonstruktoriLisaaOikeanMaaranMiinojaListaan() {
        kentta= new Kentta(new Asetukset(10,5,5));
        int miinoja = 0;
        for (Nappi nappi : kentta.getNapit()) {
            if(nappi.onMiina()) {
                miinoja++;
            }
        }
        assertEquals(5, miinoja);
    }
}