
/**
 * Abstract class AbstractMarkovModel
 * 
 * @author (Ayush Singhal)
 * @version (1.0)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    //Method to generate Random Text
    // It is a abstract method. Must be defined in all classes extending this class
    abstract public String getRandomText(int numChars);
    
    //Method to find the follow character
    protected ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>(); 
        int pos=0;
        while(pos<myText.length()){
            int start = myText.indexOf(key,pos);
            if(start==-1){
                break;
            }
            if(start+key.length() >= myText.length()){
                break;
            }
            String next = myText.substring(start+key.length(),start+key.length()+1);
            follows.add(next);
            pos = start + key.length();
        }
        return follows;
    }
}
