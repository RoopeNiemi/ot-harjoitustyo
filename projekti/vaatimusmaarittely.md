## Vaativuusmääritely ##

### Sovelluksen tarkoitus ###
Ideana on toteuttaa sovellus, joka kokoaa sitseille ilmoittautuneista ihmisistä ja heidän antamistaan tiedoista yhteenvedon, josta sitsien järjestäjän on helppo nähdä esimerkiksi kuinka paljon ruokaa ja juomaa pitää ostaa jne. Lisäksi sovellus tekee ehdotuksen istumajärjestyksestä, jossa on otettu huomioon sitsaajien vierustoveritoiveet.

### Toiminnallisuudet ###
Aluksi:
* Näyttää tilastot:
  * Ilmoittautuneiden määrä
  * Ruokavaliojakauma (liha/kasvis/vegaani)
  * Juomajakauma
  * Ensimmäinen ensimmäinen fuksivuosi
  * Erityisruokavaliot
  * ...
* Kokoaa yhteen tiedot kunkin juoman menekistä, ts. laskee kuinka paljon kutakin juomaa tarvitsee ostaa

Myöhemmin:
* Tekee sitsiplassiehdotuksen ottaen huomioon paikkatoiveet

### Toteutus ###
Paras käytettävyys sovelluksella olisi, jos se pystyisi lukemaan ilmoittautuneiden listan suoraan netistä (Matrixin nettisivujen ilmoittautumissivulta), mutta sen toteuttaminen lienee hieman hankalmpaa kuin esim. taulukon lukeminen tiedostosta. Siispä tämä asia on hieman auki vielä.

### Käyttäjä ###
Sovellus ei tarvitse muita käyttäjiä kuin ns. sitsijärjestäjän käyttäjän. Jos tietojen lukemisen Matrixin nettisivuilta saisi onnistumaan niin tietysti silloin pitäisi olla admin-tunnukset myös sinne.
