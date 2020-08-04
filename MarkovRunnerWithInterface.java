
/**
 * MarkovRunner
 * 
 * @author Duke Software + Ayush Singhal
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed = 42;
		int order = 4;
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,seed);
        
        long startTimeNormal = System.nanoTime();
        
        MarkovModel mm = new MarkovModel(order);
        runModel(mm, st, size, seed);
        
        long endTimeNormal = System.nanoTime();
        long diffNormal = endTimeNormal - startTimeNormal;
        System.out.println("Normal Model " + diffNormal);
        
        long startTimeEfficient = System.nanoTime();
        
        EfficientMarkovModel emm = new EfficientMarkovModel(order);
        runModel(emm, st, size, seed);
        
        long endTimeEfficient = System.nanoTime();
        long diffEfficient = endTimeEfficient - startTimeEfficient;
        System.out.println("Efficient Model " + diffEfficient);
        System.out.println("Efficient Model is " + diffNormal*1.0/diffEfficient + " times faster than Normal");

    }

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
