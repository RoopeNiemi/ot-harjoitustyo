
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.EkaFuksivuosiTilasto;
import ellin.sitsiprojekti.domain.IlmojenHallinta;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EkaFuksivuosiAsettelu {
    private VBox asettelu;
    private String eka;

    public EkaFuksivuosiAsettelu(IlmojenHallinta hallinta, String otsikko) {
        this.asettelu = new VBox();
        asettelu.setSpacing(10);
        Label tilastonOtsikko = new Label(otsikko);
        this.asettelu.getChildren().addAll(tilastonOtsikko);
        EkaFuksivuosiTilasto rt = new EkaFuksivuosiTilasto(hallinta, otsikko);
        this.eka = "Esimmäinen fuksivuosi: " + rt.getEkaFuksivuosi();        
        asettelu.getChildren().add(new Label(eka));
    }
    
    public String muodostaYhteenveto() {
        return eka;
    }

    public VBox getAsettelu() {
        return this.asettelu;
    }

}
