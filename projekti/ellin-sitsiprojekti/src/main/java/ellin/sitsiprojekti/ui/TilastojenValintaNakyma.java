
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TilastojenValintaNakyma implements Nakyma {
    private IlmojenHallinta hallinta;
    private VBox asettelu;
    private HBox aliasettelu;
    private Button seuraava;
    private Scene nakyma;
    private ArrayList<Valintalista> valintalistat;
    
    public TilastojenValintaNakyma(IlmojenHallinta hallinta, String ohjeteksti) {
        this.hallinta = hallinta;
        this.asettelu = new VBox();
        asettelu.setSpacing(10);
        this.valintalistat = new ArrayList<>();
        aliasettelu = new HBox();
        Label ohje = new Label(ohjeteksti);
        this.seuraava = new Button("Seuraava");
        this.asettelu.getChildren().add(ohje);
        this.nakyma = new Scene(asettelu, 1000, 600);
    }
    
    public void luoValintalistat(String[] otsikot) {
        String[] laabelit = {"Juomatilasto", "Ruokavaliot", "Eka fuksivuosi"};
        for (int i = 0; i < laabelit.length; i++) {
            Valintalista uusi = new Valintalista(hallinta, laabelit[i]);
            for (int j = 3; j < otsikot.length; j++) {
                uusi.lisaaBoksi(otsikot[j]);
            }
            this.aliasettelu.getChildren().add(uusi.getAsettelu());
            this.valintalistat.add(uusi);
        }        
    }
    
    public ArrayList<Valintalista> getValintalistat() {
        return this.valintalistat;
    }

    @Override
    public Scene getNakyma() {
        asettelu.getChildren().addAll(aliasettelu, seuraava);
        return this.nakyma;
    }

    public Button getSeuraavaNappi() {
        return this.seuraava;
    }
    
}
