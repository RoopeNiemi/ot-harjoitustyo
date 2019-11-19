
package ellin.sitsiprojekti;

import java.util.HashMap;

public class Ilmo {
    private Sitsit sitsit;
    private Henkilo henkilo;
    private HashMap<String, String> valinnat;
    
    public Ilmo(Sitsit sitsit, Henkilo henkilo) {
        this.sitsit = sitsit;
        this.henkilo = henkilo;
        valinnat = new HashMap<>();
    }
    
    public void lisaaVaihtoehto(String vaihtoehto) {
        valinnat.put(vaihtoehto, "");
    }
    
    public void lisaaValinta(String vaihtoehto, String valinta) {
        valinnat.put(vaihtoehto, valinta);
    }
    
    @Override
    public String toString() {
        String valintaLista = "";
        for (String valinta : valinnat.values()) {
            valintaLista += valinta + " ";
        }
        return this.henkilo + " on ilmonnut sitseille " + this.sitsit + " ja valinnut: " + valintaLista;
    }
}
