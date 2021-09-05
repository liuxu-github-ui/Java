
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter{
    String whr;
    String phr;
    
    public PhraseFilter(String where, String phrase){
        whr=where;
        phr=phrase;
    
    
    }
    
    public boolean satisfies(QuakeEntry qe){
        
        if(whr.equals("start")){
            if(qe.getInfo().startsWith(phr)){
                return true;
            
            }

        }
        else if (whr.equals("end")){
            if(qe.getInfo().endsWith(phr)){
                return true;
            
            }

        }
        
        else if(whr.equals("any")){
            
            if(qe.getInfo().indexOf(phr)!=-1){
                return true;
            }

        }
        
        return false;
    
    }

}
