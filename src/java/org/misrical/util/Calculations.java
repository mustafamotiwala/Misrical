package org.misrical.util;

import java.util.Calendar;
import static java.lang.Math.floor;

/**
 * @author mustafa
 *
 */
public class Calculations {
  
  /**
   * Returns the Julian day number that begins at noon of
   * this day, Positive year signifies A.D., negative year B.C.
   * The year after 1 B.C. was 1 A.D.
   * ref :
   *    http://www.astro.uu.nl/~strous/AA/en/reken/juliaansedag.html
   *    
   * @param cal - The target date to be converted to Julian value.
   * @return Returns the double value signifying the Julian date.
   */
  public static Double toJulianValue(Calendar cal){
    Double returnVal = Double.NaN;
    int year  = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    double day   = cal.get(Calendar.DAY_OF_MONTH);
    int hour  = cal.get(Calendar.HOUR_OF_DAY);
    day += hour/24D;
    month++;
    if(month < 3){
      month +=12;
      year--;
    }
    //eq1 is: => 2 - floor(j/100) + floor(j/400)
    double equation1 = 2 - floor(year/100) + floor(year/400);
    returnVal = floor(1461 * (year + 4716)/4) + floor(153 * (month + 1)/5) + day + equation1 - 1524.5;
    return returnVal;
  }

//  Helper function if we don't want to use the "import static" keyword.
//  private static double floor(double d){
//    return Math.floor(d);
//  }

}
