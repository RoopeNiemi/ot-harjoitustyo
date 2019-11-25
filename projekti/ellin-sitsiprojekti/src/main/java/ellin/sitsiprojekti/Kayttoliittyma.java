/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ellin.sitsiprojekti;

import java.util.ArrayList;
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
import javafx.stage.Stage;

/**
 *
 * @author kiisk
 */
public class Kayttoliittyma extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
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
        Scene nakyma1 = new Scene(asettelu1);
        
        //toinen näkymä ja sen asettelu
        VBox asettelu2 = new VBox();
        Label ohje = new Label("Kopioi tähän matrixin nettisivujen ilmoittautujalista: ");
        TextArea kentta = new TextArea();
        kentta.setPrefSize(400, 400);
        Button seuraava2 = new Button("Seuraava");
        asettelu2.getChildren().addAll(ohje, kentta, seuraava2);
        Scene nakyma2 = new Scene(asettelu2);
        
        //kolmas näkymä ja sen asettelu
        VBox asettelu3 = new VBox();
        Label valitse = new Label("Mistä sarakkeista tehdään tilastot: ");
        asettelu3.getChildren().add(valitse);
        Button seuraava3 = new Button("Seuraava");
        ArrayList<CheckBox> boksit = new ArrayList<>();
        Scene nakyma3 = new Scene(asettelu3);
        IlmojenHallinta hallinta = new IlmojenHallinta();
        
        
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
                for (int i = 0; i < otsikot.length; i++) {
                    CheckBox uusiBoksi = new CheckBox(otsikot[i]);
                    boksit.add(uusiBoksi);
                    asettelu3.getChildren().add(uusiBoksi);
                }
                asettelu3.getChildren().add(seuraava3);
                ikkuna.setScene(nakyma3);
            }
        });
        
        seuraava3.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                
            }
        });
        
        ikkuna.setScene(nakyma1);
        ikkuna.show();
    }
    
}
