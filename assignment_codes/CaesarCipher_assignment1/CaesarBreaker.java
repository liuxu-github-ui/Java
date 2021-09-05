
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {
    
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
    public void testcountLetters(){
        int[] test= countLetters("dfsesddsdfabc");
        for(int i=0; i<test.length;i++){
            System.out.println(test[i]);
        
        }
    
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
    
    public String decrypt(String encrypted,int key){
       // CaesarCipher cc = new CaesarCipher();
       // String message = cc.encrypt(encrypted, 26 - key);
      //  return message;
        //System.out.println("message "+message);
        return "dummy";
    
    }
    
    public void testdecrypt(){
        String encrypted="JGNNQ";
        int key=2;  
        System.out.println(decrypt(encrypted,key));

    }
    
    public String halfOfString (String message,int start){
        StringBuilder stringbuilder1 = new StringBuilder();
        for (int i=start; i<message.length();i+=2){
            stringbuilder1.append(message.charAt(i));
                       
        }
        
        return stringbuilder1.toString();
    
    
    }
    
    public void testhalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis",1));
    
    
    }
    
    public int getKey(String s ){
        int a = maxIndex(countLetters(s));
        
        return a;
    
    
    }
    
    public void testgetKey(){
        System.out.println(getKey("aeeedgdesdf"));
    
    }
    
    public void decryptTwoKeys (String encrypted){
        String firstCharacter = halfOfString(encrypted,0);
        String secondCharacter = halfOfString(encrypted,1);
        
        int key1=getKey(firstCharacter);
        int key2=getKey(secondCharacter);
       // CaesarCipher cc = new CaesarCipher();
        //String message = cc.encryptTwoKeys(encrypted,key1,key2);
        //System.out.println("Decrypted message "+message);
        
    
    }
    

}
