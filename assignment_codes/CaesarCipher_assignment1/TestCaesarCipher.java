
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.Random;

public class TestCaesarCipher {
    
   public int[] countLetters(String s ){
        String alph="abcdefghijklmnopqrstuvwxyz";
        int[] counts=new int[26];
        for(int k=0; k<s.length(); k++){
            char ch = Character.toLowerCase(s.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]+=1;
            
            }
        
        }
        
        return counts;

    }
 
    public int maxIndex(int[] intArray){
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
    
    public void simpleTests(){
        int key =18;
        FileResource fr = new FileResource();
        CaesarCipher cc = new CaesarCipher(key);
        String message = fr.asString();
        
        System.out.println("Encrypted message "+cc.encrypt(message));
        System.out.println("Decryptd message "+cc.decrypt(message));
        
    
    }

}
