## Testausdokumentti ##

Ohjelman testausta on suoritettu automaattisilla JUnit-testeillä, sekä manuaalisesti käyttöliittymän toimintaa testaamalla.

### Automatisoitu testaus ###

Sovelluslogiikkaa on testattu automaattisin JUnit-testein pakkauksessa [ellin.sitsiprojekti.test](https://github.com/ellikiiski/ot-harjoitustyo/tree/master/projekti/ellin-sitsiprojekti/src/test/java/ellin/sitsiprojekti/test) olevilla luokilla *IlmojenHallintaTest* ja *TilastoTest*. Luokan *IlmojenHallintaTest* testit testaavat taulukon käsittelyä, ilmoittautumisten lisäämistä ja ilmoittautumisten käsittelyä, sekä puolestaan luokan *TilastoTest* testit testaavat eri tilastotyyppien toimintaa.

### Testauskattavuus ###

Ohjelman testikattavuus (ilman käyttöliittymää) on rivikattavuuden osalta 93% ja haarautumakattavuuden osalta 90%.

![jacoco](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/kuvat/ot-testaus-jacoco-lopullinen.JPG)

Main-luokka on kokonaan testaamatta, ja sen lisäksi muutama poikkeustilanne, joissa esim. merkkijono ei ole muutettavissa kokonaisluvuksi. Näihin tilanteisiin ei kuitenkaan pitäisi sovellusta oikein käytettäessä törmätä.

### Manuaalinen testaus ###

Ohjelman asennus käyttöohjeiden mukaan on testattu manuaalisesti Windowsilla. Myös kaikki [määrittelydokumentin](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) toiminnallisuudet on todettu toimiviksi manuaalisesti testaten.

### Jäljelle jääneet ongelmakohdat ###

Virheilmoituksia voisi kehittää kautta linjan. Varsinkin, jos alkuvaiheessa syötetty taulukko on väärää muotoa tai siinä on esim. yksi ylimääräinen rivinvaihto, toimii ohjelma väärin, mutta ei välttämättä kaadu tai anna mitään virheilmoitusta.
