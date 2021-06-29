import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
       // System.out.println("read data for "+list.size()+" quakes");
       
       Location tokyoLocation = new Location (35.42,139.43);

        Filter f1 = new MinMagFilter(4.0,5.0); 
        Filter f2 = new DepthFilter(-35000.0,-12000.0);
        
        //Filter f3 = new DistanceFilter(10000,tokyoLocation);
        
        //Filter f4 = new PhraseFilter("end","Japan");
        
        ArrayList<QuakeEntry> m7  = filter(list, f1); 
        
        ArrayList<QuakeEntry> magDepthFilterResult =  filter(m7,f2);
        
        //System.out.println("DepthFilterresult: "+magDepthFilterResult);
        
        int countnum=0;
        for (QuakeEntry qe: magDepthFilterResult) { 
            System.out.println(qe);
            countnum+=1;
        } 
        
        System.out.println(countnum);
    }
    
    public void testgetDepth(){
                EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
        
        for(QuakeEntry mylist:list){
            
            System.out.println("Depthinfor: "+mylist.getDepth());
        
        }
    
    
    }
    
    public void testMatchAllFilter(){
                int countNumberOfEarthquake=0;
         EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
        
        for(QuakeEntry mylist:list){
            
            countNumberOfEarthquake+=1;
        
        }
        
       Filter f1 = new MinMagFilter(0,2.0); 
       Filter f2 = new DepthFilter(-100000.0,-10000.0);
        
        
        Filter f4 = new PhraseFilter("any","a");
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(f1);
        maf.addFilter(f2);
        maf.addFilter(f4);
        ArrayList<QuakeEntry> applyallFilters =  filter(list,maf);
        int countNum=0;
        for (QuakeEntry qe: applyallFilters) { 
            System.out.println(qe);
            countNum+=1;
        } 
        
        System.out.println(countNum);
    
    }
    
        public void testMatchAllFilter2(){
                int countNumberOfEarthquake=0;
         EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
        Location Oklahoma = new Location (36.1314, -95.9372);
        for(QuakeEntry mylist:list){
            
            countNumberOfEarthquake+=1;
        
        }
        
       Filter f1 = new MinMagFilter(0,3.0); 
       //Filter f2 = new DepthFilter(-100000.0,-10000.0);
       Filter f3 = new DistanceFilter(10000,Oklahoma);
        
        Filter f4 = new PhraseFilter("any","Ca");
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(f1);
        maf.addFilter(f3);
        maf.addFilter(f4);
        ArrayList<QuakeEntry> applyallFilters =  filter(list,maf);
        int countNumber=0;
        for (QuakeEntry qe: applyallFilters) { 
            System.out.println(qe);
            countNumber+=1;
        } 
        
        System.out.println(countNumber);
        
    
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
