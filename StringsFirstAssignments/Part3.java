
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurences(String stringa, String stringb){
        
        int firststringLength= stringa.length();
        int secondstringLength= stringb.length();
        int firstIndex = stringb.indexOf(stringa);
        if(firstIndex!=-1){
            String cutstring = stringb.substring(firstIndex+firststringLength,secondstringLength);
            if(cutstring.indexOf(stringa)!=-1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
    
    public String lastPart(String stringa, String stringb){
        int firstIndex=stringb.indexOf(stringa);
        if(firstIndex==-1){
            return stringb;
        }else{
            String trimString = stringb.substring(firstIndex+stringa.length(),stringb.length());
            return trimString;
        }
        
       
    }
  
    public void testing(){
        
        String test1="da";
        String test2="tsdadfasddaa";
        String test3="bs";
        String test4="dfdssda";
        String test5="dfsdf";
        String test6="tsdafd";
        String test7="an";
        String test8="banana";
        String test9 ="zoo";
        String test10 ="forest";
        
        
        System.out.println(twoOccurences(test1,test2));
        System.out.println(twoOccurences(test3,test4));
        System.out.println(twoOccurences(test3,test5));
        System.out.println(twoOccurences(test3,test6));
        System.out.println(lastPart(test7,test8));
        System.out.println(lastPart(test9,test10));
    }

}
