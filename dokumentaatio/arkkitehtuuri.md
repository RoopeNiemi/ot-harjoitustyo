## Arkkitehtuuri ## 

### Rakenne ###

Ohjelman rakenne pakkaustasolla on seuraavanlainen:

![pakkausrakenne](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/kuvat/otpaska1.jpg)

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

![Ilmojenhallinta-luokkis](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/kuvat/otpaska2.jpg)

Luokka *IlmojenHallinta* käsittelee käyttöliittymältä saadun taulukon ja hallitsee *Ilmo*-olioita.

#### Tilastointi ####

![Tilasto-luokkis](https://github.com/ellikiiski/ot-harjoitustyo/blob/master/kuvat/otpaska3.jpg)

Tilastot luodaan käyttöliittymästä, ja ne käyttävät hyödyksi luokan *IlmojenHallinta* ilmoittautumistietoja.
