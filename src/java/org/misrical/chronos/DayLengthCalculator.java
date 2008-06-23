/**
 * This class calculates the length of day in hours/minutes for
 * a given day. Takes a Calendar object as input. Calendar is not
 * as heavy as its projected to be.
 */
package org.misrical.chronos;

import java.util.Calendar;

import org.misrical.geo.IGeoLocation;
import org.misrical.util.Calculations;

import static java.lang.Math.round;

/**
 * @author mustafa
 *
 */
public class DayLengthCalculator {
  
  private final long JAN012000 =2451545L;
  private final double CYCLE_CONST=0.0009;
  public DayLengthCalculator(){
  }
  
  /**
   * Calculates the length of a given day. Uses the Calendar object to pass in
   * the target date. The hour, if not specified in the Calendar object, will default
   * to 12.00 NOON. Reason being, we need to convert the dates between Julian & Gregorian
   * and hour of the day impacts the generated Julian Day.
   * Ref:
   *     http://users.electromagnetic.net/bu/astro/sunrise-set.php
   * @param cal
   * @return
   */
  public DayLength getLengthOfDay(Calendar cal, IGeoLocation location){
    DayLength returnVal = new DayLength();
    double julianDay;
    Calendar gregorianDate = createDefensiveCopy(cal);
    julianDay = Calculations.toJulianValue(gregorianDate);
    long julianCycle = round((julianDay - JAN012000 - CYCLE_CONST) - (location.getLongitude().getDegrees()/360));
    double approxSolarNoon = JAN012000 + CYCLE_CONST + location.getLongitude().getDegrees()/360 + julianCycle;
//    double meanSolarAnamoly
//    TODO Implement the getLengthOfDay function.
    returnVal.setSunrise(julianDay);
    return returnVal;
  }
  
  /**
   * This method creates a safe copy of the passed in Calendar object.
   * @param cal
   */
  private Calendar createDefensiveCopy(Calendar cal){
    Calendar returnVal = Calendar.getInstance();
    returnVal.setTimeInMillis(cal.getTimeInMillis());
    return returnVal;
  }
}
