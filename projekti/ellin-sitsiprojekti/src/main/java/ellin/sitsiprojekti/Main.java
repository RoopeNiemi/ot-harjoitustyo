
package ellin.sitsiprojekti;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Kayttoliittyma.class);
            }
        }.start();
        
        
        
        /*System.out.println("Mitkäs sitsit on tulossa??");
        String sitsienNimi = lukija.nextLine();
        
        Sitsit sitsit = new Sitsit(sitsienNimi);
        IlmojenHallinta hallinta = new IlmojenHallinta(sitsit);
        
        //Väliaikainen tekstikäyttöliittymä
        //Tulevaisuudessa tiedot luetaan tiedostosta,
        //mikä vuoksi käyttäjä syöttää tässä versioissa 
        System.out.println("Kirjoita sarakkeiden otsikot (erottele tabulaattorilla), nimi ja sähköposti kahteen ensimmäiseen sarakkeeseen:");
        String kaikkiOtsikot = lukija.nextLine();
        String[] otsikot = kaikkiOtsikot.split("\t");
        
        while (true) {
            System.out.println("Syötä ilmoittautumisrivi (x lopettaa):");
            String rivi = lukija.nextLine();
            if (rivi.equals("x")) {
                break;
            }
            String[] sarakkeittain = rivi.split("\t");
            String nimi = sarakkeittain[0];
            String maili = sarakkeittain[1];
            Henkilo ilmooja = new Henkilo(nimi, maili);
            Ilmo uusiIlmo = new Ilmo(sitsit, ilmooja);
            for (int i = 2; i < sarakkeittain.length; i++) {
                uusiIlmo.lisaaValinta(otsikot[i], sarakkeittain[i]);
            }
            hallinta.lisaaIlmo(uusiIlmo);
        }
        
        hallinta.tulostaIlmot();*/
    }
}
