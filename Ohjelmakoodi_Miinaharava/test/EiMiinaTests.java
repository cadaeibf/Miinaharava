
import ohjelmalogiikka.EiMiina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EiMiinaTests {
    EiMiina eiMiina;
    
    public EiMiinaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        eiMiina = new EiMiina(6,9);
    }
    
    @After
    public void tearDown() {
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
}