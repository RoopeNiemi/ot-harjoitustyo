package ellin.sitsiprojekti.test;


import ellin.sitsiprojekti.domain.Henkilo;
import ellin.sitsiprojekti.domain.Ilmo;
import ellin.sitsiprojekti.domain.IlmojenHallinta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IlmojenHallintaTest {

    IlmojenHallinta hallinta;
    String taulukko;
    String[] otsikot;
    
    @Before
    public void setUp() {
        hallinta = new IlmojenHallinta();
        taulukko = "#\tNimi\tSähköposti\tViini\tViina\tErityisruokavalio\tEnsimmäinen fuksivuosi"
                + "\n1.\tArhippa\ta.p@gmail.com\tPunkku\tKossu\t\t2010"
                + "\n2.\tAito-Iisakki Jimmynpoika\taito@jumalanterve.fi\tValkkari\tHoliton\tVegaani\t1998";
        otsikot = new String[] {"#", "Nimi", "Sähköposti", "Viini", "Viina", "Erityisruokavalio", "Ensimmäinen fuksivuosi"};
    }
    
    @Test
    public void kasitteleRaakaTekstiPoistaaTuplatabulaattorit() {
        boolean test = true;
        String[] kasitelty = hallinta.kasitteleRaakaTeksti(taulukko);
        for (int i = 0; i < kasitelty.length; i++) {
            if (kasitelty[i].contains("\t\t")) {
                test = false;
            }
        }
        assertTrue(test);
    }
    
    @Test
    public void taulukonKasittelyToimii() {
        String[] kasiteltyTaulukko = hallinta.kasitteleTaulukko(taulukko);
        assertEquals(otsikot[0], kasiteltyTaulukko[0]);
    }
    
    @Test
    public void getIlmotPalauttaaOikeanKokoisenListan() {
        hallinta.kasitteleTaulukko(taulukko);
        int ilmojenMaara = hallinta.getIlmot().size();
        assertEquals(2, ilmojenMaara);
    }
    
    @Test
    public void ilmonGetValintaPalauttaaOikean() {
        hallinta.kasitteleTaulukko(taulukko);
        Ilmo i = hallinta.getIlmot().get(0);
        String viinaValinta = i.getValinta("Viina");
        assertEquals("Kossu", viinaValinta);
    }
}
