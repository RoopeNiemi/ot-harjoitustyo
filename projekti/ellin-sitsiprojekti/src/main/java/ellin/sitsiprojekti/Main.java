/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ellin.sitsiprojekti;

import java.util.Scanner;

/**
 *
 * @author kiisk
 */
public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Mitkäs sitsit on tulossa??");
        String sitsienNimi = lukija.nextLine();
        
        Sitsit sitsit = new Sitsit(sitsienNimi);
        IlmojenHallinta hallinta = new IlmojenHallinta(sitsit);

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
        
        hallinta.tulostaIlmot();
    }
}
