
/**
 * Write a description of VigenereBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
public class VigenereBreaker {
    
    public String sliceString(String message,int whichSlice, int totalSlices){
        StringBuilder str= new StringBuilder();
        
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            String messagetruncated= message.substring(i,i+1);
            str.append(messagetruncated);
        
        }
        
        
        return str.toString();
    
    
    
    }
    
    
    
    public void test(){
        System.out.println(sliceString("abcdefghijklm", 4, 5));
          //System.out.println("test1");
          readFile("titus-small_key5.txt");
     }
     
    public void readFile(String Filename){
        
        FileResource fr = new FileResource(Filename);
        CaesarCracker newcracker = new CaesarCracker();
        
        for(String line:fr.lines()){
            
            
            //System.out.println(newcracker.decrypt(line));
            
        
        }
        
    
    
    }
     

}
