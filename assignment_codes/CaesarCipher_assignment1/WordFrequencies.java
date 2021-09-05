
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import edu.duke.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords=new ArrayList<String>();
        
        myFreqs=new ArrayList<Integer>();

    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        for(String word: fr.words()){
            word=word.toLowerCase();
            int index = myWords.indexOf(word);
            if(index ==-1){
                myWords.add(word);
                myFreqs.add(1);
            
            }else{
                int value=myFreqs.get(index);
                myFreqs.set(index,value+1);
            
            }
           
            
        }

    }
    
    public void testfindUnique(){
        findUnique();
        for(int i=0;i<myWords.size();i++){
            System.out.println(myWords.get(i)+ " "+myFreqs.get(i));
        
        }
    
    
    }
    
    public int findIndexOfMax(){
        findUnique();
        int largestSoFar=0;
        
        for(int i=0; i<myFreqs.size();i++){
            if(largestSoFar<myFreqs.get(i)){
                largestSoFar=myFreqs.get(i);
            }
            
        
        }
    
        return largestSoFar;
    
    }
    

}
