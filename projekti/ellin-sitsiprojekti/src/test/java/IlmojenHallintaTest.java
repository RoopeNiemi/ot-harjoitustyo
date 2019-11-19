/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author kiisk
 */
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
        hallinta.lisaaIlmo(ilmo);
        assertEquals(2, hallinta.ilmojenMaara());
    }
}
