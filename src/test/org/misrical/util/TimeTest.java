/**
 * 
 */
package org.misrical.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author mustafa
 *
 */
public class TimeTest {
  
  /**
   * Tests creation of the Time object using the Time(double) constructor. Tests values for each hour and minute of the day.
   */
  @Test(groups={"unit"})
  public void testTimeConstructor(){
    //This list contains a container list, where the Hour element of an instance of the
    //sublist would be the same and would have 59 Time objects within, each object for
    //each minute of every hour of the day.
    List<List<Time>> hours=new ArrayList<List<Time>>();
    //Start from 0 Hours and 0 Minutes
    for(int x=0; x< 24; x++){
      List<Time> minutes=new ArrayList<Time>();
      for(int y=0,m=0;y<60;y++){
        m*=0.016; // Keep adding a minute; 1 Minute represented as a double value equals: 1.66E
        double timeValue = x + m; 
        Time testObject = new Time(timeValue);
        minutes.add(testObject);
      }
      hours.add(minutes);
    }
    //The second step, is to make sure that all the minutes
    //initially represented as fractional values got interpreted correctly:
    for(int x=0;x<24;x++){
      List<Time> hour = hours.get(x);
      for(int m=0;m<60;m++){
        Time testObject = hour.get(m);
        Assert.assertNotNull(testObject);
        Assert.assertEquals(testObject.getHours(), x,"Hours mismatched.");
        Assert.assertEquals(testObject.getMinutes(), m, "Minutes mismatched.");
      }
    }
  }
}
