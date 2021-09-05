
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.Random;
public class WordLengths {
    
    public void countWordLengths(FileResource resource, int[] counts){
        int WordLength=0;
        for(String word: resource.words()){
            //int wordLength=word.length();
            //counts[wordLength]+=1;
            for(int i=0; i<word.length();i++){
                // if character is a letter and is not the first or last character
                if(Character.isLetter(word.charAt(i))&&i!=0 && i!=word.length()-1){
                    
                    WordLength+=1;
    
                }
            } 
            
            counts[WordLength+1]+=1;
            WordLength=0;
            
        }

    }
    
    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int[] counts=new int [31];
       countWordLengths(resource,counts);
       //for(int i=0; i<counts.length;i++){
           //System.out.println(counts[i]);
        
        //}
        System.out.println(indexOfMax(counts));

    } 
    
    public int indexOfMax(int[] intArray){
        int largestsoFar=0;
        int largestValueIndex=0;
        
        for(int i=0;i<intArray.length;i++){
            if(intArray[i]>largestsoFar){
                largestsoFar= intArray[i];
                largestValueIndex=i;
            
            }
            
        
        }
    
        
        return largestValueIndex+1;
    
    }
    
    

}
