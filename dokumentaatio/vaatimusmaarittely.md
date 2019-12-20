## Vaativuusmäärittely ##

### Sitsisovelluksen tarkoitus ###
Sitsisovelluksen ideana on koota kätevästi sitseihin liittyviä tilastoja käyttäjän nähtäväksi, eli säästää näin sitsien järjestäjän aikaa. Sovellust toimii siten, että Matrixin nettisivuilta kopioidaan ilmoittautuneiden lista (johon tosin pääsee käsiksi vain edmis-oikeuksilla), jonka jälkeen sovellus kokoaa siitä käyttäjän avustuksella hyödyllisiä tilastoja.

### Toiminnallisuudet ###
* Mahdollisuus valita mistä (nettisivuilta kopioidun) taulukon sarakkeista tehdään mikäkin tilasto
* Näyttää raakaversiot tilastoista:
  * Kaikki mainitut erityisruokavaliot
  * Juomajakauma: kuinka monta kpl mitäkin juomaa on valittu
* Kokoaa yhteen käyttäjän syöttämien tietojen (esim. tietyn juoman tilavuus per sitsaaja) perusteella, kuinka paljon mitäkin juomaa täytyy sitsejä varten ostaa, kuinka monta kasvisruokavalioista ja vegaania sitseille osallistuu sekä mitä muita erikoisruokavalioita kahden edellisen lisäksi sitsaajilta löytyy.

Jatkokehitettävääkin sovellukselle löytyy, sillä siihen voisi lisätä vielä toiminnon, joka loisi istumajärjestysehdotuksen ilmoittautumistaulukon istumapaikkatoiveiden pohjalta. Siihen ei kuitenkaan aika vielä tämän kurssin puitteissa riittänyt.

### Toteutus ###
Sovellusta käytetään graafisella käyttöliittymällä, jonka aloitusnäkymän tekstikenttään käyttäjä kopioi Matrixin nettisivuilta ilmoittautujataulukon. Taulukon ohjelma strukturoi siten, että käyttäjän valintojen mukaan tietyistä taulukon sarakkeista tehdään tietynlaiset tilastot, jotka sitten näytetään lopuksi käyttäjälle viimeisessä näkymässä.

### Käyttäjä ###
Sovelluksella on vain yhdenlainen käyttäjä, sitsien järjestäjä.
