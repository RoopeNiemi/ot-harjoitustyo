/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ellin.sitsiprojekti;

import java.util.ArrayList;

/**
 *
 * @author kiisk
 */
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
