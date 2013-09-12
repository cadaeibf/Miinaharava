
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import src.EiMiina;
import src.Kentta;
import src.Miina;
import src.Nappi;

public class MiinaharavaTest {
    
    Nappi nappi;
    Miina miina;
    EiMiina eiMiina;
    Kentta kentta;
    Kentta kentta2;
    
    public MiinaharavaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nappi = new Nappi(4,5);
        miina = new Miina(7,9);
        eiMiina = new EiMiina(6,9);
        kentta = new Kentta(3,4);
        kentta2 = new Kentta(4,3);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void napinGetteritAntavatOikeatArvot() {
        assertEquals("45",nappi.getXkoordinaatti()+""+nappi.getYkoordinaatti());
    }
    
    @Test
    public void teeNakyvaksiToimii() {
        nappi.teeNakyvaksi();
        assertEquals("O",nappi.toString());
    }
    
    @Test
    public void napinSetPiilotettuTekstiToimii() {
        nappi.setPiilotettuTeksti(":)");
        nappi.teeNakyvaksi();
        assertEquals(":)", nappi.toString());
    }
    
    @Test
    public void miinanGetteritAntavatOikeatArvot() {
        assertEquals("79",miina.getXkoordinaatti()+""+miina.getYkoordinaatti());
    }
    
    @Test
    public void miinanKaivaminenJaTuloste() {
        miina.teeNakyvaksi();
        assertEquals("M", miina.toString());
    }
    
    @Test
    public void EiMiinaKonstruktoriJaTuloste() {
        eiMiina.teeNakyvaksi();
        assertEquals("0", eiMiina.toString());
    }
    
    @Test
    public void EiMiinaMiinanLisaysToimii() {
        eiMiina.teeNakyvaksi();
        eiMiina.lisaaMiinaViereen();
        assertEquals("1", eiMiina.toString());
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
}