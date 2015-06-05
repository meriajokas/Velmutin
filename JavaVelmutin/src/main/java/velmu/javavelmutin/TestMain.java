package velmu.javavelmutin;

/*
 * VELMU / ville.karvinen@iki.fi
 */

/**
 *
 * Main method to try and see how stuff works. 
 */
public class TestMain {

    public static void main(String[] args) {      
// Create new instance of video:
      Video thisVideo = new Video();
      
// Create new instance of FileUtil:
      FileUtil utilizer = new FileUtil();
      
// Read classification scheme for thisVideo:
      utilizer.ReadClassification(thisVideo);
      
// Create the analysis CSV file:
      utilizer.SaveAnalysis(thisVideo);
    } 
}
    


