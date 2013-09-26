
import ohjelmalogiikka.Asetukset;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AsetuksetsTests {
    Asetukset asetukset;
    
    public AsetuksetsTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        asetukset = new Asetukset(4,6,8);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getteritToimii() {
        assertEquals(4, asetukset.getKentanLeveys());
        assertEquals(6, asetukset.getKentanKorkeus());
        assertEquals(8, asetukset.getMiinoja());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void miinojenLukumaaraEiVoiOllaSuurempiKuinKentanKoko() {
            asetukset = new Asetukset(1,1,2);
    }
}