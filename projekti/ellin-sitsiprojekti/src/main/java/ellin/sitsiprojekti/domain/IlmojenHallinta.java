

package ellin.sitsiprojekti.domain;

import java.util.ArrayList;

public class IlmojenHallinta {
    private ArrayList<Ilmo> ilmot;
    
    public IlmojenHallinta() {
        this.ilmot = new ArrayList<>();
    }

    public ArrayList<Ilmo> getIlmot() {
        return ilmot;
    }
    
    public String[] kasitteleTaulukko(String kopioitu) {
        String[] rivit = kasitteleRaakaTeksti(kopioitu);
        String[] otsikot = rivit[0].split("\t");
        
        for (int i = 1; i < rivit.length; i++) {
            String[] sarakkeittain = rivit[i].split("\t");
            String nimi = sarakkeittain[1];
            String maili = sarakkeittain[2];
            Henkilo sitsaaja = new Henkilo(nimi, maili);
            Ilmo uusiIlmo = new Ilmo(sitsaaja);
            
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
                if (merkit[j].equals("\t") && merkit[j - 1].equals("\t")) {
                    merkit[j - 1] = "\t" + "-";
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
