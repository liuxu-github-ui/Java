
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
    
    public void totalBirth(FileResource fr){
        int totalBirths=0;
        int totalGirlsnames=0;
        int totalBoysnames=0;
        int totalnames;
        for(CSVRecord rec: fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths+=numBorn;
            
            if(rec.get(1).equals("F")){
                totalGirlsnames+=1;
            
            }else if (rec.get(1).equals("M")){
                totalBoysnames+=1;
            
            }
        
        }
       // System.out.println("total births ="+totalBirths);
       System.out.println("totalGirlsnames ="+totalGirlsnames);
       System.out.println("totalBoysnames ="+totalBoysnames);
       System.out.println("total births ="+totalBirths);
        

    
    
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1905.csv");
        totalBirth(fr); 
        
        
        }
        
    public int getRank(int year, String name, String gender){
        
        int found=0;
        int notFound=0;
        int rank=0;
   
        //FileResource fr = new FileResource("us_babynames_small/testing/yob2012short.csv");
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/"+"yob"+year+".csv");
        for(CSVRecord rec: fr.getCSVParser(false)){
            
            if(rec.get(1).equals(gender)){
                rank+=1;
                
                if( rec.get(0).equals(name)){
                    break;
                
                }

            }
            
            if(rec.get(0).equals(name)){
                
                if( rec.get(1)!=gender){
                    notFound=-1;
                    break;
                
                
                }
            }
                
        }
        
        
        if(notFound!=-1){
            return rank;
        
        }else{
            return notFound;
        
        }
        
        

    }
    
        public String getName(int year, int rank, String gender){
        
        int trackRank=0;
        String returnName=null;

        //FileResource fr = new FileResource("us_babynames_small/testing/yob2012short.csv");
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender) ){
                trackRank+=1;
                if(trackRank==rank){
                    returnName= rec.get(0);
                    break;
                }else{
                   returnName="No Name";
                
                }
                
                
            
            }
            
            

        }
        
        if(returnName=="No Name"){
            return "No Name";
        
        }else{
            return returnName;
        
        }
        
   
        

    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int nameRank  = getRank(year, name, gender);
        System.out.println (name +" born in "+year+" would be "+getName(newYear, nameRank, gender)+" if she/he was born in "+newYear);
    
    
    
    }
    
    
    
    public void testgetRank(){
        System.out.println(getRank(1971,"Frank","M"));
        
    }
    
    public void testgetName(){
        
        System.out.println(getName(1982,450,"M"));
    }
    
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Owen", 1974, 2014, "M");
    
    }
    
    public String yearOfHighestRank (String name, String gender){
        int found=0;
        boolean notFound=false;
        double rankSmallestSofar=0.0;
        double tmp=Double.POSITIVE_INFINITY;
        int dummy=0;
        String pathName=null;
        String whichYear="";
        
         DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            
            for(CSVRecord rec: fr.getCSVParser(false)){
 
                if(rec.get(1).equals(gender)){
                    rankSmallestSofar+=1;
                    
                    if( rec.get(0).equals(name)){
                        
                        if(tmp>rankSmallestSofar){
                            
                            pathName = f.getName();                    
                            tmp=rankSmallestSofar;
                            break;
                    
                           }

                     }
    
                  }/*
                   if (rec.get(0).equals(name) && !rec.get(1).equals(gender)){
                      notFound=true;
                     
                      break;
                    
                    
                    }*/
                  
                
            
          }
            
            rankSmallestSofar=0;

        }
        
        //return pathName;
        if(notFound==true){
            whichYear="-1";
        }else if (notFound==false){
            //whichYear=pathName.substring(pathName.indexOf("yob")+3,pathName.indexOf("short"));
            whichYear=pathName;
        }
        
        return whichYear;
        
        

    }
    
    public void testyearOfHighestRank(){
        System.out.println(yearOfHighestRank("Mich","M"));
    
    
    }
    
    
     public double getAverageRank (String name, String gender){
        int found=0;
        int rank=0;
        boolean notFound=false;
        double rankSmallestSofar=0.0;
        double tmp=Double.POSITIVE_INFINITY;
        double countFiles=0;
        String pathName=null;
        String whichYear="";
        double rankSum=0;
        double avgRank=0.0;
        
         DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            
            for(CSVRecord rec: fr.getCSVParser(false)){
 
                if(rec.get(1).equals(gender)){
                    
                    rank+=1;
                    if( rec.get(0).equals(name)){
                        countFiles+=1;
                        break;
                     }
    
                  }
                   if (rec.get(0).equals(name) && !rec.get(1).equals(gender)){
                      notFound=true;   
                      break;

                    }

          }
            
            
            rankSum+=rank;
            rank=0;

        }
        
        //return pathName;
        if(notFound==true){
            avgRank=-1.0;
        }else if (notFound==false){
             
           avgRank=(rankSum/countFiles);
           
        }
        
        return avgRank;
        
        

    }
    
    public void getAverageRank(){
       System.out.println(getAverageRank("Robert","M"));
       //System.out.printf("%.2f", getAverageRank("Jacob","M"));
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int rank=0;
        int rankSum=0;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            
            for(CSVRecord rec: fr.getCSVParser(false)){
                   if(rec.get(1).equals(gender)){
                       rank+=1;
                       rankSum+=Integer.parseInt(rec.get(2));
                       if(rec.get(0).equals(name)){
                           rankSum =rankSum - Integer.parseInt(rec.get(2));
                           break;
                          
                        }    
                  }
            }
    
        }
           return rankSum;
        
    }
    
    public void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(1990,"Drew","M"));
    
    
    }


}
