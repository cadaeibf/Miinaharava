
import ohjelmalogiikka.Miina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaTests {
    Miina miina;
    
    
    public MiinaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        miina = new Miina(7,9);
    }
    
    @After
    public void tearDown() {
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
}