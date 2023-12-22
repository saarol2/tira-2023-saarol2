# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK
Tehtävän ensimmäinen askel oli toteuttaa Algorithms.java luokkaan metodi, mikä lajittelee taulukon luonnolliseen järjestykseen. Toteutukseni näkyy alapuolella:

```Java
public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      // TODO: Student, implement this.
      for (int i = fromIndex + 1; i < toIndex; i++){
         T key = array[i];
         int j = i -1;
         while (j >= fromIndex && key.compareTo(array[j]) < 0) {
            array[j + 1] = array[j];
            j--;
         }
         array[j+1] = key;
      }
   }
```
Tässä käyn taulukon elementit tietyltä väliltä läpi for-silmukalla, minkä jokaisella kierroksella tallennan yhden elementin kerrallaan key-muuttujaan. Sitten käytän while-silmukkaa siirtämään taulukon elementtejä yhden askeleen taaksepäin niin kauan, kuin key on pienempi kuin sen kanssa vertailtava elementti. Sitten kun keyn oikea paikka on löytynyt se asetetaan siihen paikan indeksiin.
Toinen koko taulukon insertionSort metodi oli helppo tehdä vain kutsumalla äskeistä metodia ja antamalla sen parametreiksi indeksit 0 ja taulukon pituus.

Toteuttamani lajittelualgoritmin aikakompleksisuusluokka on O(n^2). Tämä siksi, koska se käy läpi jokaisen taulukon elementin ja vertaa sitä muihin elementteihin kahden sisäkkäisen silmukan sisällä.

Sitten toteutin reverse-metodin, minkä tarkoitus on kääntää taulukon alkioiden järjestys päinvastaiseksi. Toteutin tämän siten, että vaihdoin while-silmukassaa taulukon pienimmän indeksin ja suurimman indeksin paikat keskenään. Joka kierroksella pienin indeksi kasvaa yhdellä ja suurin pienenee yhdellä ja sitä tehdään niin kauan kun pienempi indeksi on pienempi kuin suurempi indeksi.
Koko taulukon kattavan reverse-metodin pystyi taas toteuttamaan kutsumalla toista reversemetodia oikeilla parametreillä.

Reverse-algoritmin aikakompleksisuusluokka on O(n), koska jokainen taulukon elementti käsitellään yhden kerran. Operaatioiden määrä on siis lineraarisesti riippuvainen taulukon elementtien määrästä.

Jos siis taulukko on valmiiksi nousevassa järjestyksessä, sen uudelleen järjestäminen laskevaan järjestykseen kävisi parhaiten kääntämällä sen järjestys. Tämä siksi, että sen aikakompleksisuus on pienempi jolloin sen suorittaminen voi olla paljon nopeampi ja yksinkertaisempi.

2. askeleessa tutuistuin hieman itse TIRA Coders sovellukseen ja lisäksi luokkiin Coder.java ja SimpleContainer.java, joihin piiti myös toteuttaa pari metodia. 
Ensiksi tein Coders-luokkaan compareTo-metodin:
```Java
@Override
public int compareTo(Coder another) {
		int comparing = this.lastName.compareTo(another.lastName);
    // If the lastnames are same, compare firstnames.
    if (comparing == 0) {
        return this.firstName.compareTo(another.firstName);
    }
    return comparing;
	}
```
Tässä metodissa vertaillaan kahta Coder-oliota keskenään. Ensiksi verrataan olioiden sukunimiä. Jos this-olion sukunimi on aakkosjärjestyksessä pienempi verrattuna another-olioon, comparing on negatiivinen, ja jos se on suurempi, niin comparing on positiivinen. Jos olioilla on sama sukunimi, comparing on nolla ja siirrytään vertailemaan olioiden etunimiä. metodi palauttaa muuttujan comparing arvon.

Viimeiseksi siirryin SimpleContainer-luokkaan toteuttamaan sort-metodin. Tämän toteutin kutstumalla Algorithms-luokan insertionSort-metodia indeksien 0 ja private-muuttujan count väliltä.

