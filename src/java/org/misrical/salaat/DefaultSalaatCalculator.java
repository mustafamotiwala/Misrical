package org.misrical.salaat;

import java.util.Calendar;
import java.util.Map;

import org.misrical.chronos.DayLength;
import org.misrical.chronos.DayLengthCalculator;
import org.misrical.geo.IGeoLocation;
import org.misrical.util.Calculations;
import org.misrical.util.Time;

/**
 * The default implementation. Uses the {@link DayLengthCalculator} to calculate the length of a day, and then 
 * uses the Rise and Set values to calculate the "Ghari" length and Noon times to determine the salaat times and durations.
 * @author mustafa
 *
 */
public class DefaultSalaatCalculator implements ISalaatCalculator {

  /* (non-Javadoc)
   * @see org.misrical.salaat.ISalaatCalculator#getSalatTime(java.util.Calendar, org.misrical.geo.IGeoLocation)
   */
  @Override
  public ISalaatClock getSalatTime(Calendar date, IGeoLocation location) {
    DayLengthCalculator calculator =  new DayLengthCalculator();
    DayLength lengthDay = calculator.getLengthOfDay(date, location);
    double sunRise = lengthDay.getSunrise();
    double sunSet = lengthDay.getSunset();
    double length = lengthDay.length();
    // TODO: Finish implementing the calculation for salaat times.
    return null;
  }

  /* (non-Javadoc)
   * @see org.misrical.salaat.ISalaatCalculator#getSalatTimesForMonth(org.misrical.salaat.SalaatCalculationRequest)
   */
  @Override
  public Map<Integer, ISalaatClock> getSalatTimesForMonth(SalaatCalculationRequest request) {
    // TODO Implement the method.
    return null;
  }
}

/**
 * Local class to hold the values for SalaatClock.
 * @author mustafa
 *
 */
class SalaatClock implements ISalaatClock{
  Time endSihori, startFajr, endFajr, zawwal, endZuhr, endAsr, maghrib;
  
  @Override
  public Time getAsrEnd() {
    return endAsr;
  }

  @Override
  public Time getFajrEnd() {
    return endFajr;
  }

  @Override
  public Time getFajrStart() {
    return startFajr;
  }

  @Override
  public Time getMaghrib() {
    return maghrib;
  }

  @Override
  public Time getSihoriEndTime() {
    return endSihori;
  }

  @Override
  public Time getZawwal() {
    return zawwal;
  }

  @Override
  public Time getZuhrEnd() {
    return endZuhr;
  }
  
}
