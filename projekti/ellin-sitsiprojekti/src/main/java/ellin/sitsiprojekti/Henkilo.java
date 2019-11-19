/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ellin.sitsiprojekti;

/**
 *
 * @author kiisk
 */
public class Henkilo {
    private String nimi;
    private String maili;
    
    public Henkilo(String nimi, String maili) {
        this.nimi = nimi;
        this.maili = maili;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
    
    
}