Ensimmäinen tehtävä ei aiheuttanut suurempia ongelmia ohjelmoinnin osalta, mutta Githubin käytössä ja siinä miten se toimii VS coden kanssa oli aika paljon opeteltavaa (testit yms.). Tehtävän ohjeet olivat myös joissain kohdissa hieman hankalaa luettavaa.

## 02-TASK
Tässä tehtävässä opin käyttämään comparator- ja predicate-rajapintoja. Niiden käyttäminen on loppujen lopuksi paljon yksinkertaisempaa, kuin se vaikutti ensi silmäykseltä. Tässäkään tehtävässä itse ohjelmointi ei tuottanut hankaluuksia, vaikka pitikin välillä palautella mieleen pari yksinkertaista java-kielen toimintoa.
Kun TIRA Coders sovelluksessa kokeilee eri lajittelutapoja riityminen toisesta lajittelusta toiseen tapahtuu eri nopeutta, riippuen siitä mitä lajitellaan. Esim. Koko nimen perusteella laskevasta järjestyksestä koko nimen nousevaan järjestykseen siirtymisessä voi mennä alle millisekunti, mutta kun siirrytään koko nimen lajittelusta lempinimen lajitteluun, siinä voi mennä jopa yli kaksi sekuntia. Tämä johtuu siitä, että taulukon alkioiden järjestäminen päinvastaiseen järjestykseen käyttää lineaarista reverse-metodia (aikakompleksisuusluokka O(n)), kun muussa tapauksessa joudutaan käymään taas lisäyslajittelu-algoritmi läpi, mikä taas on aikakompleksisuusluokkaa O(n^2).
reverse-metodin suorittamiseen vaadittu aika siis kasvaa lineaarisesti taulukon alkioiden mukaan, kun taas lisäyslajittelu-algoritmin suorittamiseen vaadittu aika kasvaa neliöllisesti aina n^2, kun n = alkioiden määrä. Tämän takia yleisesti ottaen jos aineisto on valmiiksi lajiteltu, sen alkioiden järjestyksen kääntämiseen kannattaa käyttää reverse-algoritmia, koska se on tehokkaampi ajan käytön suhteen.
Toteutettuja hakualgoritmejä kutsutaan lineaarisiksi, koska niiden aikakompleksisuusluokka on O(n), missä kuten aiemmin mainitsin, alkioiden määrä ja suorittamiseen kuluva aika ovat toisistaan lineaarisesti riippuvaisia.

3. Askeleessa toteutin neljä eri lineaarista hakualgoritmia. Tämän jälkeen ajoin testin LinearFindTests. Se meni läpi ensimmäisellä yrityksellä ja tulosti konsoliin taulukon, missä on annettu aikamittauksia täyttöajasta ja hakuajasta eri n määrillä. Tein taulukoista kaksi eri graafia Excel-sovelluksessa, jotka näkyvät alapuolella.

![Fill-kaavio](tira-nfill.png)

![Search-kaavio](tira-nsearch.png)

Toisessa graafissa näkyy täyttöajan kasvu suhteessa n:n kasvuun ja toisessa graafissa on hakuajan kasvu suhteessa n:n kasvuun. Kuten kaavioista voi nähdä, aika kasvaa molemmissa tapauksissa suoraan verrannollisesti n:ään. Tästä voisi tehdä sen päätelmän, että SimpleContainerin täyttöön ja hakuun käytetyt algoritmit on aikakompleksisuusluokkaa O(n). Tämä varmistuu tarkastellessa täyttöön tarkoitettua SimpleContainer.Add metodia, missä on yksi for-silmukka, eli sekin on O(n). Haussa käytetyt algoritmit ovat niitä samoja, mitä tässä tehtävässä aiemmin toteutin, ja ne olivat kaikki myös aikakompleksisuusluokkaa O(n).

## 03-TASK
Kolmannessa tehtävässä opin toteuttamaan puolitushakualgoritmin iteratiivisella tavalla. Se ei tuottanut sen suurempia vaikeuksia kun vähän aikaa pähkäili.

