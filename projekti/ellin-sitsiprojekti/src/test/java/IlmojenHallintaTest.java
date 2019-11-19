
import ellin.sitsiprojekti.Henkilo;
import ellin.sitsiprojekti.Ilmo;
import ellin.sitsiprojekti.IlmojenHallinta;
import ellin.sitsiprojekti.Sitsit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IlmojenHallintaTest {
    
    Sitsit sitsit;
    IlmojenHallinta hallinta;
    Ilmo ilmo;
    String nimi;
    String maili;
    
    @Before
    public void setUp() {
        sitsit = new Sitsit("testisitsit");
        hallinta = new IlmojenHallinta(sitsit);
        Ilmo ilmo = new Ilmo(sitsit, new Henkilo(nimi, maili));
        nimi = "testijannu";
        maili = "testi.jannu@test.com";
    }
    
    @Test
    public void uusiIlmoRekisteroityy() {
        hallinta.lisaaIlmo(ilmo);
        assertEquals(1, hallinta.ilmojenMaara());
    }
}
