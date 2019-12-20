
package ellin.sitsiprojekti.domain;

import java.util.ArrayList;

public class Ilmo {
    private Henkilo henkilo;
    private ArrayList<Valinta> valinnat;
    
    public Ilmo(Henkilo henkilo) {
        this.henkilo = henkilo;
        valinnat = new ArrayList<>();
    }
    
    public void lisaaValinta(String vaihtoehto, String valinta) {
        valinnat.add(new Valinta(vaihtoehto, valinta));
    }
    
    public String getValinta(String otsikko) {
        for (Valinta valinta : valinnat) {
            if (!valinta.getValinta(otsikko).equals("")) {
                return valinta.getValinta(otsikko);
            }
        }
        return "";
    }
}