Tehtävän kolmas askel sisältää paljon analysointia ja pohtimista, niistä seuraavaksi.
Latasin TIRA Coders sovellukseen 50 000 koodarin tiedoston ja kokeilin hakumenetelmiä usealla eri tavalla. Huomasin että kun hakee listan alusta kummalla tavalla vain (search tai fast search), sen suorittamiseen ei kulunut edes yhtä millisekuntia. Kun taas menee listan loppupäähän ja kokeilee hakea vain sukunimeä, aikaa kului noin 30-40 ms. Kun taas laittoi hakukenttään koodarin koko nimen, sovellus löysi kyseisen koodarin alle millisekunnissa.
Koodarin hakeminen koko nimellä on nopeampaa, kuin pelkällä sukunimellä hakeminen, sillä siinä käytetään puolitushakualgoritmiä kun taas muutoin käytetään lineaarista hakua. Puolitushakualgoritmin nopeuteen ei vaikuta se, missä kohtaa taulukkoa koodari on, kun taas lineaarinen haku käy yksi kerrallaan taulukon alusta päin koodarit, kunnes löytää "matchaavan" elementin taulukosta.

![Fill-graafi](task3-fill.png)
![Sort-graafi](task3-sort.png)
![Search-graafi](task3-search.png)

Kuten piirtämistäni Excel-graafeista voi päätellä, täyttöaika ja lajitteluaika ovat lineaarisesti riippuvaisia n:n kasvusta (aikakompleksisuusluokka O(n)), eikä sillä onko lista nousevassa vai laskevassa järjestyksessä ole oikeastaan väliä tähän. Hakuaika kuitenkin ei ole lineaarisessa suhteessa n:n kasvuun. Hakuaika pienenee aina logaritmisesti n:n kasvuun verrattuna. Puolitushakualgoritmin aikakompleksisuusluokka on siis O(log n).

## 04-TASK
Tässä tehtävässä tutustuin pinotietorakenteisiin. Askeleessa yksi tein oman toteutukseni pinotietorakenteesta StackImplementation-luokkaan. Tämä ei tuottanut suurempia ongelmia, sillä siihen oli hyvät ohjeet niin tehtävän ohjeissa, kuin luentomateriaalissa. Haastavimpia olivat pop-ja push-metodit.
Ohjeissa annettiin vaatimus, että kaikki pinotietorakenteen metodit pitävät olla aikakompleksisuusluokkaa O(1), paitsi toString O(n) (ja push O(n), kun joudutaan reallokoimaan.). Minun toteutukseni täyttää nämä vaatimukset, sillä capacity-, push-, pop-, peek-, size-, isEmpty-, ja clear-metodin suoritysaika on vakio riippumatta taulukon koosta. toString() on siksi O(n), koska siinä on for-silmukka, joka käy läpi kaikki pinon alkiot.

2. Askeleessa toteutin ParenthesisChecker-koodin, mikä tarkistaa että tiedostossa on sulkuja oikea määrä oikeassa järjestyksessä. Tähän tehtävää vaatikin jo enemmän aikaa ja pähkäilyä, vaikka siihen olikin annettu kattavat ohjeet.
Toteuttaessani sulkujentarkistus- algoritmin, oletin että tarkistettavan kohteen lainausmerkit ovat oikein. Vaikka algoritmissä käsitelläänkin myös lainausmerkkejä, se ei toimi oikein jos kohteen lainausmerkit ovat väärin. Jos vaikka lainausmerkkejä on pariton määrä, algoritmi ei enää laske sulkuja oikein, sillä se olettaa että vielä ollaan lainausmerkkejen sisällä, vaikka niin ei pitäisi olla.

