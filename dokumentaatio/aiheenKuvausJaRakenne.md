####Aihe 
Videoanalyysien harjoittelu- ja tallennussovellus vedenalaisen meriluonnon monimuotoisuuden inventointiohjelman (VELMU) k�ytt��n

####Taustaa
Vedenalaisen meriluonnon monimuotoisuuden inventointiohjelma VELMU kartoittaa eli�lajien ja luontotyyppien esiintymist� Suomen merialueilla. Tietoa ker�t��n muun muassa sukeltamalla, videokuvaamalla ja pohjael�inn�ytteenotolla. N�ytepisteiden lukum��r�ll� katsottuna eniten k�ytetty menetelm� on ns. drop-video, jossa korkearesoluutioisella videokameralla (HD-kamera) kuvataan merenpohjasta 100 metrin pituinen linja. Drop-videoista analysoidaan pohjanlaatu ja eri eli�ryhmien tai lajien esiintyminen sek� niiden peitt�vyys. Peitt�vyys kirjataan lajista riippuen joko prosentteina tai luokiteltuna arvona. Videoita on yleens� katsottu VLC-playerilla tai vastaavalla ja videoista analysoidut tiedot on kirjattu paperille taulukkoon, josta my�hemmin ker�tty Exceliin. Sovellus, jolla voitaisiin harjoitella analyysien tekemist� ja mahdollisesti jopa tehd� itse analyyseja voisi siis olla hy�dyllinen. 

SYKEss� on ROV-videoiden (Remotely Operated Vehicle, vedenalainen robottivideokamera) analyyseissa k�ytetty Norjan merentutkimuslaitoksen sovellusta nimelt� Video Navigator, jolla teht�viin kirjauksiin voidaan yhdist�� paikkatieto. Paikkatieto saadaan erillisen ohjelman tekemist� csv-tiedostoista ja videota katsottaessa ohjelma antaa paikkatiedon timestampin perusteella videon n�kym�lle koordinaatit. Video Navigatorin ongelma on, ett� se toimii miten kuten mutta kehitys on lopetettu - esimerkiksi analyysitietojen tallennustapoja ei voida en�� muuttaa vaan tuotettuja tiedostoja pit�� vaivalloisesti muokata j�lkik�teen Exceliss�, jotta tiedot saadaan nykyisiin tietokantoihin viet�v��n muotoon. My�s ns. navitiedostojen eli paikkatiedon sis�lt�vien tiedostojen k�sittelyyn joudutaan k�ytt�m��n useita eri ohjelmia. ROVin paikannuslaitteiston valmistaja Tritech tarjoaa laitteiston tallentamien lokitiedostojen muokkaamiseen omat sovelluksensa (SeaNet Tools), joista SeaNet DumpLog -sovelluksella lokitiedostot k��nnet��n .csv -tiedostoiksi, jotka sis�lt�v�t laitteiston tallentamaa tietoa kuten timestampin ja ROVin koordinaatit. Tiedostot on yhdistetty Exceliss� VBA:lla yhdeksi tiedostoksi, joka on muokattu R:n k�ytt��n sopivaksi. R:ss� tiedosto on k�sitelty scriptill�, joka merkkaa ns. harhapaikannuksen FALSE-arvolla. N�m� syntyv�t paikannuksen ep�tarkkuudesta johtuen (harhapingit ym) ja tunnistetaan timestampin ja et�isyyden perusteella siten, ett� arvot joissa ROVin laskettu nopeus on liian suuri hyl�t��n. T�m�n harha-arvojen poiston eli ns. smoothauksen voisi mieluummin hoitaa yhdell� sovelluksella ilman hankalia .csv - ecxel - R - excel - VideoNavigator -muokkauksia. Lis�ksi drop-videoissa on mahdollisuus nauhoittaa paikkatietoa mutta t�t� ei toistaiseksi ole laitteisto-ongelmien takia tehty. Jatkossa paikkatiedon yhdist�miseen my�s drop-videoihin voisi kuitenkin olla tarvetta.    

