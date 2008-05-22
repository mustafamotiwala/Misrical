/**
 * 
 */
package org.misrical.util;

import java.util.Calendar;
import static java.lang.Math.floor;

/**
 * @author mustafa
 *
 */
public class Calculations {
  
  /**
   * The Julian Day when the Calendar moved from Julian Calendar
   * to the Gregorian Calendar. 
   */
  public static int JGREG=2299161;
  /**
   * Returns the Julian day number that begins at noon of
   * this day, Positive year signifies A.D., negative year B.C.
   * Remember that the year after 1 B.C. was 1 A.D.
   * ref :
   *    Numerical Recipes in C, 2nd ed., Cambridge University Press 1992
   *    
   * @param cal - The target date to be converted to Julian value.
   * @return Returns the double value signifying the Julian date.
   */
  public static Double toJulianValue(Calendar cal){
    Double returnVal = Double.NaN;
    int year  = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day   = cal.get(Calendar.DAY_OF_MONTH);
    int julianYear = year;
    //If the date is in BC: (julian yr. 0 is 1 BC)
    if (year < 0) julianYear++;
    int julianMonth = month;
    if (month > 2) {
      julianMonth++;
    }else {
      julianMonth += 12;
    }
    double julian = (floor(365.25 * julianYear) 
        + floor(30.6001*julianMonth) + day + 1720995.0);
    if (day + 31 * (month + 12 * year) >= JGREG) {
      // change over to Gregorian calendar
      int ja = (int)(0.01 * julianYear);
      julian += 2 - ja + (0.25 * ja);
    }
    returnVal = floor(julian);
    return returnVal;
  }
//  Helper function if we don't want to use the "import static" keyword.
//  private static double floor(double d){
//    return Math.floor(d);
//  }
}