## 05-TASK
Tässä tehtävässä opin käyttämään jonotietorakenteita. Toteutin tämän käyttämällä hyväksi taulukoita, joten osa pinotietorakenne-tehtävän metodeista oli helppo muokata tähän sopiviksi. Yllättäen vaikeinta tehtävässä oli reallokointi-metodin tekeminen, siihen meni eniten aikaa mutta sain koodin toimimaan lopulta ja kaikki metodit ovat vaadittua aikakompleksisuusluokkaa.
Linkitetty lista on taulukkopohjaista toteutusta parempi muistin käytön suhteen, sillä sen kokoa ei tarvitse erikseen määritellä ja se voi muuttaa kokoa tarpeen mukaan. Aikatehokkuudessa linkitetty lista päihittää taulukkototeutuksen silloin, kun pitää poistaa tai lisätä elementtejä keskellä listaa. Tämä johtuu siitä että linkitetyssä listassa elementtejä ei tarvitse siirtää.
Taulukkopohjainen toteutus on muistikompleksisuuden kannalta parempi, jos taulukko on heti alussa alustettu tarpeeksi suureksi (mutta ei kuitenkaan liian suureksi), jotta ei tarvitse reallokoida. Ajan kannalta taulukoiden käyttö on tehokkaampaa, kun lisätään tai poistetaan taulukon alusta tai lopusta.
Toteuttamani jonotietorakenteen metodeissa ei ole käytetty silmukoita siellä missä niitä ei ole sallittu. Kaikki muut metodit ovat aikakompleksisuusluokkaa O(1), paitsi toString()- metodi ja yksityinen reallocate()- metodi, jotka ovat aikakompleksisuusluokkaa O(n).

## 06-TASK
Tässä tehtävässä opin tekemään nopean lajittelualgoritmin. Päätin toteuttaa QuickSort- algoritmin Hoaren menetelmällä. Se eroaa QuickSortista siten, että partition-metodissa valitaan Pivot- arvo keskeltä taulukkoa, minkä jälkeen käytetään kahta indeksiä joista toinen liikkuu taulukkoa vasemmalle ja toinen oikealle.
Kohtasin ongelmia tehtävän testien suorittamisessa. Nopean lajittelualgoritmin testin viimeinen kohta, missä testataan kahden miljoonan koodarin tiedostolla ei mennyt läpi ja ohjelma valitti keko- muistin loppuneen. Lopulta sain ratkaistua tämän ongelman kurssin ohjeita seuraten ja ajaen testit komentoriviltä.

![fastSort_testi](task6_fastSort_test.png)

![slowSort_testi](task6_slowSort_test.png)

Kuten kuvista näkyy, testin mukaan toteuttamani QuickSort algoritmi toimii huomattavasti nopeammin, kuin aikaisemmin tehty insertionSort algoritmi. insertionSortin testissä kohdassa 6 ajettiin testi aineistolla, jonka koko on 100000. Algoritmi kävi taulukon elementit läpi nopeudella 6.837 ms/elementti. FastSort kävi saman tiedoston läpi 0.003 ms/elementti nopeudella. kahden miljoonan koodarin tiedoston testi kävikin vähän työläämmäksi tekemälleni algoritmille ja se selvisi siitä noin kolmessa minuutissa (saattaa myös johtua tietokoneestani). On se kuitenkin paljon nopeampi kuin mitä insertionSort olisi siitä selvinnyt.
Tekemäni Hoaren QuickSort- algoritmin aikakompleksisuusluokka on yleensä O(n log n). Se kuitenkin riippuu siitä, mikä pivot-alkioksi valikoituu. Pahin tapaus olisi se, että pivot-alkioksi sattuu tulemaan taulukon pienin tai suurin alkio. Silloin algoritmin aikakompleksisuusluokka voi olla jopa O(n^2).
Tämän takia siis QuickSort- algoritmi on niin paljon nopeampi kuin insertionSort- algoritmi, sillä insertionSort- algoritmin aikakompleksisuusluokka on O(n^2), mikä on huomattavasti huonompi kuin O(n log n).

![ms/element](task6_mselement.png)

Tekemäni graafi havainnollistaa miten nopeasti insertionSort- algoritmin suoritusnopeus kasvaa verrattuna quickSort- algoritmiin. Huomioitavaaa on, että insertionSort- algoritmia ei edes testattu kuin 100000 koodarin tiedostolla maksimissaan.

## 07-TASK
Tässä tehtävässä opin miten binäärinen hakupuu toimii, sekä siinä samalla lisäsin tietämystäni rekursiosta. Tämä tehtävä jo vaati minulta huomattavasti enemmän aiheeseen perehtymistä, enkä voinut alkaa samantien vain koodaamaan luettuani ohjeet. Onneksi kurssimateriaalista, luennoilta ja netistä löytyi paljon tietoa aiheesta ja myös esimerkkejä miten sen voi toteuttaa.
Helpointa oli tehdä add ja get metodit. Vaikeinta tehtävässä oli saada indeksit pelaamaan oikein.

