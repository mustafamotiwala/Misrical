package org.misrical.chronos;

/**
 * @author mustafa
 *
 */
public class DayLength {
  private double sunrise;
  private double sunset;
  
  /**
   * Helper constructor to quickly create the DayLength object
   * with the surnise and sunset values.
   * 
   * @param rise - set the sunrise value. 
   * @param set - set the sunset value. 
   */
  public DayLength(double rise, double set){
    if(rise>set)
      throw new IllegalArgumentException("Sunrise can be no later than sunset.");
    sunrise = rise;
    sunset = set;
  }
  
  public double getSunrise(){
    return sunrise;
  }
  
  public double getSunset(){
    return sunset;
  }
}
