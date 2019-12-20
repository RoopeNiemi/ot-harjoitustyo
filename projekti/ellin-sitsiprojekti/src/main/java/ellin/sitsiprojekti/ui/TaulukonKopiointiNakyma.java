
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class TaulukonKopiointiNakyma implements Nakyma {
    
    private VBox asettelu;
    private Button seuraava;
    private TextArea kentta;
    private Scene nakyma;
    
    public TaulukonKopiointiNakyma(IlmojenHallinta hallinta, String ohjeteksti) {
        this.asettelu = new VBox();
        
        Label ohje = new Label(ohjeteksti);
        this.kentta = new TextArea();
        kentta.setPrefSize(400, 400);
        this.seuraava = new Button("Seuraava");
        this.asettelu.getChildren().addAll(ohje, kentta, seuraava);
        
        this.nakyma = new Scene(asettelu, 1000, 600);
    }
    
    @Override
    public Scene getNakyma() {
        return this.nakyma;
    }

    public Button getSeuraavaNappi() {
        return this.seuraava;
    }
    
    public String getTaulukko() {
        return this.kentta.getText();
    }
}
