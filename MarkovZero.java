
/**
 * MarkovZero
 * 
 * @author (Ayush Singhal) 
 * @version (1.0)
 */


public class MarkovZero extends AbstractMarkovModel {
    
    public String getRandomText(int numChars){
        if( myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numChars; i++){
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }
        return sb.toString();
    }

}
