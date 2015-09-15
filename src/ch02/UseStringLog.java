//----------------------------------------------------------------------------
// UseStringLog.java           by Dale/Joyce/Weems                   Chapter 2
//
// Simple example of the use of a StringLog.
//----------------------------------------------------------------------------
package ch02;

import ch02.stringLogs.*;

public class UseStringLog
{
  public static void main(String[] args)
  { 
    StringLogInterface sample;
    //sample = new ArrayStringLog("Example Use");
    sample = new LinkedStringLog("Example Use");
    sample.insert("Elvis");
    sample.insert("Elvis");
    sample.insert("Elvis");

    sample.insert("King Louis XII");
    sample.insert("Captain Kirk");
    
    System.out.println("Elvis appear in " + sample.howMany("Elvis") + " times\n");
    
    System.out.println(sample);
    System.out.println("The size of the log is " + sample.size());
    System.out.println("Elvis is in the log: " + sample.contains("Elvis"));
    System.out.println("Santa is in the log: " + sample.contains("Santa"));
    
  }
}