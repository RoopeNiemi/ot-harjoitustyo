## Arkkitehtuuri ## 

### Rakenne ###

Ohjelman rakenne pakkaustasolla on seuraavanlainen:

Kuva

Pakkaus *ellin.sitsiprojekti.ui* sisältää käyttöliittymän luokat sekä pakkaus *ellin.sitsiprojekti.domain* sovelluslgiikan.

### Käyttöliittymä ###

Käyttöliittymässä on neljä näkymää, joilla kullakin on oma luokkansa:
* Taulukon kopiointi/liittämisnäkymä: *TaulukonKopiointaNakyma*
* Näkymä, jossa valitaan generoitavat tilastot: *TilastojenValintaNakyma*
* Näkymä, johon käyttäjä voi syöttää tietoja yhteenvetoa varten: *KaikkiTilastotNakyma*
* Loppunäkymä, joka näyttää kootut tilastot: *LopputilastotNakyma*

Käyttöliittymä on eriytetty sovelluslogiikasta, mutta se ajaa paikoin tietokannan asemaa, sillä erillistä tietokantaa ei ole ohjelmaan kehitetty.

### Sovelluslogiikka ###

Sovelluslogiikka voidaan jakaa kahteen osaan:

#### Raa'an taulukkodatan käsittely ja ilmoittautumisten hallinta ####

Kuva

Luokka *IlmojenHallinta* käsittelee käyttöliittymältä saadun taulukon ja hallitsee *Ilmo*-olioita.

#### Tilastointi ####

Kuva

Tilastot luodaan käyttöliittymästä, ja ne käyttävät hyödyksi luokan *IlmojenHallinta* ilmoittautumistietoja.
