
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;


public class Part4 {
    //String htmlFile="http://www.dukelearntoprogram.com/course2/data/manylinks.html";
    public void readhtmlFile(){
        	URLResource page = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
		for (String word : page.words()) {
			
			if(word.indexOf("youtube.com")!=-1){
			    //System.out.println(word);
			    int firstQuotationIndex= word.indexOf("\"");
			    int secondQuotationIndex=word.indexOf("\"",firstQuotationIndex+1);
			    
			    String url=word.substring(firstQuotationIndex+1,secondQuotationIndex);
			    System.out.println(url);
			    
			    
			    
			 }
		}
    
    
    }

}
