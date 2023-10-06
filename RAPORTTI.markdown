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

Viimeiseksi siirryin SimpleContainer-luokkaan toteuttamaan sort-metodin. Tässä metodissa siirrän for loopissa taulukon alkuun kaikki ne elementit, jotka eivät ole null-arvoisia. Sitten lajittelen taulukon alun ei-null elementit insertionSort-metodilla. Lopuksi muutan lajitellun taulukon jälkeiset elementit null-arvoisiksi.

Ensimmäinen tehtävä ei aiheuttanut suurempia ongelmia ohjelmoinnin osalta, mutta Githubin käytössä ja siinä miten se toimii VS coden kanssa oli aika paljon opeteltavaa (testit yms.). Tehtävän ohjeet olivat myös joissain kohdissa hieman hankalaa luettavaa.

## 02-TASK

## 03-TASK

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK