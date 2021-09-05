
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class WordPlay {
    
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e'|| ch=='i'|| ch=='o' || ch=='u'){
            return true;
        
        }else{
            return false;
        
        }

    }
    
    public void replaceVowels(String phrase, char ch){
        /*
        for(int i=0; i<=phrase.length()-1; i++) {
            return phrase.charAt(i);
        }*/
        
        StringBuilder encrpyted= new StringBuilder(phrase);
        
        for (int i = 0; i < phrase.length(); i++) {
//System.out.println(Character.toLowerCase(phrase.charAt(i)))
            if(isVowel(Character.toLowerCase(phrase.charAt(i)))==true){
               encrpyted.setCharAt(i,ch);
            
            }
        }
    
        System.out.println( encrpyted.toString());
    
    
    }
    
    public void testisVowel(){
        System.out.println(isVowel('k'));
        System.out.println(isVowel('i'));
    
    
    }
    
    public void testreplaceVowels(){
        replaceVowels("Hello WOrld",'*');
    
    }
    
    public String emphasize(String phrase, char ch){

        
        StringBuilder encrpyted= new StringBuilder(phrase);
        
        for (int i = 0; i < phrase.length(); i++) {
            if(i%2==0 && Character.toLowerCase(phrase.charAt(i))=='a'){
                encrpyted.setCharAt(i,'*');
            
            }else if (i%2!=0 && Character.toLowerCase(phrase.charAt(i))=='a') {
                encrpyted.setCharAt(i,'+');
            
            
            }

        }
    
        return encrpyted.toString();
    
    
    }
    
    public void testemphasize(){
       // System.out.println(emphasize("dna ctgaaactga",'a'));
       System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    
    }
    
    

}
