
package ellin.sitsiprojekti.domain;

public class Valinta {
    private String valittavaAsia;
    private String valittuVaihtoehto;
    
    public Valinta(String valittavaAsia, String valittuVaihtoehto) {
        this.valittavaAsia = valittavaAsia;
        this.valittuVaihtoehto = valittuVaihtoehto;
    }
    
    public String getValinta(String valinta) {
        if (this.valittavaAsia.equals(valinta)) {
            return this.valittuVaihtoehto;
        }
        return "";
    }
}
