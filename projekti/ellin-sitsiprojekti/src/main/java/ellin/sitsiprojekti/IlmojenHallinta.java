
package ellin.sitsiprojekti;

import java.util.ArrayList;

public class IlmojenHallinta {
    private Sitsit sitsit;
    private ArrayList<Ilmo> ilmot;
    
    public IlmojenHallinta(Sitsit sitsit) {
        this.sitsit = sitsit;
        this.ilmot = new ArrayList<>();
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
}
