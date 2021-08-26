
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa,String stringb){
        int stringaindexfirstappear = stringb.indexOf(stringa);
        if(stringaindexfirstappear!=-1){
            String trucatestringb = stringb.substring(stringaindexfirstappear+stringa.length(),stringb.length());
            int stringaindexsecondappear = trucatestringb.indexOf(stringa);
            
            if(stringaindexsecondappear !=-1){
            
                return true;
            }else{
                return false;
            }
            
        }
    
        return false;
    
    }
    
    public String lastpart(String a,String b){
    
        int checkainb=b.indexOf(a);
        
        if(checkainb!=-1){
        
            int aindex=b.indexOf(a);
            String truncateb = b.substring(aindex+a.length(),b.length());
            return truncateb;

        }
        
        return b;
    }
    
    public void testtwoOccurrences(){
        String a ="by";
        String b = "A story by Abby Long";
        System.out.println(twoOccurrences(a,b));
        
        String c ="a";
        String d ="bandnd";
        System.out.println(twoOccurrences(c,d));
        
        String e ="an";
        String f ="banana";
        System.out.println(lastpart(e,f));
        
        String g ="zoo";
        String h="forest";
        System.out.print(lastpart(g,h));
    
    }

}
