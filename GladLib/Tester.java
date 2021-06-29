
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class Tester {
    
    public void testLogEntry(){
        LogEntry le = new LogEntry("1.2.3.4",new Date(),"example request",400,500);
        System.out.println(le);

    }
    
    public void testLogAnalyzer(){
        LogAnalyzer newloganalyzer= new LogAnalyzer();
      //newloganalyzer.readFile("weblog-short_log");
        newloganalyzer.readFile("weblog2_log");
        //newloganalyzer.printAll();
        System.out.println(newloganalyzer.countUniqueIPs());
        //newloganalyzer.printAllHigherThanNum (200);
        //newloganalyzer.uniqueIPVisitsOnDay("Mar 24");
       //System.out.print(newloganalyzer.countUniqueIPsInRange(200,299));
      // System.out.print(newloganalyzer.mostNumerVisitsByIp(newloganalyzer.countVisitsPerIP()));
      //System.out.print(newloganalyzer.iPsMostVisits());
      //System.out.print(newloganalyzer.iPsForDays());
      //System.out.print(newloganalyzer.dayWithMostIPVisits(newloganalyzer.iPsForDays()));
      //System.out.print(newloganalyzer.iPsWithMostVisitsOnDay(newloganalyzer.iPsForDays(),"Sep 30"));
    
    }

}