Add ja get metodit on toteutettu samalla tekniikalla, kuin luennoilla esitettiin. Esimerkiksi lisäyksessä BST:n puolella tarkistetaan ensin voiko puuhun lisätä, tai että onko puuta vielä ylipäätään olemassa. Sitten TreeNode luokassa etsitään rekursiivisesti vertailemalla sille oikea paikka comparatoria käyttäen.

ToArray metodiin sovelsin luentomateriaalissa esitettyä In-order traversal tapaa. BST:ssä luon taulukon, missä on key-value pareja, sekä luon AtomicIntegerin, mikä laskee indeksin. TreeNodessa tapahtuu sitten itse puussa liikkuminen In-order tavalla samalla kun AtomicInteger laskee indeksin.

Toteutin lopulta muutkin metodit tällä In-order tavalla. Tätä AtomicIntegeriä käytin muissakin metodeissa, missä piti tehdä jotain indeksin perusteella. Sen käyttämisessä oli vähän opeteltavaa, mutta se on todella kätevä juuri tämän tyyppisiin tehtäviin.

| BST Elements (n) | Add time | Add time/item | To sorted array time | Search time | Search time/item | get(index) time | get(index time/item) |
|--------------|----------|---------------|----------------------|-------------|------------------|-----------------|----------------------|
| 100          | 1        | 0.100         | 0                    | 4           | 0.0400           | 2               | 0.0200               |
| 1000         | 2        | 0.0020        | 1                    | 2           | 0.0020           | 9               | 0.0090               |
| 5000         | 9        | 0.0018        | 1                    | 5           | 0.0010           | 150             | 0.0300               |
| 10000        | 8        | 0.0008        | 1                    | 8           | 0.0008           | 588             | 0.0588               |
| 50000        | 55       | 0.0011        | 2                    | 51          | 0.0010           | 25165           | 0.5033               |
| 100000       | 128      | 0.0013        | 5                    | 119         | 0.0012           | 133193          | 1.3319               |

Yllä olevasta taulukosta näkyy se, miten BST toteutukseni suoriutuu testeistä minun tietokoneellani. Toteuttamani algoritmien kuten add ja get aikakompleksisuusluokka riippuu puun korkeudesta ja sen tasapainosta. itse aikakompleksisuusluokka on O(h), missä h on puun korkeus. Tämä tarkoittaa sitä, että se on pahimmassa tapauksessa aikakompleksisuusluokkaa O(n) ja parhaimmassa tapauksessa O(log n). Kaikki algoritmit on toteutettu A toteutustavalla.

Taulukko puun maksimisyvyydestä:
| Elements (n) | Maksimisyvyys |
|--------------|-----------------------|
| 10           | noin 4                |
| 100          | noin 7                |
| 1000         | noin 10               |
| 5000         | noin 13               |
| 10000        | noin 14               |
| 50000        | noin 16               |
| 100000       | noin 17               |
| 1000000      | noin 20               |
| 2000000      | noin 21               |

Alla näkyy miten taulukkopohjainen toteutus suoriutui testeistä 50 000:n koodarin aineistolla. Lisäksi piirsin Add timestä pari kaaviota.

| Simple container Elements (n) | Add time | Add time/item | To sorted array time | Search time | Search time/item | get(index) time | get(index time/item) |
|--------------|----------|---------------|----------------------|-------------|------------------|-----------------|----------------------|
| 50000        | 56839    | 1.1368        | 46                   | 68          | 0.0014           | 7               | 0.0001               |

![BST Add time](BSTaddtime.png)
![Simple container Add time](SCaddtime.png)

Kuten kuvista näkee, BST suoriutuu huomattavasti nopeammin elementtien lisäämisessä. Kuitenkin BST:n indeksillä hakeminen on hitaampi kuin taulukkopohjaisessa toteutuksessa. Tämä johtuu siitä, että binäärisellä hakupuulla ei ole valmiita indeksejä, vaan ne pitää itse laskea. Minun toteutuksellani tämä aikakompleksisuusluokka on parhaassa tapauksessa O(log n) ja huonoimmassa tapauksessa O(n). Taulukkopohjaisessa toteutuksessa indeksillä hakeminen toimii nopeammin, sillä siinä voi suoraan hakea tietyllä indeksillä olevaa elementtiä (O(1)).

