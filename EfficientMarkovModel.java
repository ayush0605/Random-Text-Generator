
/**
 * EfficientMarkovModel
 * 
 * @author (Ayush Singhal) 
 * @version (1.0)
 */
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel {
    private int myOrder;
    private HashMap<String, ArrayList<String> > mp;
    
    public EfficientMarkovModel(int order){
        myRandom = new Random();
        myOrder = order;
        mp = new HashMap<String, ArrayList<String> >();
    }
    
    public void buildHashMap(){
        for(int i=0; i<myText.length()-myOrder ; i++){
            int subEnd = i + myOrder;
            String sub = myText.substring(i ,subEnd);
            if(!mp.containsKey(sub)){
                mp.put(sub, new ArrayList<String>() );
            }
            if(subEnd < myText.length() ){
                String follow = myText.substring(subEnd, subEnd+1);
                ArrayList<String> follows = mp.get(sub);
                follows.add(follow);
                mp.put(sub,follows);
            }
        }
    }
    
    
    public String getRandomText(int numChars){
        StringBuffer sb = new StringBuffer();
        int index = myRandom.nextInt(myText.length()- myOrder);
        String key = myText.substring(index,index+myOrder);
        sb.append(key);
        ArrayList<String> follows = new ArrayList<String>();
        for(int i=0; i < numChars-myOrder; i++){
            if(!mp.keySet().contains(key)){
                follows = getFollows(key);
                mp.put(key,follows);
            }
            else{
                follows = mp.get(key);
            }
            if(follows.size() != 0 ){
                index = myRandom.nextInt(follows.size());
                String next = follows.get(index);
                sb.append(next);
                key = key.substring(1) + next;
            }
        }
        return sb.toString();
    }
}
