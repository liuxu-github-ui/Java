
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
   public String findSimpleGene(String dna){
       String dnasmallleter = dna.toLowerCase();
       String startcondo="atg";
       String stopcondo = "taa";
       int idxOfATG=dna.indexOf(startcondo);
       if(idxOfATG==-1){
        return "";
        }
       int idxOfTAA=dnasmallleter.indexOf(stopcondo,idxOfATG+3);
       if(idxOfTAA==-1){
        return "";
        }
        
        String stringinBetween = dnasmallleter.substring(idxOfATG,idxOfTAA+3);
        
        if(stringinBetween.length()%3==0){
        return stringinBetween.toUpperCase(); 
        }else{
        return "";
        }
    
    }
    
    public void testSimpleGene(){
        String test1 = "atgabcdeftaa";
        System.out.println("test1: "+findSimpleGene(test1));
        String test2 = "ABCDEFTAA";
        System.out.println(findSimpleGene(test2));
        String test3 = "ATGABCDEF";
        System.out.println(findSimpleGene(test3));
        String test4 = "ATGABCDETAA";
        System.out.println(findSimpleGene(test4));
    
    }


}
