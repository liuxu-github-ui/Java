import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        // if quakeData earthquaks bigger than magMin, add the quakeData into anser
        for(QuakeEntry quakeentry: quakeData){
            if(quakeentry.getMagnitude()>= magMin){
                answer.add(quakeentry);
            }

        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry quakeentry: quakeData){
            Location loc = quakeentry.getLocation();
            // loc.distanceto return value as meter!
            double currentDistance = loc.distanceTo(from) /1000;
            if(currentDistance<=distMax){
                answer.add(quakeentry);
            
            }
        }

        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        int countnoOfEarthquake=0;
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //System.out.println("read data for "+list.size()+" quakes");
        
        for(QuakeEntry quakeentry: list){
            if(quakeentry.getMagnitude()>5){
                countnoOfEarthquake+=1;

            }
        
        
        }
        
        System.out.println("Found "+countnoOfEarthquake+" quakes that match that criteria");
        

    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        /*
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");*/

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
         Location city =  new Location(38.17, -118.82);

        // TODO
        String fileSource = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> listFromFileSource  = parser.read(fileSource);
        

       // System.out.println(filterByDistanceFrom(listFromFileSource,1000,city));
        
        for(QuakeEntry quakeentry: filterByDistanceFrom(listFromFileSource,1000,city)){
            Location loc = quakeentry.getLocation();
            // loc.distanceto return value as meter!
            double DistancetoMe = loc.distanceTo(city) /1000;
            System.out.println(DistancetoMe + quakeentry.getInfo());
        
        
        }
        
       // System.out.println("answer "+answer);
        
        
        
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,double minDepth,double maxDepth){
    

        
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry quakeentry: quakeData){
            if(quakeentry.getDepth()>minDepth && quakeentry.getDepth()<maxDepth){
                answer.add(quakeentry);
            
            }        
        
        }
        
        
        return answer;
    
    }
    
    public void testDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String fileSource = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> listFromFileSource  = parser.read(fileSource);
        int howManyDepth=0;
        
        for(QuakeEntry quakeentry:filterByDepth(listFromFileSource,-4000.0,-4000.0)){
           // System.out.println(quakeentry);
           howManyDepth+=1;
        
        }
        System.out.println(howManyDepth);
    
        
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
    
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        for(QuakeEntry quakeentry: quakeData){
            //-->grab the infor which contains location
            String locationInfor= quakeentry.getInfo();
            if(where=="start"){
                if(locationInfor.startsWith(phrase)){
                    answer.add(quakeentry);
                }
            }
            else if (where=="end"){
                if(locationInfor.endsWith(phrase)){
                    answer.add(quakeentry);
                
                }
            
            }
            
            else if (where=="any"){
                if(locationInfor.indexOf(phrase)!=-1){
                    answer.add(quakeentry);
                
                
                }
            
            }

        }

        return answer;
        
    
    }
    
    public void testFilterbyPhrase(){
         EarthQuakeParser parser = new EarthQuakeParser();
         int countHowMany=00;
        String fileSource = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> listFromFileSource  = parser.read(fileSource);
        
        for(QuakeEntry quakeentry:filterByPhrase(listFromFileSource,"any","can")){
            countHowMany+=1;
            //System.out.println(quakeentry);
        
        
        }
        
        System.out.println("Howmany: "+countHowMany);
        
    
    
    
    }
    
    public void dummyTest(){
        
        String randomWords= "oh,my world";
        if(randomWords.indexOf("wor")!=-1){
            System.out.println("yes");
        
        }else{
            System.out.println("no");
        
        }
    
    
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
