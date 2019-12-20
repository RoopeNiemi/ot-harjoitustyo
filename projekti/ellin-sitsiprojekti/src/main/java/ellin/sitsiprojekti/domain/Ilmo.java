
package ellin.sitsiprojekti.domain;

import java.util.ArrayList;
import java.util.HashMap;

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
    
    /*@Override
    public String toString() {
        String valintaLista = "";
        for (String valinta : valinnat.values()) {
            valintaLista += valinta + " ";
        }
        return this.henkilo + " on ilmonnut sitseille ja valinnut: " + valintaLista;
    }*/
}
