
package grafiikkaTests;

import grafiikka.GraafinenKentta;
import java.awt.Container;
import ohjelmalogiikka.Asetukset;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cadaei
 */
public class GraafinenKenttaTests {
    GraafinenKentta graafinenKentta;
    
    public GraafinenKenttaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        graafinenKentta = new GraafinenKentta(new Asetukset(2,2,0), new Container());
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktointiOnnistuu() {
        assertEquals("XX\nXX\n", graafinenKentta.getNapisto().getPeli().getKentta().toString());
    }
}