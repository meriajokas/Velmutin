/*
 * VELMU / ville.karvinen@iki.fi
 */
package velmu.javavelmutin;

/**
 * The class provides Observation instances to Video, listing the names, types
 * and values of observations assigned to a video file. The values are stored
 * as String to avoid problems with null values interfering with zero values.
 * 
 */

public class Observation {
    private String name;
    private String type;
    private String value;
    
    public Observation(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
      
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
            
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return name + " (" + type + ")" + ": " + value;
    }
}
