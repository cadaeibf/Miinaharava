
import ohjelmalogiikka.Nappi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NappiTests {
    Nappi nappi1;
    Nappi nappi2;
    Nappi orego;
    
    public NappiTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nappi1 = new Nappi(4,5);
        orego = new Nappi(0,0);
        nappi2 = new Nappi(5,6);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void napinGetteritAntavatOikeatArvot() {
        assertEquals("45",nappi1.xKoordinaatti()+""+nappi1.yKoordinaatti());
    }
    
    @Test
    public void teeNakyvaksiToimii() {
        nappi1.teeNakyvaksi();
        assertEquals("O",nappi1.toString());
    }
    
    @Test
    public void napinSetPiilotettuTekstiToimii() {
        nappi1.setPiilotettuTeksti(":)");
        nappi1.teeNakyvaksi();
        assertEquals(":)", nappi1.toString());
    }
    
    @Test
    public void etaisyydenNelioToimii1() {
        assertEquals(41, orego.etaisyydenNelio(nappi1));
    }
    
    @Test
    public void etaisyydenNelioToimii2() {
        assertEquals(2, nappi1.etaisyydenNelio(nappi2));
    }
}