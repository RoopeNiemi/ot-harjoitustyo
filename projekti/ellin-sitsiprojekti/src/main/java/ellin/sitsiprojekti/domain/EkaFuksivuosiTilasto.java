
package ellin.sitsiprojekti.domain;

public class EkaFuksivuosiTilasto implements Tilasto {
    private IlmojenHallinta hallinta;
    private int eka;
    
    public EkaFuksivuosiTilasto(IlmojenHallinta hallinta, String otsikko) {
        this.hallinta = hallinta;
        this.eka = 2100;
        for (Ilmo i : hallinta.getIlmot()) {
            this.lisaaTilastoon(i.getValinta(otsikko));
        }
    }    
    
    @Override
    public void lisaaTilastoon(String vuosi) {
        int vuosiLukuna = 2100;
        try {
            vuosiLukuna = Integer.valueOf(vuosi);
        } catch (Exception e) {
            System.out.println("fail");
        }
        eka = Math.min(eka, vuosiLukuna);
    }

    public int getEkaFuksivuosi() {
        return eka;
    }
}