## 08-TASK

Tässä tehtävässä perehdyin hajautustauluihin. Toteutin oman hajautusfunktion, mikä laskee jokaiselle uniikille id:lle oman tiivisteen, mistä sitten lasketaan kyseiselle objektille oma indeksi, jotta se voidaan sijoittaa taulukkoon. Yritin monia eri tekniikoita tämän hajautusfunktion luomiseen, esimerkiksi bittisiirtoja, XOR-operaatiota ja muita laskentamenetelmiä. Lopulta Sain aikaan sellaisen funktion, missä ensimmäisten törmäysten määrä on keskimäärin vähän alle 30 %. Se ei varmasti ole paras mahdollinen, mutta mielestäni ihan ok. Alla vielä hajautusfunktion koodi.
```Java
@Override
	public int hashCode() {
		int hash = 0;
        int length = id.length();
        for (int index = 0; index < length; index++) {
            int current = id.charAt(index);
            hash ^= current;
            hash = (hash << 5) - hash;
		}
        return hash;
	}
```

Hajautustaulun muut funktiot oli suhteellisen helppo toteuttaa, kun ensin katsoi luentotallenteet ja muut materiaalit aiheesta. Päädyin toteuttamaan indeksin laskemisen quadratic probing tekniikalla, eli siinä plussataan hash-valueen törmäysten määrä korotettuna toiseen potenssiin, minkä jälkeen sille tehdään muut tarvittavat operaatiot (muuttaminen positiiviseksi ja taulukon kokoon sovittaminen). Totesin tämän vähentävän törmäysten määrää verrattuna lineraariseen luotaamiseen.
Hashtable performancetest mittauksen tulokset:
| Elements | Add time (ms) | Add time per item (ms) | To array and sorting (ms) | Search time (ms) | Search time per item (ms) | Test file                        |
|----------|---------------|-------------------------|---------------------------|------------------|-------------------------------|----------------------------------|
| 100      | 2             | 0.0200                  | 2                         | 9                | 0.0900                        | 100-city-coders.json             |
| 1000     | 3             | 0.0030                  | 8                         | 3                | 0.0030                        | 1000-area-coders.json            |
| 5000     | 10            | 0.0020                  | 8                         | 3                | 0.0006                        | 5000-town-coders.json            |
| 10000    | 17            | 0.0017                  | 24                        | 8                | 0.0008                        | 10000-large-city-coders.json     |
| 50000    | 134           | 0.0027                  | 105                       | 40               | 0.0008                        | 50000-country-coders.json        |
| 100000   | 263           | 0.0026                  | 205                       | 72               | 0.0007                        | 100000-europe-coders.json        |
| 1000000  | 2416          | 0.0024                  | 3311                      | 623              | 0.0006                        | 1000000-global-coders.json       |

Kun näitä vertaa esimerkiksi task 7 BST:n mittaustuloksiin, huomaa että tämä on hitaampi kuin se. Esimerkiksi add metodi on kyllä muuten O(1) aikakompleksisuusluokkaa, mutta koska käytetään taulukoita, taulukko pitää välillä reallokoida, minkä aikakompleksisuusluokka on O(n). Lisäksi lisäämisen nopeuteen vaikuttaa hajautusfunktion toteutus. Jos törmäyksiä sattuu liikaa se voi hidastaa huomattavasti sen toimintaa. Myös esimerkiksi toArray() on aikakompleksisuusluokkaa O(n), sillä se iteroi koko taulukon läpi. Hajautustauluilla on kuitenkin se parempi puoli, että se laskee elementille indeksin paljon nopeammin, kuin BST. BST:ssä joudutaan käydä läpi lähes koko puu, kunnes löydetään haluttu indeksi, kun taas hajautustauluissa voidaan nopeasti vain laskea id:n perusteella sen tiivisteen arvo ja siten indeksi.
Alla näyte siitä, miten nopeasti simple keyed container suoriutuu 100 000:n koodarin aineistolla:

