
import ohjelmalogiikka.Asetukset;
import ohjelmalogiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTests {
    Peli peli;
    
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
        peli = new Peli(new Asetukset(10,8,15));
    }
    
    @After
    public void tearDown() {
    }
    
    
}