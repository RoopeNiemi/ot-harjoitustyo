
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import ellin.sitsiprojekti.domain.Juomatilasto;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JuomatilastoAsettelu {
    private VBox asettelu;
    private ArrayList<Label> juomienNimet;
    private HashMap<TextField, HashMap<String, Integer>> kertoimetJaJuomat;
    
    public JuomatilastoAsettelu(IlmojenHallinta hallinta, String otsikko) {
        this.asettelu = new VBox();
        asettelu.setSpacing(10);
        this.juomienNimet = new ArrayList<>();
        this.kertoimetJaJuomat = new HashMap<>();
        HBox aliasettelu = new HBox();
        aliasettelu.setSpacing(20);
        Label tilastonOtsikko = new Label(otsikko);
        TextField kentta = new TextField("määrä cl");
        kertoimetJaJuomat.put(kentta, new HashMap<>());
        aliasettelu.getChildren().addAll(tilastonOtsikko, kentta);
        this.asettelu.getChildren().addAll(aliasettelu);
        Juomatilasto jt = new Juomatilasto(hallinta, otsikko);
        for (String juoma : jt.getMaarat().keySet()) {
            this.juomienNimet.add(new Label(juoma + ": " + jt.getMaarat().get(juoma)));
            kertoimetJaJuomat.get(kentta).put(juoma, jt.getMaarat().get(juoma));
        }
        for (Label label : juomienNimet) {
            asettelu.getChildren().add(label);
        }
    }
    
    public String muodostaYhteenveto() {
        String yhteenveto = "";
        for (TextField kentta : kertoimetJaJuomat.keySet()) {
            try {
                int cl = Integer.valueOf(kentta.getText());
                for (String juoma : kertoimetJaJuomat.get(kentta).keySet()) {
                    int kpl = kertoimetJaJuomat.get(kentta).get(juoma);
                    yhteenveto += juoma + ": " + kpl + "kpl, yhteensä " + (cl * kpl) / 100.0 + " litraa\n";
                }
            } catch (Exception e) {
                for (String juoma : kertoimetJaJuomat.get(kentta).keySet()) {
                    yhteenveto += juoma + ": " + kertoimetJaJuomat.get(kentta).get(juoma) + "kpl, tilavuutta ei määritelty\n";
                }
            }
        }
        return yhteenveto;
    }

    public VBox getAsettelu() {
        return this.asettelu;
    }

    
}
