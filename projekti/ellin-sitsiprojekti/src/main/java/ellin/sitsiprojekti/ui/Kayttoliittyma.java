
package ellin.sitsiprojekti.ui;

import ellin.sitsiprojekti.domain.IlmojenHallinta;
import ellin.sitsiprojekti.domain.Sitsit;
import ellin.sitsiprojekti.domain.Tilasto;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Kayttoliittyma extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        String esimerkki = "TÄSTÄ VOIT KOPIOIDA ESIMERKKITAULUKON TESTAUKSEEN:\n\n" +
            "#	nimi	säpo	viini	viina	ruoka	vuosi\n" +
            "1	elli	e@g.fi	punkku	jallu		2017\n" +
            "2	saku	s@g.fi	valkkari	jallu		2017\n" +
            "3	eero	ee@g.fi	punkku	punssi		2015\n" +
            "4	aleksi	a@g.fi	valkkari	jallu		2016\n" +
            "5	mira	m@g.fi	valkkari	jallu	en syö mitään	2017";
        
        IlmojenHallinta hallinta = new IlmojenHallinta();
        

        //ensimmäinen näkymä ja sen asettelu
        VBox asettelu1 = new VBox();
        Label nimilabel = new Label("Sitsien nimi:");
        TextField nimikentta = new TextField();
        Label lokaatiolabel = new Label("Sitsien lokaatio:");
        TextField lokaatiokentta = new TextField();
        Label maxOsLabel = new Label("Maksimimäärä osallistujia:");
        TextField maxOsKentta = new TextField();
        Button seuraava1 = new Button("Seuraava");
        asettelu1.getChildren().addAll(nimilabel, nimikentta, lokaatiolabel, lokaatiokentta, maxOsLabel, maxOsKentta, seuraava1);
        Scene nakyma1 = new Scene(asettelu1, 1000, 600);
        
        //toinen näkymä ja sen asettelu
        VBox asettelu2 = new VBox();
        Label ohje = new Label("Kopioi tähän matrixin nettisivujen ilmoittautujalista: ");
        TextArea kentta = new TextArea();
        kentta.setPrefSize(400, 400);
        Button seuraava2 = new Button("Seuraava");
        TextArea esimerkkiTaulukko = new TextArea(esimerkki);
        asettelu2.getChildren().addAll(ohje, kentta, seuraava2, esimerkkiTaulukko);
        Scene nakyma2 = new Scene(asettelu2, 1000, 600);
        
        //kolmas näkymä ja sen asettelu
        VBox asettelu3 = new VBox();
        HBox aliasettelu3 = new HBox();
        Label valitse = new Label("Valitse tilastoihin otettavat sarakkeet:");
        asettelu3.getChildren().add(valitse);
        Button seuraava3 = new Button("Seuraava");
        Scene nakyma3 = new Scene(asettelu3, 1000, 600);
        
        
        //neljäs näkymä ja sen asettelu
        VBox asettelu4 = new VBox();
        HashMap<String, ArrayList<CheckBox>> tilastointivaihtoehdot = new HashMap<>();
        tilastointivaihtoehdot.put("Juomatilasto", new ArrayList<>());
        tilastointivaihtoehdot.put("Ruokavaliot", new ArrayList<>());
        tilastointivaihtoehdot.put("Ensimmäinen fuksivuosi", new ArrayList<>());
        tilastointivaihtoehdot.put("Plassi", new ArrayList<>());
        Label otsikko = new Label("TILASTOT");
        ArrayList<String> tilastot = new ArrayList<>();
        asettelu4.getChildren().add(otsikko);
        Scene nakyma4 = new Scene(asettelu4, 1000, 600);
        
        
        seuraava1.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                String nimi = nimikentta.getText();
                String lokaatio = lokaatiokentta.getText();
                int maxOsallijat = Integer.valueOf(maxOsKentta.getText());
                Sitsit sitsit = new Sitsit(nimi);
                sitsit.setLokaatio(lokaatio);
                sitsit.setMaxOsallistujamaara(maxOsallijat);
                hallinta.setSitsit(sitsit);
                ikkuna.setScene(nakyma2);
            }
        });
        
        seuraava2.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                String taulukko = kentta.getText();
                String[] otsikot = hallinta.kasitteleTaulukko(taulukko);
                for (String tOtsikko : tilastointivaihtoehdot.keySet()) {
                    Label tilastonOtsikko = new Label(tOtsikko);
                    VBox valinnat = new VBox();
                    valinnat.getChildren().add(tilastonOtsikko);
                    for (int i = 3; i < otsikot.length; i++) {
                        CheckBox uusiBoksi = new CheckBox(otsikot[i]);
                        tilastointivaihtoehdot.get(tOtsikko).add(uusiBoksi);
                        valinnat.getChildren().add(uusiBoksi);
                    }
                    aliasettelu3.getChildren().addAll(valinnat);
                }
                asettelu3.getChildren().addAll(aliasettelu3, seuraava3);
                ikkuna.setScene(nakyma3);
            }
        });
        
        seuraava3.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                for (String tilasto : tilastointivaihtoehdot.keySet()) {
                    
                    for (CheckBox boksi : tilastointivaihtoehdot.get(tilasto)) {
                        if (boksi.isSelected()) {
                            if (tilasto.equals("Juomatilasto")) {
                                hallinta.teeJuomatilasto(boksi.getText());
                                tilastot.add(hallinta.getTilasto(boksi.getText()).toString());
                            } else if (tilasto.equals("Ruokavaliot")) {
                                hallinta.teeRuokavaliotilasto(boksi.getText());
                                tilastot.add(hallinta.getTilasto(boksi.getText()).toString());
                            } else if (tilasto.equals("Ensimmäinen fuksivuosi")) {
                                hallinta.laskeEkaFuksivuosi(boksi.getText());
                                tilastot.add(hallinta.getTilasto(boksi.getText()).toString());
                            } else if (tilasto.equals("Plassi")) {
                                System.out.println("Plassiominaisuus ei vielä käytössä");
                            }
                        }
                    }
                }               
                for (String t : tilastot) {
                    Text tilasto = new Text(t);
                    asettelu4.getChildren().add(tilasto);
                }
                ikkuna.setScene(nakyma4);
            }
        });
        
        ikkuna.setScene(nakyma1);
        ikkuna.show();
    }
    
}
