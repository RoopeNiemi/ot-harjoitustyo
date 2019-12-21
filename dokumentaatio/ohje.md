## Sovelluksen käyttöohje ##

### Asennus ###

Lataa [loppupalautus-releasesta](https://github.com/ellikiiski/ot-harjoitustyo/releases/tag/loppupalautus) tiedosto ellin-sitsiprojekti.jar koneellesi ja käynnistä ohjelma joko klikkaamalla se auki tiedostohallinan graafisesta käyttöliittymästä tai komentoriviltä komennolla

<pre>java -jar ellin-sitsiprojekti.jar</pre>

### Käyttö ###

Sovellus on tarkoitettu käytettäväksi siten, että Matrixin nettisivujen admin-käyttäjä kopioi sitsien tapahtumasivulta taulukon ilmoittautuneista. Koska mitä ilmeisimmin sinulla, hyvä lukija, ei sellaisia ole, voit käyttää seuraavaa taulukkoa testaukseen:

<pre>#	nimi	säpo	viini	viina	ruoka	vuosi
1	elli	e@g.fi	punkku	jallu		2017
2	saku	s@g.fi	valkkari	jallu		2017
3	eero	ee@g.fi	punkku	punssi		2015
4	aleksi	a@g.fi	valkkari	jallu		2016
5	mira	m@g.fi	valkkari	jallu	en syö mitään	2017
6	emma	em@g.fi	valkkari	jallu		ei
7	nalle	n@g.fi	punkku	jallu	tupla-annokset kiitos	2017
8	paukkis	p@g.fi	valkkari	kossu	vegaani	2016
9	kia	k@g.fi	valkkari	jallu	kasvis	2017</pre>

Seuraavassa näkymässä valitse mistä taulukon sarakkeista haluat tehdä minkäkin tilaston. Oleellisesti siis esimerkkitaulukon tupauksessa järkevää olisi valita juomatilastoon viini ja viina, ruokavaliotilastoon ruoka, ja ensimmäisen fuksivuoden laskemiseen vuosisarake.

Nyt seuraavassa näkymässä voit juomamenekin laskeaksesi merkitä kuinka paljon kutakin juomaa sitseillä tarjoillaan per sitsaaja (Huom! kirjoita pelkkiä numeroita), sekä klikkailla kunkin erityisruokavalion kohdalta boksin, joka kuvaa kyseistä mainintaa parhaiten. Ohjeet löytyy myös itse näkymästä.

Viimeisessä näkymässä onkin sitten koottuna kaikki tilastot: juomien menekki, kasvisruokavalioistan lukumäärä, vegaanien lukumäärä, lueteltuna muut erityisruokavaliot sekä alimpana esimmäinen fuksivuosi.
