 

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder str= new StringBuilder();
        
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            String messagetruncated= message.substring(i,i+1);
            str.append(messagetruncated);
        
        }
        
        
        return str.toString();
    }
    
    public void test(){
        breakVigenere(4);
        



    }
    


    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker newcracker = new CaesarCracker(mostCommon);
        for(int i=0; i<klength; i++){
            String s = sliceString(encrypted,i,klength);
            int a = newcracker.getKey(s);
            key[i]=a;
        
        }
        
        return key;
    }

    public void breakVigenere (int keyLength) {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String s = fr.asString();
        int[] key = tryKeyLength(s, keyLength, 'e');
        System.out.println("key: "+key);
        VigenereCipher vc = new VigenereCipher(key);
        String msg = vc.decrypt(s);
        System.out.println(msg);
        
    }
    public HashSet readDictionary(FileResource fr){
        HashSet<String> HashsetDictionaryWords = new HashSet<String>();
        for(String word: fr.lines()){
            String wordLower=word.toLowerCase();
            // if lineLower exists in the dictionary file, add the word into the hashset
            HashsetDictionaryWords.add(wordLower);
        
        }
        
        return HashsetDictionaryWords;
        
    
    
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        int countnumberofWords=0;
        for(String word:message.split("\\W")){
            if(dictionary.contains(word)){
                countnumberofWords+=1;
            
            
            }

        }
        
        return countnumberofWords;

    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        String decrypted="";
        int maxCount=0;
        for(int k=0; k<100; k++){
            int[] returnedInt = tryKeyLength(encrypted,k,'e');
            
            VigenereCipher vigenereCipher = new VigenereCipher(returnedInt);
            String currDecrypted = vigenereCipher.decrypt(encrypted);
            
            int currCount = countWords(currDecrypted, dictionary);
            
            if(currCount>maxCount){
                maxCount=currCount;
                decrypted=currDecrypted;
            
            }
           
            
        
        
        }
        
        
        return decrypted;
    
    
    
    }
    
    

    
    
}
