
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LopputilastotNakyma implements Nakyma {
    private IlmojenHallinta hallinta;
    private VBox asettelu;
    private Scene nakyma;

    public LopputilastotNakyma(IlmojenHallinta hallinta) {
        this.hallinta = hallinta;
        this.asettelu = new VBox();
        asettelu.setSpacing(5);
        Label otsikko = new Label("YHTEENVETO");
        asettelu.getChildren().add(otsikko);
        this.nakyma = new Scene(asettelu, 1000, 600);
    }
    
    public void lisaaTilastot(String tilastot) {
        Text t = new Text(tilastot);
        asettelu.getChildren().add(t);
    }

    @Override
    public Scene getNakyma() {
        return this.nakyma;
    }
    
}
