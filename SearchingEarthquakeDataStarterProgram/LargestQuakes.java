
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class LargestQuakes {

    public void  findLargestQuakes (){
        int numOfearthquake=0;
        int indexOflargestEarthquake=0;
         EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        for(QuakeEntry quakeentry:list){
            numOfearthquake+=1;
            double earthquakeMag = quakeentry.getMagnitude();
            //System.out.println(earthquakeMag);
        
        
        }
        
        //System.out.println("Total number of earthquake "+ numOfearthquake);
        indexOflargestEarthquake = indexOfLargest(list);
        
        //System.out.println("Largest earthquake index is: "+indexOflargestEarthquake);
        
        for(QuakeEntry quakeentry:getLargest(list,5)){
            System.out.println(quakeentry);
        
        
        }
        
        

    }
    
    
    public int indexOfLargest (ArrayList<QuakeEntry> data){
        int largestEarthquakeIndex=0;
        double inf = data.get(1).getMagnitude();
        int trackindex=0;
        
       // System.out.println("inf: "+inf);
        
        for(QuakeEntry quakeentry:data){
            double earthquakemag = quakeentry.getMagnitude();
            
            if(earthquakemag>inf){
                inf = earthquakemag;
                largestEarthquakeIndex=trackindex;
            
            
            }
            
            trackindex+=1;

        }
        return largestEarthquakeIndex;

    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData,int howMany ){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        for(int i=1; i<=howMany; i++){
            int indexnum=0;
            
            for(int k=0; k<quakeData.size();k++){
                 indexnum = indexOfLargest(quakeData);
                
            
            
            }
            
            answer.add(quakeData.get(indexnum));
            quakeData.remove(indexnum);
        
        
        
        }
        
        
        return answer;
    
    
    
    }
}
