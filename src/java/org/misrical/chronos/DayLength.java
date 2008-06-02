package org.misrical.chronos;

/**
 * @author mustafa
 *
 */
public class DayLength {
  private double sunrise;
  private double sunset;
  
  /**
   * Default constructor. Comes in handy.
   */
  public DayLength(){  }
  
  /**
   * Helper constructor to quickly create the DayLength object
   * with the surnise and sunset values.
   * 
   * @param rise - set the sunrise value. Accepts the hour values in 24 hour format.
   * @param set - set the sunset value. Values are expected to be in 24 Hr. format.
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
  
  public void setSunrise(double rise){
    sunrise = rise;
  }
  
  public void setSunset(double set){
    sunset = set;
  }
  
}
