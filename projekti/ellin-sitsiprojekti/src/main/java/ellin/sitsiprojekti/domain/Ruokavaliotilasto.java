
package ellin.sitsiprojekti.domain;

import java.util.ArrayList;

public class Ruokavaliotilasto implements Tilasto {
    private String otsikko;
    private ArrayList<String> ruokavaliot;
    
    public Ruokavaliotilasto(String otsikko) {
        this.otsikko = otsikko;
        this.ruokavaliot = new ArrayList<>();
    }
    
    @Override
    public void lisaaTilastoon(String ruokavalio) {
        if (!ruokavalio.contains("-")) {
            ruokavaliot.add(ruokavalio);
        }
    }
    
    @Override
    public String toString() {
        String tilasto = this.otsikko;
        for (String rv : ruokavaliot) {
            tilasto += "\n" + rv;
        }
        return tilasto;
    }
    
}
