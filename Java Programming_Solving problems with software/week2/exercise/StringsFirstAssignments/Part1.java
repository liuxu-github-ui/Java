
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findSimpleGene(String dna){
       int idxOfATG=dna.indexOf("ATG");
       if(idxOfATG==-1){
        return "";
        }
       int idxOfTAA=dna.indexOf("TAA",idxOfATG+3);
       if(idxOfTAA==-1){
        return "";
        }
        
        String stringinBetween = dna.substring(idxOfATG,idxOfTAA+3);
        
        if(stringinBetween.length()%3==0){
        return stringinBetween;
        }else{
        return "";
        }
    
    }
    
    public void testSimpleGene(){
        String test1 = "ATGABCDEFTAA";
        System.out.println(findSimpleGene(test1));
        String test2 = "ABCDEFTAA";
        System.out.println(findSimpleGene(test2));
        String test3 = "ATGABCDEF";
        System.out.println(findSimpleGene(test3));
        String test4 = "ATGABCDETAA";
        System.out.println(findSimpleGene(test4));
    
    }

}
