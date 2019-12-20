# **OHJELMISTOTEKNIIKKA 2019**

## *PROJEKTITYÖ - Sitsienjärjestysapulainen*
Ohjelma, joka kerää suoraan Matrixin nettisivuilta kopioidusta taulukosta tarvittavat tiedot ja kokoaa niistä käyttäjän haluamat tilastot.

### [Dokumentaatio](https://github.com/ellikiiski/ot-harjoitustyo/tree/master/dokumentaatio) ###

[Määrittelydokumentti](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Luokkakaavio (arkkutehtuuri)](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Sovelluksen käyttöohje](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/ohje.md)

[Työaikakirjanpito](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

Komentoja:
* mvn compile exec:java -Dexec.mainClass=ellin.sitsiprojekti.domain.Main
* mvn test jacoco:report
* mvn jxr:jxr checkstyle:checkstyle
* mvn package
