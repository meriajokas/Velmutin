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

    /**
     * @amountOfObservations The amount of Observation instances in the video 
     * (stored in the ArrayList VideoObservations). 
     */
    protected int amountOfObservations;
    
// VideoObservationsin ArrayList-versio
    ArrayList<Observation> VideoObservations;

    public Video() {
        this.VideoObservations = new ArrayList<>();
    }
    
    public void addObservation(Observation newObservation) {
        VideoObservations.add(newObservation); //pitäisikö olla this.VideoObservations?
        amountOfObservations++;
    }
    
    public Observation getObservation(int i) {
        if(i < amountOfObservations && i >= 0) {
            return VideoObservations.get(i);
        }
        return null;
    } 
    
    public String toString() {
        String string = new String();
        for(int i = 0; i < amountOfObservations; i++) {
            string += VideoObservations.get(i) + "\n";
        }
        return string;
    }
    
    
}
