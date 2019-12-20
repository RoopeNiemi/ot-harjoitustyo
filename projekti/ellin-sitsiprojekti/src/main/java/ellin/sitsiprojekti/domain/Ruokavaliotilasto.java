
package ellin.sitsiprojekti.domain;

import java.util.ArrayList;

public class Ruokavaliotilasto implements Tilasto {
    private IlmojenHallinta hallinta;
    private String otsikko;
    private ArrayList<String> ruokavaliot;
    
    public Ruokavaliotilasto(IlmojenHallinta hallinta, String otsikko) {
        this.hallinta = hallinta;
        this.otsikko = otsikko;
        this.ruokavaliot = new ArrayList<>();
        for (Ilmo i : hallinta.getIlmot()) {
            this.lisaaTilastoon(i.getValinta(otsikko));
        }
    }
    
    @Override
    public void lisaaTilastoon(String ruokavalio) {
        if (!ruokavalio.equals("-")) {
            ruokavaliot.add(ruokavalio);
        }
    }
    
    public ArrayList<String> getRuokavaliot() {
        return this.ruokavaliot;
    }
}
