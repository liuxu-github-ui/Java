
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        
        //int startIndex = dna.indexOf("ATG");
        int firstOccurence = dna.indexOf(stopCodon, startIndex);
        String cutString = dna.substring(startIndex,firstOccurence);
        if (cutString.length()%3==0){
           return firstOccurence;
           //return cutString;
        }else{
            return dna.length();
          //return "null";
        }
        
    }
    
    
    public String findGene(String dna1,int where){
        int firstOccurence_ATG = dna1.indexOf("ATG", where);
        
        if(firstOccurence_ATG==-1){
            return "";
        }else{
            int firstOccurence_TAAindex = findStopCodon(dna1,firstOccurence_ATG,"TAA");
            
            
            int firstOccurence_TAGindex = findStopCodon(dna1,firstOccurence_ATG,"TAG");
            
            
            int firstOccurence_ATGindex = findStopCodon(dna1,firstOccurence_ATG,"TGA");
            
    
            if(firstOccurence_TAAindex!=-1 && firstOccurence_TAGindex !=-1 && firstOccurence_ATGindex!=-1){
                int minimumAmongThree = Math.min(Math.min(firstOccurence_TAAindex,firstOccurence_TAGindex),firstOccurence_ATGindex);
                
                return dna1.substring(firstOccurence_ATG,minimumAmongThree+3);
            }else{
                return "";
            }
        }
        
        
        
    }
    
    public void printAllGenes(String dna){
        
        StorageResource geneList = new StorageResource();
      int startIndex=0;
      
      while(true){
          String currentGene=findGene(dna,startIndex);
          // if cant find "ATG" at the begining or no more "ATG" in the string to look for
          if(currentGene.isEmpty()){
              break;
          }
          
          geneList.add(currentGene);
          System.out.println(currentGene);
          startIndex=dna.indexOf(currentGene,startIndex)+currentGene.length();
        
        }
    }
    
    public void testFindStopCodon(){
        String test1="DFATGABCABCETA";
        System.out.println(findStopCodon(test1,2,"ETA"));
    }
    
    public void testFindGene(){
        String test2="DFATGABCTAAABCTAGABCTGA";
        String test3="DFATGABCTAGABCATGABCTAA";
        //System.out.println(findGene(test2));
  
        
    }
    
    public void testOn(){
    
    
    }
    

}
