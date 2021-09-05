
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.Random;
public class CaesarCipher {    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        
        String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        mainKey=key;
    
    }
    
    public String encrypt(String input){

        StringBuilder encrypted = new StringBuilder(input);
        System.out.println("shiftedAlphb: "+shiftedAlphabet);
        
        for (int i=0; i<encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            char currChar_copy = currChar;
            
            if(Character.isLowerCase(currChar)){
                currChar= Character.toUpperCase(currChar);

            }           
            int idx= alphabet.indexOf(currChar);
     
            if(idx!=-1){

                char newChar = shiftedAlphabet.charAt(idx);
                if(Character.isLowerCase(currChar_copy)){
                    newChar = Character.toLowerCase(newChar);
                
                } 
                encrypted.setCharAt(i,newChar);            
            }

        }       
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    
    
    }
    
    public void testCaesar(){
        int key =15;
        FileResource fr = new FileResource();
        String message = fr.asString();
       // String encrypted = encrypt(message, key);
       // System.out.println("key is " + key + "\n" + encrypted);
       
    
    
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
    
         StringBuilder encrypted = new StringBuilder(input);
         String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       
        
        String shiftedAlphabet_key1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet_key2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        for (int i=0; i<encrypted.length(); i++){
            if(i%2==0){
                char currChar = encrypted.charAt(i);
                char currChar_copy = currChar;
            
                if(Character.isLowerCase(currChar)){
                    currChar= Character.toUpperCase(currChar);

                }
            
                int idx= alphabet.indexOf(currChar);
                
                if(idx!=-1){
                 char newChar = shiftedAlphabet_key1.charAt(idx);
                    if(Character.isLowerCase(currChar_copy)){
                        newChar = Character.toLowerCase(newChar);
                    }
                    
                 encrypted.setCharAt(i,newChar);
                }

            }
            
                else if(i%2!=0){
                char currChar = encrypted.charAt(i);
                char currChar_copy = currChar;
            
                if(Character.isLowerCase(currChar)){
                    currChar= Character.toUpperCase(currChar);

                }
            
                int idx= alphabet.indexOf(currChar);
                
                if(idx!=-1){
                 char newChar = shiftedAlphabet_key2.charAt(idx);
                    if(Character.isLowerCase(currChar_copy)){
                        newChar = Character.toLowerCase(newChar);
                    }
                    
                 encrypted.setCharAt(i,newChar);
                }

            }
        
        
        }
        
        
        return encrypted.toString();
    
    
    
    }
    
     public void testencryptTwoKeys (){
  
       System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21) );
    
    
    }
    
    
    public void testFingerPrint(String s){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for(int k =0; k<s.length(); k++){
            char ch = s.charAt(k);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if(index!=-1){
                counters[index]+=1;
            
            }
        
        }
        
        for(int l=0; l<counters.length; l++){
            System.out.println(alpha.charAt(l)+"\t"+counters[l]);
        
        }
        
    
    
    }
    
    
    public void testCharacterCount(){
        testFingerPrint("liuxu");
    
    }
    
    public void simulate(int rolls){
        Random rand = new Random();
        int[] counts = new int[13];
        
        for(int k=0; k< rolls; k++){
            int d1= rand.nextInt(6)+1;
            int d2= rand.nextInt(6)+1;
            counts[d1+d2]+=1;

        }
        
        for(int k=2; k<=12; k++){
            System.out.println(k+":"+counts[k]);
        
        }
        
    
    
    }
    
    // shakespeare:
    
    public String[] getCommon(){
        FileResource resource = new FileResource("data/common.txt");
        String[] common= new String[20];
        int index=0;
        for(String s: resource.words()){
            common[index]=s;
            index+=1;
        }
        
        return common;

    }
    
    public int indexOf(String[] list, String word){
        for(int k=0; k< list.length; k++){
            if(list[k].equals(word)){
                return k;
            
            }
        }
        return -1;
    
    }
    
    public void countWords(FileResource resource, String[] common, int[] counts){
        for(String word: resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if(index!=-1){
                counts[index]+=1;
            
            }
        
        }

    }
    
    
    
    public void countShakespeare(){
        String[] plays={"text1.txt","text2.txt"};
        String[] common=getCommon();
        int[] counts= new int[common.length];
        for(int k =0; k<plays.length; k++){
            FileResource resource = new FileResource("data/"+plays[k]);
            countWords(resource,common,counts);
            System.out.println("done with"+plays[k]);
        
        
        }
        
        for(int k=0; k<common.length; k++){
            System.out.println(common[k]+"\t"+counts[k]);
        
        }
        

    }
    
    

}
