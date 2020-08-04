
/**
 * MarkovModel
 * 
 * @author (Ayush Singhal) 
 * @version (1.0)
 */
import java.util.*;
public class MarkovModel extends AbstractMarkovModel {

    private int myOrder;
    
    public MarkovModel(int order){
        myRandom = new Random();
        myOrder = order;
    }
    
    public String getRandomText(int numChars){
        if(myText == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int index = myRandom.nextInt(myText.length()-myOrder);
        String key = myText.substring(index,index+myOrder);
        sb.append(key);
        for(int i=0; i<numChars-myOrder ;i++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next; 
        }
        return sb.toString();
    }
}