####Tavoite
Kurssin puitteissa tuotetaan videotiedostoja n�ytt�v� sovellus, jolla voidaan:
  - Harjoittelumoodissa kirjata analyysitietoja ja verrata niit� etuk�teen m��ritettyihin arvoihin sek� pit�� kirjaa harjoittelijan edistyksest� (viimeisimm�n videon tulos, keskiarvoja) 
  - Yll�pitomoodissa voidaan lis�t� harjoiteltavia videoita ja niiden analyysitietoja, joihin harjoittelutuloksia verrataan.

Mik�li mahdollista, sovelluksessa voidaan my�s:
  - Analyysimoodissa tallentaa kirjattuja analyysitietoja halutussa muodossa (VELMU 2015 analyysiExcel -yhteensopiva tekstitiedosto tai LajiGIS -sis��nsy�tt�taulukko) 

Lis�ksi selvitet��n mahdollisuuksia laajentaa sovellusta hy�dynt�m��n paikannustietoja Tritechin tuottamassa muodossa ja drop-videokameroiden ohjelmiston tuottamassa muodossa. 

####K�ytt�j�t
VELMU-ohjelmassa videotietojen ker��miseen ja analysointiin osallistuvat tahot (Mets�hallitus, SYKE, ELY-keskukset, konsultit). 
Kolme erillist� k�ytt�j�tapausta: 
  - Harjoittelija
  - Analysoija
  - Yll�pit�j�

#### Kaikkien k�ytt�jien toiminnot
  - Sis��nkirjautuminen
  - Videoanalyysien harjoittelu
  - Harjoittelutulosten ja videoiden arvojen vertailu
  - Harjoittelutulosten ja niiden tilastotietojen tarkastelu
  - Omien harjoittelutulosten nollaus

#### Harjoittelijan toiminnot
  - Sis��nkirjautuminen
  - Videoanalyysien harjoittelu
    - Merialueen valinta
    - Videanalyysitulosten kirjaus ja tulosten katselu

####Analysoijan toiminnot
  - Sis��nkirjautuminen
  - Videoanalyysien tekeminen ja tulosten tallentaminen

####Yll�pit�j�n toiminnot
  - Sis��nkirjautuminen
  - Uusien harjoitteluvideoiden ja niiden analyysitietojen lis��minen
    - Lis�tt�v�n videon merialueen sy�tt�
    - Lis�tt�v�n videon analyysitietojen sy�tt�

*Uusien videoiden ja niiden analyysitietojen lis��minen* - harjoitusvideoita on jossain vaiheessa tarvetta lis�t�. Itse sovelluksessa tuskin tarvitaan videoille erillist� import-toimintoa vaan videot voi kopioida suoraan videohakemistoon. Samoin voisi toimia my�s esimerkkianalyysitiedot sis�lt�v�n tekstitiedoston kanssa mutta t�m� vaatii tarkkuutta je perehtyneisyytt� - arvojen ja otsikoiden lis��minen teksti- tai .csv -tiedostoihin on hankalaa ja virheit� voi sattua. Vaihtoehtona voisi olla siis ett� harjoitusvideoille lis�t��n analyysitiedot ohjelman kautta siten, ett� video analysoidaan kuten harjoituksessa mutta tiedot tallennetaan videoiden analyysitiedot sis�lt�v��n tiedostoon. T�ll�in ei ole tarvetta s�rkki� tiedostoja tekstieditorilla tai Excelill�. 


####Haasteita
*N�yt�n koko* - ty�skentely tapahtuu useimmiten l�pp�rill�, joten videokuvan ja analyysiin tarkoitettavan ikkunan sovittaminen n�yt�lle voi olla hankalaa. 

*Videoiden koko* - jos ohjelmapaketti sis�lt�� esimerkkivideot, tulee siit� sit� suurempi mit� enemm�n videoita on. Yksi mahdollisuus olisi striimata videot jostain (esim. Youtube) mutta koska ty�skentely tapahtuu monesti kent�ll� huonon tai olemattoman nettiyhteyden ��rell�, t�m� tuskin on j�rkev� vaihtoehto. Ensimm�isess� vaiheessa (t�m� kurssilla teht�v� Java-versio) siis toteutaan paikallisena eli siten, ett� videot ja niiden tiedot jaetaan ohjelman mukana. Jatkossa jos sovelluksesta halutaan online-versio, voidaan videot vied� ymp�rist�hallinnon palvelimelle tai striimauspalveluun (esim. Youtube). 
