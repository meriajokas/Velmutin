/*
 * VELMU / ville.karvinen@iki.fi
 */
package velmu.javavelmutin;
import java.util.*;
import java.io.*;
import com.opencsv.*;

/**
 * The class is a file utility for reading and writing CSV files to/from 
 * instances of the Observation-class. It uses the OpenCSV library:
 * http://opencsv.sourceforge.net/.
 * 
 */

public class FileUtil {
    
    public void ReadClassification () {
        
        try {
        CSVReader reader = new CSVReader(new 
        FileReader("D:\\Users\\karvinenv\\Docs\\GitHub\\Velmutin"
                + "\\JavaVelmutin\\classification\\TestClassification.csv"), 
                ';' , '"'); 
        // Tähän prompti, joka näyttää valittavana olevat tiedostot? Esim.
        // JFileChooser?
        
        Video thisVideo = new Video(); 
        //Tämä pitää jotenkin saada nimettyä videotiedoston mukaan!
        String[] tempList;

        while((tempList = reader.readNext()) != null){
            Observation obs = new Observation();
            obs.setName(tempList[0]);
            obs.setType(tempList[1]);
            thisVideo.addObservation(obs);
        }  
        reader.close();
        System.out.println(thisVideo);
        
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
    
    /*
    ReadClassification - Tätä käytetään analyysimoodissa kun videolla ei ole 
    omaa analyysitiedostoa. 
    Lukee OpenCSV:n avulla tiedoston, muuttaa sen Observationeiksi 
    ja lykkää observationit Video-olioon. 
    Lukee siis rivi kerrallaan ja tekee uuden Observationin antaen sille name ja  
    type -muuttujat sekä lisää Observationin VideoObservationin ArrayListiin.
    */
    
    /*
    ReadAnalysis - Tätä käytetään harjoittelumoodissa kun videolla on olemassa
    analyysitiedosto. Muuten sama kuin ReadClassification mutta lukee myös 
    kolmannen sarakkeen value-arvoiksi. 
    Muista: obs.setValue(tempList[2]);
    */
    
    /*
    SaveAnalysis - kirjoittaa OpenCSV:n avulla Videon havainnot CSV:ksi. 
    Kaivaa VideoObservationin ArraListista Observation-oliot ja kirjoittaa ne 
    CSV-tiedostoon jokaisen omalle rivilleen. Jos käyttäjä on ylläpitäjä,
    tallennetaan tiedosto videon omaksi analyysitiedostoksi, jos tavallinen
    käyttäjä niin tallennetaan käyttäjän omaan tiedostoon (vaatii speksausta!). 
    
    */
}
