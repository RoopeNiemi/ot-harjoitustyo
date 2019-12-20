# **OHJELMISTOTEKNIIKKA 2019**

## *PROJEKTITYÖ*
Projektityön on tarkoitus tehdä tilastot sitsijuomista, ruuista ja muista relevanteista asioista. Toivon mukaan myös plassitoiminto onnistuu loppukurssista.

### [Dokumentaatio](https://github.com/ellikiiski/ot-harjoitustyo/tree/master/dokumentaatio) ###

[RELEASE viikko 5](https://github.com/ellikiiski/ot-harjoitustyo/releases/tag/viikko5)

[Työaikakirjanpito](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Määrittelydokumentti](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Luokkakaavio (arkkutehtuuri)](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Sovelluksen käyttöohje](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/ohje.md)

Komentoja:
* mvn compile exec:java -Dexec.mainClass=ellin.sitsiprojekti.domain.Main
* mvn test jacoco:report
* mvn jxr:jxr checkstyle:checkstyle
* mvn package
