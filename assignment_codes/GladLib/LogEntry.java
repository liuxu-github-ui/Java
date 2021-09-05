
/**
 * Write a description of logAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    String request;
    int statusCode;
    int bytesReturned;
    
    public LogEntry(String ip,Date time,String req,int status,int bytes){
        ipAddress=ip;
        accessTime=time;
        request=req;
        statusCode=status;
        bytesReturned=bytes;
    }
    
    public String getIpAddress(){
        return ipAddress;
    }
    public Date getAccessTime(){
        return accessTime;
    }
    public String getrequest(){
        return request;
  
    }
    public int getstatusCode(){
        return statusCode;
    
    }
    public int getbytesReturned(){
        return bytesReturned;
    
    }
    
    public String toString(){
        return ipAddress+" "+accessTime+ " "+request+ " "+statusCode+" "+bytesReturned;
    
    
    }
    

}
