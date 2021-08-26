
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna,int startindex, String stopCodon){
        int stopCodonFirstAppear = dna.indexOf(stopCodon,startindex);
        String truncateString =dna.substring(startindex,stopCodonFirstAppear);
        
        if(truncateString.length()%3==0){
        
            return stopCodonFirstAppear;
        }
        
        
        return dna.length();
    
    
    }
    
    public int findGene(String dna){
    
        int ATGindex = dna.indexOf("ATG");
        
        if(ATGindex==-1){
        
            return -1;
        }else{
        
            int stopwithATG = findStopCodon(dna,ATGindex,"ATG");
            int stopwithTAG =  findStopCodon(dna,ATGindex,"TAG");
            int stopwithTGA =  findStopCodon(dna,ATGindex,"TGA");
            
            int smallestAmongthree = Math.min(Math.min(stopwithATG, stopwithTAG),stopwithTGA);
            
            return smallestAmongthree;
        
        }
        
        
    
    }
    
    public void testFindStopCodon(){
    
        String test1dna= "TAAABDCDFSTDTAB";
        String test1stopCondo ="TAB";
        int test1startindex=1;
        System.out.println(findStopCodon(test1dna,test1startindex,test1stopCondo));
        
        String test2dna= "TAAABCDEF";
        String test2stopCondo ="DEF";
        int test2startindex=0;
        System.out.println(findStopCodon(test2dna,test2startindex,test2stopCondo));
    
    }

}
