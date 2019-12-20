
package ellin.sitsiprojekti.domain;

public class Henkilo {
    private String nimi;
    private String maili;
    
    public Henkilo(String nimi, String maili) {
        this.nimi = nimi;
        this.maili = maili;
    }

    public String getNimi() {
        return nimi;
    }

    public String getMaili() {
        return maili;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
    
    
}
