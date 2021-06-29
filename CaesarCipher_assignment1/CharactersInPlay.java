
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public CharactersInPlay(){
    
        myWords=new ArrayList<String>();
        
        myFreqs=new ArrayList<Integer>();
    
    }
    
    
    public void update(String person){
        if(!myWords.contains(person)){
            myWords.add(person);
            myFreqs.add(1);
        
        }
    
    
    }
    
    public void findAllCharacters (){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String line: fr.lines()){           
            if(line.contains(".")){
                int x=line.indexOf(".");
                String truncateString = line.substring(0,x);
               System.out.println(truncateString);
                update(truncateString);
            
            }
        
        
        }
    
    
    }
    
 
    

}
