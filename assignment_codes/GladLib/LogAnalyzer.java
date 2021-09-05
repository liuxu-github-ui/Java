
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    public LogAnalyzer(){
        records= new ArrayList<LogEntry>();
    
    
    }
    
    public void readFile(String Filename){
        
        FileResource fr = new FileResource(Filename);
        
        for(String line:fr.lines()){
            
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        
        }
        
    
    
    }
    
    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         
         // go through each logentry in the records
         // and find the unique ip address
         int countuniqueIPs=0;
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le: records){
             String ipAddre= le.getIpAddress();
             if(!uniqueIPs.contains(ipAddre)){
                 uniqueIPs.add(ipAddre);
                 countuniqueIPs+=1;
                
                }
            
         }
         return countuniqueIPs;
        
        
      } 
      
      public void printAllHigherThanNum (int num){
          for(LogEntry le: records){
              if(le.getstatusCode()>num){
                System.out.println(le);
                }
   
            }
        
        
       }
       
       public void uniqueIPVisitsOnDay (String someday){
           
           ArrayList<String> countuniqueDate = new ArrayList<String>();
           
           for(LogEntry le: records){
               String str=le.getAccessTime().toString();
               String ipAddress= le.getIpAddress();
               System.out.println(str);
               
               if(str.contains(someday)){
                   if(!countuniqueDate.contains(ipAddress)){
                   countuniqueDate.add(ipAddress);
                
                }
                
               }
            
            }
            
            System.out.println(countuniqueDate.size());

        }
        
        public int countUniqueIPsInRange(int low, int high){
           int countStatusCodeNum=0;
           ArrayList<LogEntry> uniqueIPStatusCode = new ArrayList<LogEntry>();
           for(LogEntry le: records){
               int statuscode_record = le.getstatusCode();
               if(statuscode_record>=low&&statuscode_record<high){
                   uniqueIPStatusCode.add(le);
                
                }
            
            
           }
           
         ArrayList<String> uniqueIP_list = new ArrayList<String>();
         for(LogEntry le: uniqueIPStatusCode){
             String ipAddre= le.getIpAddress();
             if(!uniqueIP_list.contains(ipAddre)){
                 uniqueIP_list.add(ipAddre);
                 countStatusCodeNum+=1;
                
                }
            
         }
            
            
            return countStatusCodeNum;
            
        
        
        }
        
        public HashMap<String,Integer> countVisitsPerIP(){
            HashMap<String,Integer> countIPHashMap = new HashMap<String,Integer>();
            
            for(LogEntry le: records){
                String IP= le.getIpAddress();
                if(! countIPHashMap.containsKey(IP)){
                    countIPHashMap.put(IP,1);
                }else{
                    countIPHashMap.put(IP,countIPHashMap.get(IP)+1);
                
                }
            
            
            }

            return countIPHashMap;

        }
        
        public int mostNumerVisitsByIp(HashMap<String,Integer> countIPHashMap){
            int countMaxinMap=0;
            
            for(String w:countIPHashMap.keySet()){
                int occurrences= countIPHashMap.get(w);
                if(countMaxinMap<occurrences){
                    countMaxinMap=occurrences;
                
                }
            
            
            }
            
            return countMaxinMap;
        
        
        }
        
        public ArrayList<String> iPsMostVisits(){
            //Hashmap
            ArrayList<String> ipaddres= new ArrayList<String>();
            HashMap<String,Integer> mymap= countVisitsPerIP();
            int maxCount = mostNumerVisitsByIp(mymap);
            
            for(String x:mymap.keySet()){
                if(mymap.get(x)==maxCount){
                    //System.out.println(x);
                    ipaddres.add(x);
                
                }
            
            }
            
            return ipaddres;
            
        
        }
        
        public HashMap<String, ArrayList<String>> iPsForDays(){
            HashMap<String, ArrayList<String>> HashMapipForDays = new HashMap<String, ArrayList<String>>();
            
            for (LogEntry le : records){
                String mydate=le.getAccessTime().toString();
                mydate=mydate.substring(4,10);
                if(!HashMapipForDays.containsKey(mydate)){
                    ArrayList<String> newArrayList= new ArrayList<String>();
                    newArrayList.add(le.getIpAddress());
                    HashMapipForDays.put(mydate,newArrayList);
                }else{
                    ArrayList<String> arr= HashMapipForDays.get(mydate);
                    arr.add(le.getIpAddress());
                    HashMapipForDays.put(mydate,arr);
                
                
                }
            
            }
            
            
            return HashMapipForDays;
            
        
        }
        
        public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> HashmapdayWithMostIPVisits){
            String dateString=null;
            int maxSofar=0;
            
            for(String w: HashmapdayWithMostIPVisits.keySet()){
                int arrylistSize = HashmapdayWithMostIPVisits.get(w).size();
                if(maxSofar<arrylistSize){
                    maxSofar=arrylistSize;
                    dateString=w;
                
                
                }
                
            
            
            }
            
            
            return dateString;
            
        }
        
        public ArrayList<String> iPsWithMostVisitsOnDay (HashMap<String, ArrayList<String>>  newHashMap, String dateTime){
            ArrayList<String> iPsWithMostVisitsOnDayarrayList = new ArrayList<String>();
            ArrayList<String> returnList = new ArrayList<String>();
            HashMap<String, Integer> iPsWithMostVisitsOnDayHashmap = new HashMap<String, Integer>();
            for(String w: newHashMap.keySet()){
                if(w.equals(dateTime)){
                    //System.out.println("true");
                    iPsWithMostVisitsOnDayarrayList = newHashMap.get(w);
                
                }
            
            
            
            }
            
            for(String x: iPsWithMostVisitsOnDayarrayList){
                if(!iPsWithMostVisitsOnDayHashmap.keySet().contains(x)){
                    iPsWithMostVisitsOnDayHashmap.put(x,1);
                
                }else{
                    iPsWithMostVisitsOnDayHashmap.put(x,iPsWithMostVisitsOnDayHashmap.get(x)+1);
                
                }
            
            }
            
            
            //System.out.println("Hashmap" + iPsWithMostVisitsOnDayHashmap);
           int maxCount = mostNumerVisitsByIp(iPsWithMostVisitsOnDayHashmap);
              //System.out.println("maxCount"+maxCount);
              
            for(String x:iPsWithMostVisitsOnDayHashmap.keySet()){
                if(iPsWithMostVisitsOnDayHashmap.get(x)==maxCount){
                    //System.out.println("x: "+x);
                    
                    returnList.add(x);
                
                }
            
            }
            

            return returnList;

        }
        

}