| Elements | Add time (ms) | Add time per item (ms) | To array and sorting (ms) | Search time (ms) | Search time per item (ms) | Test file                  |
|----------|---------------|-------------------------|---------------------------|------------------|-------------------------------|-----------------------------|
| 100000   | 61            | 0.0006                  | 78                        | 133286           | 1.3329                        | 100000-europe-coders.json  |

Jos tätä vertailee siihen mitä hashtablen mittaus tulosti 100 000:n koodarin aineistosta voi esimerkiksi havaita, että hashtable on muuten hitaampi, paitsi että sen search time on paljon paljon nopeampi. Hashtablen get ja find metodit ovatkin aikakompleksisuusluokkaa O(1) (törmäysten määrä kylläkin nostaa tätä vähän).

Alla vielä piirtämäni graafit Hajautustaulun lisäämiseen ja hakemiseen kuluvasta ajasta aineistoittain.

![hashtable add time](hashtableaddtime.png)

![hashtable search time](hashtablesearch.png)

Kun olin saanut hajautustaulun tomimaan, siirryin toteuttamaan CodeWordsCounter ohjelmaa, mikä laskee sanojen määrän aineistoista. Tämä oli suhteellisen helppo toteuttaa, kun vain seurasi ohjeita mitkä sinne oli valmiiksi kommentoitu. Ajoin ohjelman kansiossa, missä minulla on joitain python kielen koodeja ja sain aikaan tällaisen taulukon. Sen mukaan käytetyin sana siellä on "def", mikä sopii kuvaan.

![Codeword counter](codewords.png)

## 09-TASK

Tässä tehtävässä opin, miten verkkoja voi käyttää ohjelmoinnissa. Toteutin Tästä tehtävästä muut metodit, paitsi Dijkstran lyhyimmän polun algoritmin. Aloitin tehtävän paneutumalla ensiksi aiheen luentomateriaaleihin ja demoihin, mistä olikin paljon apua. Sen jälkeen aloin toteuttamaan perusmetodeja, joiden avulla verkon luominen toimii.

Perusmetodien luomisessa en kohdannut suurempia haasteita, vähän piti muistella että miten jotkut Javan tietosäiliöluokat toimivat. Perusmetodien jälkeen aloin toteuttamaan leveyshaku-algoritmia. Tein sen alun perin seuraamalla luentojen demojen c-kielen esimerkkiä samanlaisesta algoritmista, mutta muuntelin sitä hieman, jotta voin käyttää sitä myös disconnectedVertices funktiossa. Siinä oli kätevä käyttää leveyshaku-algoritmia antamatta sille etsittävää kohdetta ollenkaan, jolloin se käy käytännössä koko verkon läpi ellei verkko ole disconnected.

Leveyshakualgoritmissa tutkitaan lähtö-vertexistä lähtien kaikki haaraumat yhtä aikaa. Eli vertexistä mennään reunaa pitkin toiseen vertexiin, mistä taas lähtee usempi reuna muihin vertexeihin ja niin edelleen.

Syvyyshaku-algoritmikin oli helppo toteuttaa vain seuraamalla demon ohjeita. Sitä piti vähän sovittaa toimimaan java-kielen kanssa, mutta sain sen lopulta toimimaan suhteellisen hyvin. Siinä siis mennään reunoja pitkin niin syvälle kun pääsee. Kun ei enää pääse syvemmälle mennään ikään kuin takaperin edelliseen vertexiin ja mennään taas toista haaraa pitkin niin syvälle kuin pääsee. Tätä toistetaan niin kauan kunnes etsittävä kohde löytyy.

disconnnectedVertices-metodin toteutin käytännössä siten, että se käy leveyshaku-algoritmillä läpi jostain vertexistä lähtien verkon niin pitkälle kuin pääsee ja katsoo jäikö joku vertex käymättä läpi. Jos jäi, niin verkko on disconnected. isDisconnected-metodi taas tarkistaa onko graafi connected vai disconnected kutsumalla disconnectedVertices-metodia.

