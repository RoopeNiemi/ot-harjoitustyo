
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class KaikkiTilastotNakyma implements Nakyma {
    private IlmojenHallinta hallinta;
    private HBox asettelu;
    private VBox aliasettelu1;
    private VBox juomatilastot;
    private VBox ruokatilasto;
    private VBox ekaFuksiTilasto;
    private Button seuraava;
    private Scene nakyma;
    private ArrayList<JuomatilastoAsettelu> juomatilastotListana;
    private RuokatilastoAsettelu ruokatilastoAsetteluna;
    private EkaFuksivuosiAsettelu ekaFuksivuosiAsetteluna;
    private String juomaYhtVeto;
    private String ruokaYhtVeto;
    private String ekaFUksivuosi;
    
    public KaikkiTilastotNakyma(IlmojenHallinta hallinta) {
        this.hallinta = hallinta;
        this.juomatilastotListana = new ArrayList<>();
        this.ekaFuksivuosiAsetteluna = null;
        this.ekaFuksivuosiAsetteluna = null;
        this.asettelu = new HBox();
        this.aliasettelu1 = new VBox();
        this.juomatilastot = new VBox();
        juomatilastot.setSpacing(15);
        this.ruokatilasto = new VBox();
        this.ekaFuksiTilasto = new VBox();
        asettelu.setSpacing(20);
        Label ylaotsikko = new Label("TILASTOT");
        Text juomaOhje = new Text("\nLaskeaksesi juomien menekit,"
                + "\nkirjoita kunkin kohdalle kuinka"
                + "\nmonta cl kyseistä juomaa tarjoillaan"
                + "\nsitsien aikana per sitsaaja.\n");
        Text ruokaOhje = new Text("Selkeyttääksesi ruokavaliolistaa,"
                + "\nvoit valita jonkin vaihtoehdoista"
                + "\nkasvis/vegaani/spessu (valitse spessu"
                + "\nsilloin kun kyseessä ei ole pelkkä"
                + "\nkasvis tai vegaani, mutta ei"
                + "\nmyöskään turha/trolli)\n");
        this.seuraava = new Button("Seuraava");
        this.aliasettelu1.getChildren().addAll(ylaotsikko, juomaOhje, ruokaOhje, seuraava);
        this.asettelu.getChildren().add(aliasettelu1);
        this.nakyma = new Scene(asettelu, 1000, 600);
    }
    
    public void lisaaJuomatilasto(String otsikko) {
        JuomatilastoAsettelu aliasettelu = new JuomatilastoAsettelu(hallinta, otsikko);
        juomatilastotListana.add(aliasettelu);
        juomatilastot.getChildren().add(aliasettelu.getAsettelu());
    }
    
    public void lisaaRuokatilasto(String otsikko) {
        RuokatilastoAsettelu aliasettelu = new RuokatilastoAsettelu(hallinta, otsikko);
        this.ruokatilastoAsetteluna = aliasettelu;
        this.ruokatilasto = aliasettelu.getAsettelu();
    }
    
    public void lisaaEkaFuksivuosiTilasto(String otsikko) {
        EkaFuksivuosiAsettelu aliasettelu = new EkaFuksivuosiAsettelu(hallinta, otsikko);
        this.ekaFuksivuosiAsetteluna = aliasettelu;
        this.ekaFuksiTilasto = aliasettelu.getAsettelu();
    }
    
    public void tallennaTiedotSeuraavaaNakymaaVarten() {
        juomaYhtVeto = "";
        for (JuomatilastoAsettelu jta : juomatilastotListana) {
            juomaYhtVeto += jta.muodostaYhteenveto() + "\n";
        }
        ruokaYhtVeto = "";
        ekaFUksivuosi = "";
        if (ruokatilastoAsetteluna != null) {
            ruokaYhtVeto = ruokatilastoAsetteluna.muodostaYhteenveto();
        }
        if (ekaFuksivuosiAsetteluna != null) {
            ekaFUksivuosi = ekaFuksivuosiAsetteluna.muodostaYhteenveto();
        }
    }
    
    public String yhteenvedot() {
        return juomaYhtVeto + "\n" + ruokaYhtVeto + "\n" + ekaFUksivuosi;
    }
    
    @Override
    public Scene getNakyma() {
        asettelu.getChildren().add(juomatilastot);
        asettelu.getChildren().add(ruokatilasto);
        asettelu.getChildren().add(ekaFuksiTilasto);
        return this.nakyma;
    }

    public Button getSeuraavaNappi() {
        return this.seuraava;
    }
    
}
