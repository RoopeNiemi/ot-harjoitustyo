
package ellin.sitsiprojekti.domain;

public class EkaFuksivuosiTilasto implements Tilasto {
    private int eka;
    
    public EkaFuksivuosiTilasto() {
        this.eka = 2100;
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
    
    @Override
    public String toString() {
        String tilasto = "Ensimmäinen fuksivuosi: " + eka;
        return tilasto;
    }
    
}
