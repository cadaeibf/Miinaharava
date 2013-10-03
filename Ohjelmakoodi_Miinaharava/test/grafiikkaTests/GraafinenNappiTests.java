
package grafiikkaTests;

import grafiikka.GraafinenNappi;
import ohjelmalogiikka.Nappi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GraafinenNappiTests {
    GraafinenNappi graafinenNappi;
    
    public GraafinenNappiTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        graafinenNappi = new GraafinenNappi(new Nappi(0,0));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void teeNakyvaksiToimii() {
        graafinenNappi.teeNakyvaksi();
        assertEquals("O", graafinenNappi.toString());
    }
    
    @Test
    public void lipunLisaysToimii() {
        graafinenNappi.lisaaLippu();
        assertEquals("L", graafinenNappi.getPainike().getText());
    }
    
    @Test
    public void lipunPoistoToimii() {
        graafinenNappi.lisaaLippu();
        graafinenNappi.lisaaLippu();
        assertEquals("", graafinenNappi.getPainike().getText());
    }
    
    @Test
    public void lippuaEiLisataJosOnNakyva() {
        graafinenNappi.teeNakyvaksi();
        graafinenNappi.lisaaLippu();
        
        assertEquals("O", graafinenNappi.toString());
    }
    
    @Test
    public void onNakyvaToimii1() {
        assertEquals(false, graafinenNappi.onNakyva());
    }
    
    @Test
    public void onNakyvaToimii2() {
        graafinenNappi.teeNakyvaksi();
        assertEquals(true, graafinenNappi.onNakyva());
    }
}