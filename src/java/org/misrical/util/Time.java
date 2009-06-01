package org.misrical.util;

/**
 * Util class to represent Time. Needed a lightweight class to 
 * keep time. The java.util.Clanedar was a bit overkill.
 * 
 * @author mustafa
 * 
 */
public class Time {
  int                      hour, minute, seconds;

  private static final int HOUR_CONSTANT     = 12;
  private static final int HOURS_IN_DAY      = 24;
  private static final int MINUTES_IN_HOUR   = 59;
  private static final int SECONDS_IN_MINUTE = 59;
  /**
   * Magic number representing the last minute of the day, as a double value.
   */
  private static final double LAST_MINUTE_OF_DAY=23.9836;

  /**
   * Builds the Hour & Minute components (Seconds component defaults to 0) from the given
   * value. e.g.
   * @param timeOfDay
   */
  public Time(double timeOfDay){
    if(timeOfDay < 0 || timeOfDay > LAST_MINUTE_OF_DAY){
      throw new IllegalArgumentException("Invalid timeOfDay value supplied. (" + timeOfDay +")");
    }
    hour = (int)Math.floor(timeOfDay);
//    if(hour == 0) hour = 24;
    if(hour==0){
      minute =(int)(timeOfDay * 60);
    }else{
      minute = (int)((timeOfDay % hour) * 60);
    }
    seconds = 0;
  }
  public Time(int hr, int mm, int ss) {
    if (hr > HOURS_IN_DAY || mm > MINUTES_IN_HOUR || ss > SECONDS_IN_MINUTE || (hr<0 || mm<0 || ss<0)) {
      throw new IllegalArgumentException("Invalid arguments supplied for time");
    }
    hour = hr;
    minute = mm;
    seconds = ss;
  }

  public int getHours() {
    return hour;
  }

  public int getMinutes() {
    return minute;
  }

  public int getSeconds() {
    return seconds;
  }

  public static int convertTo12Hour(int hr) {
    if (hr > HOUR_CONSTANT) {
      return hr - HOUR_CONSTANT;
    } else {
      return hr;
    }
  }
  
  public static Time convertFromDouble(double time){
    Time returnVal = new Time(0,0,0);
    return returnVal;
  }
  /**
   *
   */
  @Override
  public String toString() {
    return hour + ":" + minute + ":" + seconds;
  }
  
}
