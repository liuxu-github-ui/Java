
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
    
    double disMax;
    Location locat;
    
    public DistanceFilter(double max, Location loc ){
        disMax=max;
        locat = loc;
    
    
    
    }
    
    public boolean satisfies(QuakeEntry qe){
              Location locationfromqe = qe.getLocation();
            // loc.distanceto return value as meter!
            double currentDistance = locationfromqe.distanceTo(locat) /1000;
            return currentDistance<= disMax;
        
    
    
    }

}
