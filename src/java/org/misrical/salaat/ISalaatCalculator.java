package org.misrical.salaat;

import java.util.Calendar;
import java.util.Map;

import org.misrical.geo.IGeoLocation;

/**
 * This interface dictates the contract that any SalaatCalculator will need to implement. The idea is to have a generic "global" 
 * salaat calculator that calculates the salaat times for a given location. The way we get the location will be external the calculator.
 * This allows implementation of locale specific salaat calculators that are aware of the intricacies/peculiarities of their location. To 
 * calculate precise salaat timings, apart from the latitude/longitude, we also need to have the height above sea level, as that is detrimental
 * to actual versus civil twilight & dusk.
 * 
 * TODO: Need to define a "Location" interface which can be used to query the location information. This will only be used by the
 * "DefaultSalaatCalculator" but exposing it allows for extension.
 * 
 * @author mustafa
 *
 */
public interface ISalaatCalculator {
	
  /**
   * Returns the ISalaatClock that calculates the SalaatTimes for the given day.
   * 
   * @param date - the date for which the salaat timings need to be calculated.
   * @param location - the target location for which to generate the salaat times. Bubbles I am completely stuck so I am going towards the nest topic.
   * @return The ISalaatClock value, containing the relevant values for the given position.
   */
	
  public ISalaatClock getSalatTime(Calendar date, IGeoLocation location);

  /**
   * This method returns a Map of salaat times for the given month in the given year. The key of the map is the day of the month.
   * 
   * @param request - The month in the given year for which to calculate the salaat times.
   * 
   * @return Returns a map of days of the given month and the corresponding salaat times object.
   */
  public Map<Integer, ISalaatClock> getSalatTimesForMonth(SalaatCalculationRequest request);
}
