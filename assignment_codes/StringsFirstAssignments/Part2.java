
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        if(startCodon==startCodon.toLowerCase()){
            // check weather startCodon is small letter
            startCodon=startCodon.toLowerCase();
        }
        
        if (startCodon==startCodon.toUpperCase()){
            // check wheater startCodon is upper letter
            startCodon=startCodon.toUpperCase();
        }
        
        
        int startCondon=dna.indexOf(startCodon);
        int endCondon=dna.indexOf(stopCodon,startCondon+3);
        if((startCondon==-1) || (endCondon==-1)){
            return "";
        }
        int lengthinbetween = endCondon-startCondon;
        
        if(lengthinbetween % 3==0){
            String stringinbetween= dna.substring(startCondon,endCondon+3);
            return stringinbetween;
        }else{
            return "";
        }
        

    }
    
    public void testSimpleGene(){
        
        String dummySample="ATGDDSTAA";
        String test1="dfadfadTAA";
        String test2="ATGdfadfa";
        String test3="dfadATDFDTADFA";
        String test4="ATGDFDFDFTAADFA";
        String test5="gtgdfdfdftaadfa";
        String test6="atgdfdfdftaadfa";
        
        //System.out.println(findSimpleGene(dummySample));
        
        String result1=findSimpleGene(test1,"ATG","TAA");
        String result2= findSimpleGene(test2,"ATG","TAA");
        String result3= findSimpleGene(test3,"ATG","TAA");
        String result4= findSimpleGene(test4,"ATG","TAA");
        String result5= findSimpleGene(test5,"ATG","TAA");
        String result6= findSimpleGene(test6,"atg","taa");
        
        if(result1==""){
            System.out.println("null");
        }else{
            System.out.println(result1);
        }
        
        if(result2==""){
            System.out.println("null");
        }else{
            System.out.println(result2);
        }
        
        if(result4==""){
            System.out.println("null");
        }else{
            System.out.println(result4);
        }
        
        if(result6==""){
            System.out.println("null");
        }else{
            System.out.println(result6);
        }
        
        
    }

}
