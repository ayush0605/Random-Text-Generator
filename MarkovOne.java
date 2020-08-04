
/**
 * MarkovOne
 * 
 * @author (Ayush Singhal) 
 * @version (1.0)
 */
import java.util.*;
public class MarkovOne extends AbstractMarkovModel {
    
    public String getRandomText(int numChars){
        if(myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index, index+1);
        sb.append(key);
        for(int i=0; i<numChars-1; i++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }
        return sb.toString();
    }

}
