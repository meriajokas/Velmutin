/*
 * VELMU / ville.karvinen@iki.fi
 */
package velmu.javavelmutin;
import java.util.*;

/**
 * The class has a TreeSet of Observations that are read from and written to 
 * files by methods provided in the FileUtil class. An instance of this class 
 * corresponds to the video being played.  
 */

public class Video {
    private String videoName; // This will be the filename of the video.
    private int amountOfObservations;
    
// VideoObservationsin ArrayList-versio
    ArrayList<Observation> VideoObservations;

    public Video() {
        this.VideoObservations = new ArrayList<>();
    }
    
    public void setObservation(Observation newObservation) {
        VideoObservations.add(newObservation); //pitäisikö olla this.VideoObservations?
        amountOfObservations++;
    }
    
    public Observation getObservation(int i) {
        if(i < amountOfObservations && i >= 0) {
            return VideoObservations.get(i);
        }
        return null;
    } 
    
    
}
