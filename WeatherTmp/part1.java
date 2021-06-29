
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part1 {
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar =null;
        
        for (CSVRecord currentRow:parser){
            if(smallestSoFar==null){
                smallestSoFar=currentRow;

            }else{
                double currentTmp =Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTmp =Double.parseDouble(smallestSoFar.get("TemperatureF"));
            
                if(smallestTmp>currentTmp){
                    smallestSoFar=currentRow;
                
                }
            }

        }
        return smallestSoFar;
    
    
    }
    
    public void testColdestInHourInFile(){
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-10-1.csv");
        CSVRecord largest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temp was"+" "+ largest.get("TemperatureF")+" at "+largest.get("TimeEST"));
        
    
    
    }
    
    
     
    
    public String fileWithColdestTemperature(){
     CSVRecord smallestSoFar = null;
      String coldestFile=null;
    
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            
            if(smallestSoFar==null){
                smallestSoFar=currentRow;
            
            }else{
            
                 double currentTmp =Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTmp =Double.parseDouble(smallestSoFar.get("TemperatureF"));
            
                if(smallestTmp>currentTmp){
                    smallestSoFar=currentRow;
                    coldestFile=f.getName();
                
                }
            }
            
        }

        return coldestFile;

    }
    
    
    
   
    public void testFileWithColdestTemperature(){
        
        //CSVRecord largest = fileWithColdestTemperature();
        //System.out.println("coldest temp was"+" "+ largest.get("TemperatureF")+" at "+largest.get("TimeEST"));
        System.out.println(fileWithColdestTemperature());
        FileResource fr = new FileResource("nc_weather/2013/"+fileWithColdestTemperature());
        CSVRecord largest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temp was"+" "+ largest.get("TemperatureF"));
        
        
        for (CSVRecord currentRow:fr.getCSVParser()){
            System.out.println(currentRow.get("DateUTC")+" "+currentRow.get("TimeEST")+ " "+currentRow.get("TemperatureF"));
            
            
        
        
        }
    
    
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
    
        CSVRecord smallestSoFar =null;
        double currentHumidity = 0;
        double smallestHumidity = 0;
        
        for (CSVRecord currentRow:parser){
            if(smallestSoFar==null){
                smallestSoFar=currentRow;

            }else{
                if(currentRow.get("TemperatureF")!=null){
                    
                    currentHumidity =Double.parseDouble(currentRow.get("Humidity"));
                }
                if(smallestSoFar.get("TemperatureF")!=null){
                    
                    smallestHumidity =Double.parseDouble(smallestSoFar.get("Humidity"));
                    if(smallestHumidity>currentHumidity )
                    
                        smallestSoFar=currentRow;
                    }
                    
                
                
                }

            
            }
            return smallestSoFar;
    
        }
        
        
        public void testLowestHumidityInFile(){
                    FileResource fr = new FileResource("nc_weather/2014/weather-2014-07-22.csv");
                    CSVRecord csv = lowestHumidityInFile(fr.getCSVParser());
                    System.out.println("Lowest Humidity was"+" "+ csv.get("Humidity")+" at "+ csv.get("DateUTC"));
            
        
        
        
        }
        
        
            
    public CSVRecord lowestHumidityInManyFiles(){
     CSVRecord smallestSoFar = null;

        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            
            if(smallestSoFar==null){
                smallestSoFar=currentRow;
            
            }else{
            
                 double currentTmp =Double.parseDouble(currentRow.get("Humidity"));
                double smallestTmp =Double.parseDouble(smallestSoFar.get("Humidity"));
                
                
            
                if(smallestTmp>currentTmp){
                    smallestSoFar=currentRow;
                    
                
                }
            }
            
        }

        return smallestSoFar;

    }
    
    public void testLowestHumidityInManyFiles(){
        
        CSVRecord lowestHumditiy = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was"+" "+ lowestHumditiy.get("Humidity")+" at "+lowestHumditiy.get("DateUTC"));
    
    
    }
    
    public Double averageTemperatureInFile(CSVParser parser){
        Double Tempsum=0.0  ;
        int countnumberOfTmp=0;
        
        for (CSVRecord currentRow:parser){
            Double temp = Double.parseDouble(currentRow.get("TemperatureF"));
            Tempsum=Tempsum+temp;
            countnumberOfTmp+=1;
 
        }
        
        Double avgTmp = (Tempsum/countnumberOfTmp) ;
        
        return avgTmp;
        
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource("nc_weather/2013/weather-2013-08-10.csv");
        Double averageTemp = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is "+" "+ averageTemp);
    
    
    
    }
    
    public Double averageTemperatureWithHighHumidityInfile(CSVParser parser, int value){
        Double sumTmp=0.0;
        
        int countTmp=0;
        for (CSVRecord currentRow:parser){
            Double humidity = Double.parseDouble(currentRow.get("Humidity"));
            if(humidity>=value){
                Double tmp = Double.parseDouble(currentRow.get("TemperatureF"));
                sumTmp = sumTmp+tmp;
                countTmp+=1;
 
            }
        
        }
        
        
        if(sumTmp==0){
            return 0.0;
        }else{
            Double avgTmp = (sumTmp/countTmp) ;
            return avgTmp;
        }
      
    
    
    
    }
    
    public void testAverageTemperatureWithHightHumidityInFile(){
        FileResource fr = new FileResource("nc_weather/2013/weather-2013-09-02.csv");
        Double averageTemp = averageTemperatureWithHighHumidityInfile(fr.getCSVParser(),80);
        
        
        if(averageTemp==0.0){
            System.out.println("No temperature with that humidity");
        
        }else{
            System.out.println("Average Tmp when high Humidity is" + " " + averageTemp);
        
        }
        
       
    
    
    }
        
        
        
}
 
    
    
    
    


