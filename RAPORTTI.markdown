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
reverse-metodin suorittamiseen vaadittu aika siis kasvaa lineaarisesti taulukon alkioiden mukaan, kun taas lisäyslajittelu-algoritmin suorittamiseen vaadittu aika kasvaa eksponentiaalisesti aina n^2, kun n = alkioiden määrä. Tämän takia yleisesti ottaen jos aineisto on valmiiksi lajiteltu, sen alkioiden järjestyksen kääntämiseen kannattaa käyttää reverse-algoritmia, koska se on tehokkaampi ajan käytön suhteen.
Toteutettuja hakualgoritmejä kutsutaan lineaarisiksi, koska niiden aikakompleksisuusluokka on O(n), missä kuten aiemmin mainitsin, alkioiden määrä ja suorittamiseen kuluva aika ovat toisistaan lineaarisesti riippuvaisia.

3. Askeleessa toteutin neljä eri lineaarista hakualgoritmia. Tämän jälkeen ajoin testin LinearFindTests. Se meni läpi ensimmäisellä yrityksellä ja tulosti konsoliin taulukon, missä on annettu aikamittauksia täyttöajasta ja hakuajasta eri n määrillä. Tein taulukoista kaksi eri graafia Excel-sovelluksessa, jotka näkyvät alapuolella.

[!Fill-kaavio](tira-nfill.png)

[!Search-kaavio](tira-nsearch.png)

Toisessa graafissa näkyy täyttöajan kasvu suhteessa n:n kasvuun ja toisessa graafissa on hakuajan kasvu suhteessa n:n kasvuun. Kuten kaavioista voi nähdä, aika kasvaa molemmissa tapauksissa suoraan verrannollisesti n:ään. Tästä voisi tehdä sen päätelmän, että SimpleContainerin täyttöön ja hakuun käytetyt algoritmit on aikakompleksisuusluokkaa O(n). Tämä varmistuu tarkastellessa täyttöön tarkoitettua SimpleContainer.Add metodia, missä on yksi for-silmukka, eli sekin on O(n). Haussa käytetyt algoritmit ovat niitä samoja, mitä tässä tehtävässä aiemmin toteutin, ja ne olivat kaikki myös aikakompleksisuusluokkaa O(n).

## 03-TASK
Kolmannessa tehtävässä opin toteuttamaan puolitushakualgoritmin iteratiivisella tavalla. Se ei tuottanut sen suurempia vaikeuksia kun vähän aikaa pähkäili.

Tehtävän kolmas askel sisältää paljon analysointia ja pohtimista, niistä seuraavaksi.
Latasin TIRA Coders sovellukseen 50 000 koodarin tiedoston ja kokeilin hakumenetelmiä usealla eri tavalla. Huomasin että kun hakee listan alusta kummalla tavalla vain (search tai fast search), sen suorittamiseen ei kulunut edes yhtä millisekuntia. Kun taas menee listan loppupäähän ja kokeilee hakea vain sukunimeä, aikaa kului noin 30-40 ms. Kun taas laittoi hakukenttään koodarin koko nimen, sovellus löysi kyseisen koodarin alle millisekunnissa.
Koodarin hakeminen koko nimellä on nopeampaa, kuin pelkällä sukunimellä hakeminen, sillä siinä käytetään puolitushakualgoritmiä kun taas muutoin käytetään lineaarista hakua. Puolitushakualgoritmin nopeuteen ei vaikuta se, missä kohtaa taulukkoa koodari on, kun taas lineaarinen haku käy yksi kerrallaan taulukon alusta päin koodarit, kunnes löytää "matchaavan" elementin taulukosta.

[!Fill-graafi](task3-fill.png)
[!Sort-graafi](task3-sort.png)
[!Search-graafi](task3-search.png)

Kuten piirtämistäni Excel-graafeista voi päätellä, täyttöaika ja lajitteluaika ovat lineaarisesti riippuvaisia n:n kasvusta (aikakompleksisuusluokka O(n)), eikä sillä onko lista nousevassa vai laskevassa järjestyksessä ole oikeastaan väliä tähän. Hakuaika kuitenkin ei ole lineaarisessa suhteessa n:n kasvuun. Hakuaika pienenee aina logaritmisesti n:n kasvuun verrattuna. Puolitushakualgoritmin aikakompleksisuusluokka on siis O(log n).

## 04-TASK
Tässä tehtävässä tutustuin pinotietorakenteisiin. Askeleessa yksi tein oman toteutukseni pinotietorakenteesta StackImplementation-luokkaan. Tämä ei tuottanut suurempia ongelmia, sillä siihen oli hyvät ohjeet niin tehtävän ohjeissa, kuin luentomateriaalissa. Haastavimpia olivat pop-ja push-metodit.
Ohjeissa annettiin vaatimus, että kaikki pinotietorakenteen metodit pitävät olla aikakompleksisuusluokkaa O(1), paitsi toString O(n) (ja push O(n), kun joudutaan reallokoimaan.). Minun toteutukseni täyttää nämä vaatimukset, sillä capacity-, push-, pop-, peek-, size-, isEmpty-, ja clear-metodin suoritysaika on vakio riippumatta taulukon koosta. toString() on siksi O(n), koska siinä on for-silmukka, joka käy läpi kaikki pinon alkiot.

2. Askeleessa toteutin ParenthesisChecker-koodin, mikä tarkistaa että tiedostossa on sulkuja oikea määrä oikeassa järjestyksessä. Tähän tehtävää vaatikin jo enemmän aikaa ja pähkäilyä, vaikka siihen olikin annettu kattavat ohjeet.
Toteuttaessani sulkujentarkistus- algoritmin, oletin että tarkistettavan kohteen lainausmerkit ovat oikein. Vaikka algoritmissä käsitelläänkin myös lainausmerkkejä, se ei toimi oikein jos kohteen lainausmerkit ovat väärin. Jos vaikka lainausmerkkejä on pariton määrä, algoritmi ei enää laske sulkuja oikein, sillä se olettaa että vielä ollaan lainausmerkkejen sisällä, vaikka niin ei pitäisi olla.

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK