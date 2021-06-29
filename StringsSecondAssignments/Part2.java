
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    
    public int howMany(String stringa, String stringb){
        int indexOccurance = stringb.indexOf(stringa);
        int numberofappearance=0;
        while (true){
            if(indexOccurance==-1){
                break;
            }
            numberofappearance+=1;
            indexOccurance = stringb.indexOf(stringa,indexOccurance+stringa.length());
            
        }
        
        return numberofappearance;
    }
    
    public void testowMany(){
        
        String test1="ATGAACGAATTGAATC";
        String test2= "ATAAAA";
        
        System.out.println(howMany("GAA",test1));
        System.out.println(howMany("AA",test2));
    
    }

}
