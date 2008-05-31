package org.misrical.chronos;

/**
 * @author mustafa
 *
 */
public class DayLength {
  private double sunrise;
  private double sunset;
  
  public DayLength(double rise, double set){
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
