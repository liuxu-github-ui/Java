
/**
 * Write a description of isVowel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.*;
import edu.duke.*;
public class isVowel {
    public Boolean isVowel(char ch){
    
        char chlowercase = Character.toLowerCase(ch);
        if(chlowercase=='a' ||chlowercase=='e'||chlowercase=='i'||chlowercase=='o'||chlowercase=='u' ){
        
            return true;
            
        
        }
        return false;
    
    
    }
    
    public String replaceVowels(String phrase,char ch){
        StringBuilder newString = new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
        
            if(isVowel(phrase.charAt(i))==true){
            
                newString.setCharAt(i,ch);
                
            }
        
        }
        
        return newString.toString();
    
    }
    
    public void testisVowel(){
    
       // System.out.println(isVowel('u'));
        //System.out.println(isVowel('c'));
    
        System.out.println(replaceVowels("Hello World",'*'));
    }

}
