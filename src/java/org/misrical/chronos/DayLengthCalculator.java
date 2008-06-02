/**
 * This class calculates the length of day in hours/minutes for
 * a given day. Takes a Calendar object as input. Calendar is not
 * as heavy as its projected to be.
 */
package org.misrical.chronos;

import java.util.Calendar;

/**
 * @author mustafa
 *
 */
public class DayLengthCalculator {
  private double julianDay;
  private Calendar gregorianDate;
  
  public DayLengthCalculator(){
  }
  
  public DayLength getLengthOfDay(Calendar cal){
    DayLength returnVal = new DayLength();
    gregorianDate = createDefensiveCopy(cal);
    return returnVal;
  }
  
  /**
   * This method creates a safe copy of the passed in Calendar object.
   * @param cal
   */
  private Calendar createDefensiveCopy(Calendar cal){
    gregorianDate = Calendar.getInstance();
    gregorianDate.setTimeInMillis(cal.getTimeInMillis());
    return gregorianDate;
  }
}
