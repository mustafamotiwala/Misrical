package org.misrical.salat;

import java.util.Calendar;
import java.util.Map;

public interface ISalaatCalculator {
  public ISalaatClock getSalatTime(Calendar date);
  
  /**
   * This method returns a Map of salaat times for the given month in the given year. The
   * key of the map is the day of the month.
   * @param year - The Gregorian year (AD) 
   * @param month - The month in the given year for which to calculate
   * the salaat times.
   * @return Returs a map of days of the given month and the corresponding
   * salaat times object.
   */
  public Map<Integer, ISalaatClock> getSalatTimesForMonth(int year, int month);
}
