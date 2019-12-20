
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Valintalista {
    private Label otsikko;
    private ArrayList<CheckBox> boksit;
    private VBox asettelu;
    private Scene nakyma;
    
    public Valintalista(IlmojenHallinta hallinta, String otsikkoteksti) {
        this.asettelu = new VBox();
        this.otsikko = new Label(otsikkoteksti);
        asettelu.getChildren().add(otsikko);
        this.boksit = new ArrayList<>();
        this.nakyma = new Scene(asettelu);
    }
    
    public void lisaaBoksi(String boksinTeksti) {
        CheckBox boksi = new CheckBox(boksinTeksti);
        boksit.add(boksi);
        asettelu.getChildren().add(boksi);
    }
    
    public ArrayList<CheckBox> getBoksit() {
        return this.boksit;
    }
    
    public String getOtsikko() {
        return otsikko.getText();
    }

    public VBox getAsettelu() {
        return this.asettelu;
    }
}
