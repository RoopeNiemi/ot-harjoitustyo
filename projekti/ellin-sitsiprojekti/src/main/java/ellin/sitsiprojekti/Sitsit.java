
package ellin.sitsiprojekti;

public class Sitsit {
    private String nimi;
    private String lokaatio;
    private int maxOsallistujamaara;
    
    public Sitsit(String nimi) {
        this.nimi = nimi;
        this.lokaatio = "Ei tiedossa.";
        this.maxOsallistujamaara = 0;
    }

    public void setLokaatio(String lokaatio) {
        this.lokaatio = lokaatio;
    }

    public void setMaxOsallistujamaara(int maxOsallistujamaara) {
        this.maxOsallistujamaara = maxOsallistujamaara;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
    
    
}
