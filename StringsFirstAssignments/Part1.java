
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
public class Part1 {
    public String findSimpleGene(String dna){
        int startCondon=dna.indexOf("ATG");
        int endCondon=dna.indexOf("TAA",startCondon+3);
        if((startCondon==-1) || (endCondon==-1)){
            return "";
        }
        int lengthinbetween = endCondon-startCondon;
        
        if(lengthinbetween % 3==0){
            String stringinbetween= dna.substring(startCondon+3,endCondon);
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
        String test5="ATGADFDFDKLSTAABBBATGDFGDFGTAA";
        String test6="ATGADFDFDKLSETAABBBATGDFGDFGDTAA";
        
        //System.out.println(findSimpleGene(dummySample));
        
        String result1=findSimpleGene(test1);
        String result2= findSimpleGene(test2);
        String result3= findSimpleGene(test3);
        String result4= findSimpleGene(test4);
        String result5= findSimpleGene(test5);
        String result6= findSimpleGene(test6);
        
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
        
        
    }
    

}
