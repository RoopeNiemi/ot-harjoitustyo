

package ellin.sitsiprojekti;

import java.util.ArrayList;
import java.util.HashMap;

public class IlmojenHallinta {
    private Sitsit sitsit;
    private ArrayList<Ilmo> ilmot;
    private HashMap<String, Tilasto> tilastot;
    
    public IlmojenHallinta() {
        this.ilmot = new ArrayList<>();
        this.tilastot = new HashMap<>();
    }
    
    public void setSitsit(Sitsit sitsit) {
        this.sitsit = sitsit;
    }
    
    public void lisaaIlmo(Ilmo ilmo) {
        ilmot.add(ilmo);
    }
    
    public void tulostaIlmot() {
        for (Ilmo i : ilmot) {
            System.out.println(i);
        }
    }
    
    public int ilmojenMaara() {
        return ilmot.size();
    }
    
    public void teeLukumaaraTilasto(String otsikko) {
        LukumaaraTilasto tilasto = new LukumaaraTilasto(otsikko);
        for (Ilmo i : ilmot) {
            tilasto.lisaaTilastoon(i.getValinta(otsikko));
        }
        tilastot.put(otsikko, tilasto);
    }
    
    public Tilasto getTilasto(String otsikko) {
        return tilastot.get(otsikko);
    }
    
    public String[] kasitteleTaulukko(String kopioitu) {
        String[] rivit = kasitteleRaakaTeksti(kopioitu);
        String[] otsikot = rivit[0].split("\t");
        
        for (int i = 1; i < rivit.length; i++) {
            String[] sarakkeittain = rivit[i].split("\t");
            String nimi = sarakkeittain[1];
            String maili = sarakkeittain[2];
            Henkilo sitsaaja = new Henkilo(nimi, maili);
            Ilmo uusiIlmo = new Ilmo(sitsit, sitsaaja);
            
            for (int j = 3; j < otsikot.length; j++) {
                uusiIlmo.lisaaValinta(otsikot[j], sarakkeittain[j]);
            }
            ilmot.add(uusiIlmo);
        }
        return otsikot;
    }
    
    //apumetodi joka muokkaa taulukon raakatekstin siten että tyhjissä kohdissa on merkki "-"
    //välttämätöntä koska muuten kasitteleTaulukko ei toimi oikein
    public String[] kasitteleRaakaTeksti(String teksti) {
        String[] rivit = teksti.split("\n");
        for (int i = 0; i < rivit.length; i++) {
            String[] merkit = rivit[i].split("");
            for (int j = 1; j < merkit.length; j++) {
                if (merkit[j].equals("\t") && merkit[j-1].equals("\t")) {
                    merkit[j-1] = "\t" + "-";
                    if (j == merkit.length - 1) {
                        merkit[j] = "\t" + "-";
                    }
                }
                
            }
            rivit[i] = "";
            for (int j = 0; j < merkit.length; j++) {
                rivit[i] += merkit[j];
            }
        }
        return rivit;
    }

}
