
import ohjelmalogiikka.Nappi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NappiTests {
    Nappi nappi;
    
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
        nappi = new Nappi(4,5);
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
}