/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public String countryInfo(CSVParser parser, String country){
        
        for(CSVRecord record: parser){
           //look at the "Country" column
            String Countryname = record.get("Country");
            
            if(Countryname.equals(country)){
                return Countryname+" :"+record.get("Exports");
               
               }
            
           
           }
       
           return "NOT FOUND";
       
       }
       
     public void listExportersTwoProducts(CSVParser parser,String exportItem1, String exportItem2){
         
         for (CSVRecord record:parser){
             String products = record.get("Exports");
             String countryname =record.get("Country");
             if(products.contains(exportItem1)&&products.contains(exportItem2)){
                
                 System.out.println(countryname);
                }
            
            }
        
        }

    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //listExporters(parser, "coffee");
        
        //System.out.println(countryInfo(parser,"Germany"));
        listExportersTwoProducts(parser,"gold","diamonds");
    }
}
