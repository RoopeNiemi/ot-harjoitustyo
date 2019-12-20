
package ellin.sitsiprojekti.test;

import ellin.sitsiprojekti.domain.EkaFuksivuosiTilasto;
import ellin.sitsiprojekti.domain.IlmojenHallinta;
import ellin.sitsiprojekti.domain.Juomatilasto;
import ellin.sitsiprojekti.domain.Ruokavaliotilasto;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TilastoTest {
    
    IlmojenHallinta hallinta;
    String taulukko;
    String[] otsikot;
    
    Juomatilasto jt;
    Ruokavaliotilasto rt;
    EkaFuksivuosiTilasto eft;
    
    @Before
    public void setUp() {
        hallinta = new IlmojenHallinta();
        taulukko = "#\tNimi\tSähköposti\tViini\tViina\tErityisruokavalio\tEnsimmäinen fuksivuosi"
                + "\n1.\tArhippa\ta.p@gmail.com\tPunkku\tKossu\t\t2010"
                + "\n2.\tAito-Iisakki Jimmynpoika\taito@jumalanterve.fi\tValkkari\tHoliton\tVegaani\t1998";
        otsikot = new String[]{"#", "Nimi", "Sähköposti", "Viini", "Viina", "Erityisruokavalio", "Ensimmäinen fuksivuosi"};
        hallinta.kasitteleTaulukko(taulukko);
        jt = new Juomatilasto(hallinta, otsikot[3]);
        rt = new Ruokavaliotilasto(hallinta, otsikot[5]);
        eft = new EkaFuksivuosiTilasto(hallinta, otsikot[6]);
    }
    
    @Test
    public void juomatilastonGetMaaratPalauttaaOikean() {
        int punkku = jt.getMaarat().get("Punkku");
        assertEquals(1, punkku);
    }
    
    @Test
    public void ruokavaliotilastonGetRuokavaliotPalauttaaOikean() {
        int ruokavalioita = rt.getRuokavaliot().size();
        assertEquals(1, ruokavalioita);
    }
    
    @Test
    public void ekaFuksivuosiTilastonGetEkaFuksivuosiPalauttaaOikean() {
        int ekaFV = eft.getEkaFuksivuosi();
        assertEquals(1998, ekaFV);
    }

}
