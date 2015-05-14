####Aihe 
Videoanalyysien harjoittelu- ja tallennussovellus vedenalaisen meriluonnon monimuotoisuuden inventointiohjelman (VELMU) käyttöön

####Taustaa
Vedenalaisen meriluonnon monimuotoisuuden inventointiohjelma VELMU kartoittaa eliölajien ja luontotyyppien esiintymistä Suomen merialueilla. Tietoa kerätään muun muassa sukeltamalla, videokuvaamalla ja pohjaeläinnäytteenotolla. Näytepisteiden lukumäärällä katsottuna eniten käytetty menetelmä on ns. drop-video, jossa korkearesoluutioisella videokameralla (HD-kamera) kuvataan merenpohjasta 100 metrin pituinen linja. Drop-videoista analysoidaan pohjanlaatu ja eri eliöryhmien tai lajien esiintyminen sekä niiden peittävyys. Peittävyys kirjataan lajista riippuen joko prosentteina tai luokiteltuna arvona. Videoita on yleensä katsottu VLC-playerilla tai vastaavalla ja videoista analysoidut tiedot on kirjattu paperille taulukkoon, josta myöhemmin kerätty Exceliin. Sovellus, jolla voitaisiin harjoitella analyysien tekemistä ja mahdollisesti jopa tehdä itse analyyseja voisi siis olla hyödyllinen. 

SYKEssä on ROV-videoiden (Remotely Operated Vehicle, vedenalainen robottivideokamera) analyyseissa käytetty Norjan merentutkimuslaitoksen sovellusta nimeltä Video Navigator, jolla tehtäviin kirjauksiin voidaan yhdistää paikkatieto. Paikkatieto saadaan erillisen ohjelman tekemistä csv-tiedostoista ja videota katsottaessa ohjelma antaa paikkatiedon timestampin perusteella videon näkymälle koordinaatit. Video Navigatorin ongelma on, että se toimii miten kuten mutta kehitys on lopetettu - esimerkiksi analyysitietojen tallennustapoja ei voida enää muuttaa vaan tuotettuja tiedostoja pitää vaivalloisesti muokata jälkikäteen Excelissä, jotta tiedot saadaan nykyisiin tietokantoihin vietävään muotoon. Myös ns. navitiedostojen eli paikkatiedon sisältävien tiedostojen käsittelyyn joudutaan käyttämään useita eri ohjelmia. ROVin paikannuslaitteiston valmistaja Tritech tarjoaa laitteiston tallentamien lokitiedostojen muokkaamiseen omat sovelluksensa (SeaNet Tools), joista SeaNet DumpLog -sovelluksella lokitiedostot käännetään .csv -tiedostoiksi, jotka sisältävät laitteiston tallentamaa tietoa kuten timestampin ja ROVin koordinaatit. Tiedostot on yhdistetty Excelissä VBA:lla yhdeksi tiedostoksi, joka on muokattu R:n käyttöön sopivaksi. R:ssä tiedosto on käsitelty scriptillä, joka merkkaa ns. harhapaikannuksen FALSE-arvolla. Nämä syntyvät paikannuksen epätarkkuudesta johtuen (harhapingit ym) ja tunnistetaan timestampin ja etäisyyden perusteella siten, että arvot joissa ROVin laskettu nopeus on liian suuri hylätään. Tämän harha-arvojen poiston eli ns. smoothauksen voisi mieluummin hoitaa yhdellä sovelluksella ilman hankalia .csv - ecxel - R - excel - VideoNavigator -muokkauksia. Lisäksi drop-videoissa on mahdollisuus nauhoittaa paikkatietoa mutta tätä ei toistaiseksi ole laitteisto-ongelmien takia tehty. Jatkossa paikkatiedon yhdistämiseen myös drop-videoihin voisi kuitenkin olla tarvetta.    

