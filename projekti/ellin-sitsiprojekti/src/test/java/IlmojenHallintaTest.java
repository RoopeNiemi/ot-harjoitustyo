
import ellin.sitsiprojekti.domain.Henkilo;
import ellin.sitsiprojekti.domain.Ilmo;
import ellin.sitsiprojekti.domain.IlmojenHallinta;
import ellin.sitsiprojekti.domain.Sitsit;
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
    String taulukko;
    String[] otsikot;
    
    @Before
    public void setUp() {
        sitsit = new Sitsit("testisitsit");
        hallinta = new IlmojenHallinta();
        hallinta.setSitsit(sitsit);
        taulukko = "#\tNimi\tSähköposti\tViini\tViina\tErityisruokavalio"
                + "\n1.\tArhippa\ta.p@gmail.com\tPunkku\tKossu\tEn syö paprikaa"
                + "\n2.\tAito-Iisakki Jimmynpoika\taito@jumalanterve.fi\tValkkari\tHoliton\tVegaani";
        otsikot = new String[] {"#", "Nimi", "Sähköposti", "Viini", "Viina", "Erityisruokavalio"};
    }
    
    @Test
    public void taulukonKasittelyToimii() {
        String[] kasiteltyTaulukko = hallinta.kasitteleTaulukko(taulukko);
        assertEquals(otsikot[0], kasiteltyTaulukko[0]);
    }
    
    
}
