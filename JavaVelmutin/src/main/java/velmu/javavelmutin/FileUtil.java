/*
 * VELMU / ville.karvinen@iki.fi
 */
package velmu.javavelmutin;
import java.util.*;
import java.io.*;
import com.opencsv.*;

/**
 * The class is a file utility for reading and writing csv files to/from 
 * Observations. It uses the OpenCSV library.
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
        
        String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                //Verifying the read data here
                System.out.println(Arrays.toString(nextLine));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
    
    /*
    ReadClassification - lukee OpenCSV:n avulla tiedoston, muuttaa sen Observationeiksi 
    ja lykkää observationit Video-olioon. Käytännössä? lukee ekan rivin
    havainnot (nimi) listaan, tekee listasta yksitellen observation-olion ja 
    tallettaa VideoObservationsiin, lukee tokan rivin ja tallentaa listaan, 
    josta poimii VideoObservationsin ekaan Observationiin, tokaan jne tyypit 
    */
    
    /*
    ReadAnalysis - muuten sama kuin ReadClassification mutta lukee myös 
    kolmannen rivin value-arvoiksi. 
    */
    
    /*
    SaveAnalysis - kirjoittaa OpenCSV:n avulla Videon havainnot CSV:ksi. 
    Kaivaa VideoObservationista jokaisen Observationin nimet ja kirjoittaa ne yhdeksi 
    riviksi, kaivaa tyypit ja kirjoittaa riviksi, kaivaa valuet ja kirjoittaa 
    riviksi.
    
    */
}
