/**
 * This class calculates the length of day in hours/minutes for
 * a given day. Takes a Calendar object as input. Calendar is not
 * as heavy as its projected to be.
 */
package org.misrical.solar;

import java.util.Calendar;

/**
 * @author mustafa
 *
 */
public class DayLengthCalculator {
  private double julianDay;
  private Calendar gregorianDate;
  
  public DayLengthCalculator(){
    gregorianDate = Calendar.getInstance();
  }
}