####Tavoite
Kurssin puitteissa tuotetaan videotiedostoja näyttävä sovellus, jolla voidaan:
  - Harjoittelumoodissa kirjata analyysitietoja ja verrata niitä etukäteen määritettyihin arvoihin sekä pitää kirjaa harjoittelijan edistyksestä (viimeisimmän videon tulos, keskiarvoja) 
  - Ylläpitomoodissa voidaan lisätä harjoiteltavia videoita ja niiden analyysitietoja, joihin harjoittelutuloksia verrataan.

Mikäli mahdollista, sovelluksessa voidaan myös:
  - Analyysimoodissa tallentaa kirjattuja analyysitietoja halutussa muodossa (VELMU 2015 analyysiExcel -yhteensopiva tekstitiedosto tai LajiGIS -sisäänsyöttötaulukko) 

Lisäksi selvitetään mahdollisuuksia laajentaa sovellusta hyödyntämään paikannustietoja Tritechin tuottamassa muodossa ja drop-videokameroiden ohjelmiston tuottamassa muodossa. 

####Käyttäjät
VELMU-ohjelmassa videotietojen keräämiseen ja analysointiin osallistuvat tahot (Metsähallitus, SYKE, ELY-keskukset, konsultit). 
Kolme erillistä käyttäjätapausta: 
  - Harjoittelija
  - Analysoija
  - Ylläpitäjä

#### Kaikkien käyttäjien toiminnot
  - Sisäänkirjautuminen
  - Videoanalyysien harjoittelu
  - Harjoittelutulosten ja videoiden arvojen vertailu
  - Harjoittelutulosten ja niiden tilastotietojen tarkastelu
  - Omien harjoittelutulosten nollaus

#### Harjoittelijan toiminnot
  - Sisäänkirjautuminen
  - Videoanalyysien harjoittelu
    - Merialueen valinta
    - Videanalyysitulosten kirjaus ja tulosten katselu

####Analysoijan toiminnot
  - Sisäänkirjautuminen
  - Videoanalyysien tekeminen ja tulosten tallentaminen

####Ylläpitäjän toiminnot
  - Sisäänkirjautuminen
  - Uusien harjoitteluvideoiden ja niiden analyysitietojen lisääminen
    - Lisättävän videon merialueen syöttö
    - Lisättävän videon analyysitietojen syöttö

*Uusien videoiden ja niiden analyysitietojen lisääminen* - harjoitusvideoita on jossain vaiheessa tarvetta lisätä. Itse sovelluksessa tuskin tarvitaan videoille erillistä import-toimintoa vaan videot voi kopioida suoraan videohakemistoon. Samoin voisi toimia myös esimerkkianalyysitiedot sisältävän tekstitiedoston kanssa mutta tämä vaatii tarkkuutta je perehtyneisyyttä - arvojen ja otsikoiden lisääminen teksti- tai .csv -tiedostoihin on hankalaa ja virheitä voi sattua. Vaihtoehtona voisi olla siis että harjoitusvideoille lisätään analyysitiedot ohjelman kautta siten, että video analysoidaan kuten harjoituksessa mutta tiedot tallennetaan videoiden analyysitiedot sisältävään tiedostoon. Tällöin ei ole tarvetta sörkkiä tiedostoja tekstieditorilla tai Excelillä. 


####Haasteita
*Näytön koko* - työskentely tapahtuu useimmiten läppärillä, joten videokuvan ja analyysiin tarkoitettavan ikkunan sovittaminen näytölle voi olla hankalaa. 

*Videoiden koko* - jos ohjelmapaketti sisältää esimerkkivideot, tulee siitä sitä suurempi mitä enemmän videoita on. Yksi mahdollisuus olisi striimata videot jostain (esim. Youtube) mutta koska työskentely tapahtuu monesti kentällä huonon tai olemattoman nettiyhteyden äärellä, tämä tuskin on järkevä vaihtoehto. Ensimmäisessä vaiheessa (tämä kurssilla tehtävä Java-versio) siis toteutaan paikallisena eli siten, että videot ja niiden tiedot jaetaan ohjelman mukana. Jatkossa jos sovelluksesta halutaan online-versio, voidaan videot viedä ympäristöhallinnon palvelimelle tai striimauspalveluun (esim. Youtube). 
