
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Kayttoliittyma extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        IlmojenHallinta hallinta = new IlmojenHallinta();
        
        TaulukonKopiointiNakyma nakyma1 = new TaulukonKopiointiNakyma(hallinta, "Kopioi tähän matrixin nettisivujen ilmoittautujalista:");
        TilastojenValintaNakyma nakyma2 = new TilastojenValintaNakyma(hallinta, "Valitse tilastoihin otettavat sarakkeet:");
        KaikkiTilastotNakyma nakyma3 = new KaikkiTilastotNakyma(hallinta);
        LopputilastotNakyma nakyma4 = new LopputilastotNakyma(hallinta);
        
        nakyma1.getSeuraavaNappi().setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                String taulukko = nakyma1.getTaulukko();
                String[] otsikot = hallinta.kasitteleTaulukko(taulukko);
                nakyma2.luoValintalistat(otsikot);
                ikkuna.setScene(nakyma2.getNakyma());
            }
        });
        
        nakyma2.getSeuraavaNappi().setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                for (Valintalista vl : nakyma2.getValintalistat()) {
                    if (vl.getOtsikko().equals("Juomatilasto")) {
                        for (CheckBox boksi : vl.getBoksit()) {
                            if (boksi.isSelected()) {
                                nakyma3.lisaaJuomatilasto(boksi.getText());
                            }
                        }
                    } else if (vl.getOtsikko().equals("Ruokavaliot")) {
                        for (CheckBox boksi : vl.getBoksit()) {
                            if (boksi.isSelected()) {
                                nakyma3.lisaaRuokatilasto(boksi.getText());
                            }
                        }
                    } else if (vl.getOtsikko().equals("Eka fuksivuosi")) {
                        for (CheckBox boksi : vl.getBoksit()) {
                            if (boksi.isSelected()) {
                                nakyma3.lisaaEkaFuksivuosiTilasto(boksi.getText());
                            }
                        }
                    }
                    
                }
                ikkuna.setScene(nakyma3.getNakyma());
            }
        });
        
        nakyma3.getSeuraavaNappi().setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                nakyma3.tallennaTiedotSeuraavaaNakymaaVarten();
                nakyma4.lisaaTilastot(nakyma3.yhteenvedot());
                ikkuna.setScene(nakyma4.getNakyma());
            }
        });
        
        ikkuna.setScene(nakyma1.getNakyma());
        ikkuna.show();
    }
    
}
