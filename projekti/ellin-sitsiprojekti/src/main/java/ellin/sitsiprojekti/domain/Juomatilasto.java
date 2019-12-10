
package ellin.sitsiprojekti.domain;

import java.util.HashMap;

public class Juomatilasto implements Tilasto {
    private String otsikko;
    private HashMap<String, Integer> valinnat;
    
    public Juomatilasto(String otsikko) {
        this.otsikko = otsikko;
        this.valinnat = new HashMap<>();
    }

    @Override
    public void lisaaTilastoon(String valinta) {
        if (!valinnat.containsKey(valinta)) {
            valinnat.put(valinta, 0);
        }
        int maara = valinnat.get(valinta) + 1;
        valinnat.put(valinta, maara);
    }
    
    public int maara(String juoma) {
        return valinnat.get(juoma);
    }

    @Override
    public String toString() {
        String tilasto = this.otsikko;
        for (String otsikko : valinnat.keySet()) {
            tilasto += "\n" + otsikko + ": " + valinnat.get(otsikko);
        }
        return tilasto;
    }
    
    
}
