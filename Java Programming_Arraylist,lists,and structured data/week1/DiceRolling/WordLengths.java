
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
    
    public void countWordLengths(FileResource resource,int[] counts){
        
        for(String word : resource.words()){
        
            int wordlength= word.length();
            counts[wordlength]+=1;
        
        
        }
    
    
    }

}
