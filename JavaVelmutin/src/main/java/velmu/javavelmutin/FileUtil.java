/*
 * VELMU / ville.karvinen@iki.fi
 */
package velmu.javavelmutin;
import java.io.*;
import com.opencsv.*;

/**
 * The class is a file utility for reading and writing CSV files to/from 
 * instances of the Observation-class. It uses the OpenCSV library:
 * http://opencsv.sourceforge.net/.
 * 
 */

public class FileUtil {
      
    /**
     * ReadClassification - Reads a CSV file containing names and types to 
     * instances of the Observation class and adds them to the ArrayList of new
     * instance of Video. Used in analysis mode to import classification scheme 
     * and to set up the analysis for a video that does not have a saved 
     * analysis file.
    */    
    public void ReadClassification (Video thisVideo) {
        
        try {
        CSVReader reader = new CSVReader(new 
        FileReader("D:\\Users\\karvinenv\\Docs\\GitHub\\Velmutin"
                + "\\JavaVelmutin\\classification\\TestClassification.csv"), 
                ';' , '"'); 
        // Tähän prompti, joka näyttää valittavana olevat tiedostot? Esim.
        // JFileChooser?
        
        String[] tempList;

        while((tempList = reader.readNext()) != null){
            Observation obs = new Observation();
            obs.setName(tempList[0]);
            obs.setType(tempList[1]);
            thisVideo.addObservation(obs);
        }  
        reader.close();
        //For testing purposes: System.out.println(thisVideo);
        
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
    
    /**
     * ReadAnalysis - Reads a CSV file containing names, types and values to 
     * instances of the Observation class and adds them to the ArrayList of new
     * instance of Video. Used in practice mode to import the classification 
     * scheme and predetermined values to set up the practice analysis for a
     * video with a saved analysis file.
    */ 
    
    public void ReadAnalysis (Video thisVideo) {
        
        try {
        CSVReader reader = new CSVReader(new 
        FileReader("D:\\Users\\karvinenv\\Docs\\GitHub\\Velmutin"
                + "\\JavaVelmutin\\classification\\TestAnalysis.csv"), 
                ';' , '"'); 
        // TODO: Valitsee tiedostoksi videon nimen mukaisen analyysitiedoston.

        String[] tempList;

        while((tempList = reader.readNext()) != null){
            Observation obs = new Observation();
            obs.setName(tempList[0]);
            obs.setType(tempList[1]);
            obs.setValue(tempList[2]);
            thisVideo.addObservation(obs);
        }  
        reader.close();
        //For testing purposes: System.out.println(thisVideo);
        
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
    
    /**
     * SaveAnalysis - uses OpenCSV to save the Videos Observations to a file. 
    */ 
    
    public void SaveAnalysis(Video thisVideo) {
        try {
        /* TODO: 
            a) Tarkistaa onko käyttäjä ylläpitäjä, jos on niin tallennetaan 
            videon omaksi analyysitiedostoksi. Jos ei, tallennetaan käyttäjän 
            omaan tulostiedostoon. 
            b) Tähän pätkä joka kaivaa videotiedoston nimen ja luo SaveFile 
            -Stringin (hakemistopolku\\ + VideonNimi + Analysis), ja se annetaan 
            FileWriterille parametriksi
        */   
            
        CSVWriter writer = new CSVWriter(new FileWriter("D:\\Users\\karvinenv\\"
                + "Docs\\GitHub\\Velmutin\\JavaVelmutin\\analysis\\"
                + "TestAnalysis.csv"), ';', '"');
        
        for(int i = 0; i < thisVideo.amountOfObservations; i++) {
            String [] tempList = (thisVideo.getObservation(i).toCsv()).split(";");
      //Writes the tempList to file
        writer.writeNext(tempList);
        }
      //Closes the writer
        writer.close();
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
}
