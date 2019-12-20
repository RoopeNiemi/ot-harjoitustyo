
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import ellin.sitsiprojekti.domain.Juomatilasto;
import ellin.sitsiprojekti.domain.Ruokavaliotilasto;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RuokatilastoAsettelu {
    private VBox asettelu;
    private ArrayList<CheckBox> kasvisBox;
    private ArrayList<CheckBox> vegeBox;
    private HashMap<CheckBox, String> muutBox;
    private int kasvikset;
    private int veget;
    private ArrayList<String> muut;

    public RuokatilastoAsettelu(IlmojenHallinta hallinta, String otsikko) {
        this.kasvisBox = new ArrayList<>();
        this.vegeBox = new ArrayList<>();
        this.muutBox = new HashMap<>();
        this.kasvikset = 0;
        this.veget = 0;
        this.muut = new ArrayList<>();
        this.asettelu = new VBox();
        asettelu.setSpacing(3);
        Label tilastonOtsikko = new Label(otsikko);
        this.asettelu.getChildren().addAll(tilastonOtsikko);
        Ruokavaliotilasto rt = new Ruokavaliotilasto(hallinta, otsikko);
        for (String ruoka : rt.getRuokavaliot()) {
            HBox aliasettelu = new HBox();
            aliasettelu.setSpacing(10);
            CheckBox k = new CheckBox("kasvis");
            CheckBox v = new CheckBox("vegaani");
            CheckBox s = new CheckBox("spessu");
            kasvisBox.add(k);
            vegeBox.add(v);
            muutBox.put(s, ruoka);
            aliasettelu.getChildren().addAll(k, v, s, new Label("|"), new Label(ruoka));
            asettelu.getChildren().add(aliasettelu);
        }
    }
    
    public void tallennaValitutBoksit() {
        for (CheckBox boksi : kasvisBox) {
            if (boksi.isSelected()) {
                kasvikset++;
            }
        }
        for (CheckBox boksi : vegeBox) {
            if (boksi.isSelected()) {
                veget++;
            }
        }
        for (CheckBox boksi : muutBox.keySet()) {
            if (boksi.isSelected()) {
                muut.add(muutBox.get(boksi));
            }
        }
    }
    
    public String muodostaYhteenveto() {
        tallennaValitutBoksit();
        String yhteenveto = "";
        yhteenveto += "Kasvisruokavaliot: " + kasvikset + "kpl\n";
        yhteenveto += "Vegaanit: " + veget + "kpl\n";
        yhteenveto += "Muut erityisruokavaliot:\n";
        for (String rv : muut) {
            yhteenveto += rv + "\n";
        }
        return yhteenveto;
    }

    public VBox getAsettelu() {
        return this.asettelu;
    }

}
