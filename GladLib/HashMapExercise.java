
/**
 * Write a description of HashMapExercise here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
public class HashMapExercise {
    private HashMap<String,Integer> map ;
    public HashMapExercise(){
         map = new HashMap<String,Integer>();
    
    }
    
    public void buildCodonMap(int start,String dna){
        map.clear();
        String stringUpper=dna.toUpperCase();
        for(int i=start; i<dna.length()-2; i+=3){
            String w=stringUpper.substring(i,i+3);
            if(map.keySet().contains(w)){
               map.put(w,map.get(w)+1);
            }else{
               map.put(w,1);  
            }
        
        }

        
 

    }
    
    public void getMostCommonCodon(){
        int occurrences=0;
        String maxKeyString=null;
        for(String w:map.keySet()){
            if(occurrences<map.get(w)){
                occurrences=map.get(w);
                maxKeyString=w;
            }  
        }      
        
        System.out.println(occurrences+""+maxKeyString);
         
    
    
    }
    
    public void printCodonCountsxxx(){
        int d=0;
        buildCodonMap(1,"CGTTCAAGTTCAA");
        for(String w:map.keySet()){
             d = map.get(w);
            System.out.println(d+w);
 
        
        }      
        
        
    }
    
    public void printCodonCounts(int start,int end){
        int occurrences=0;
        for(String w:map.keySet()){
            occurrences = map.get(w);
            if(occurrences>=start || occurrences<=end){
                System.out.println(occurrences+w);
            
            }
        
        }
    
    
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        for(String w: fr.words()){
            buildCodonMap(2,w);
            printCodonCounts(1,5);
        
        }
    
    
    }

}