Lopulta vielä toteutin metodin hasCycles, mikä tarkistaa onko verkossa syklejä. Tähän piti tehdä pari apu-algoritmia, sillä syklien tarkistus menee eritavalla riippuen siitä, ovatko reunat suunnattu vai ei. Nimittäin jos reuna on suuntaamaton, vertexistä A pääsee vertexiin B ja toisin päin. Tämä ei kuitenkaan tarkoita että verkossa on sykli.

Ensin toteutin metodin directedHasCycles, mikä tarkistaa suunnatuilla reunoilla, että onko verkko syklinen vai ei. Se toimii niin että tallennetaan listaan kaikki vertexit sitä mukaan kun niitä läpi ja jos törmätään johonkin vertexiin uudestaan, verkko on syklinen. UndirectedHasCycles toimii muuten samalla tavalla, mutta muuntelin sitä niin että se ei tulkitse vertexien välistä edestakaista kulkemista sykliksi.

En enää lähtenyt toteuttamaan Dijkstran algoritmia, sillä totesin tämän riittävän minulle. Korjasin kuitenkin verkon täytön hitauden tehtävänannon ohjeiden mukaisesti. Se muuttikin kivasti aikaisemman O(n^3)-operaation aikakompleksisuuden uudeksi aikakompleksisuudeksi O(1).
Alhaalla on taulukko GraphPerformanceTest mittausten tuloksista:

| Vertice count | Edge count | Fill time (ms) | Fill time/V+E (ms) | BFS time (ms) | DFS time (ms) | Dijkstra time (ms) | Testfile                           |
|---------------|------------|----------------|---------------------|---------------|---------------|---------------------|------------------------------------|
| 10            | 40         | 2              | 0.0400              | 0             | 0             | 0                   | 10-village-coders.json            |
| 100           | 532        | 3              | 0.0047              | 2             | 2             | 0                   | 100-city-coders.json              |
| 1000          | 5613       | 7              | 0.0011              | 22            | 19            | 0                   | 1000-area-coders.json             |
| 5000          | 27602      | 54             | 0.0017              | 343           | 492           | 0                   | 5000-town-coders.json             |
| 10000         | 56551      | 39             | 0.0006              | 1273          | 1429          | 0                   | 10000-large-city-coders.json      |
| 50000         | 280174     | 410            | 0.0012              | 161816        | 169512        | 0                   | 50000-country-coders.json         |

Kuten näkyy, Fill time pysyy todella maltillisena verrattuna siihen, että ennen lisäysfunktion korjaustoimia 50 000 koodarin testiaineistolla meni yli 15 minuuttia täyttää verkko. Alla kuva piirtämästäni graafista BFS ja DFS algoritmien ajamiseen kuluneesta ajasta.

![BFS ja DFS time](BFS-DFS-time.png)

Kuten graafista näkyy, ne toimivat aikalailla yhtä nopeasti, joskin ajettuani tämän testin useammin BFS (leveyshaku) toimi yleensä nopeammin kuin DFS (syvyyshaku). BFS siis löytää kohteen verkosta yleensä tehokkaammin.

Käytin toteutuksessani HashMap:ia Hashtablen sijaan. Kokeilin mitä tapahtuu testien aikamittauksille jos käyttääkin Hashtablea ja tulin siihen tulokseen että alkuperäinen HashMap toteutukseni on vähän nopeampi.

createVertex, getVertices, addEdge, addDirectedEdge ja getEdges aikakompleksisuudeltaan O(1).
leveyshaun aikakompleksisuus on O(V+E), missä V=vertex ja E=edge. Se siis käy verkon läpi jokaisen solmun ja reunan kautta korkeintaan yhden kerran.
Metodit, mitkä tutkii onko verkko connected vai disconnected on myös O(E+V), koska siinä käytetään leveyshaku-algoritmia. Taas siis käydään jokainen solmu ja reuna läpi korkeintaan kerran.
Syvyyshaun aikakompleksisuus on myös O(V+E), sillä siinäkin käydään jokainen solmu kerran läpi reunojen kautta.
hasCycles metodin aikakompleksisuus on O(V+E). Siinä käytetään DFS tekniikaa solmujen läpikäymiseen, minkä aikakompleksisuus on myös O(v+E)