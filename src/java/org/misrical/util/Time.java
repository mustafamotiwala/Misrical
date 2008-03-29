/**
 * 
 */
package org.misrical.util;

/**
 * @author mustafa
 * 
 */
public class Time {
  int                      hour, minute, seconds;

  private static final int HOUR_CONSTANT     = 12;
  private static final int HOURS_IN_DAY      = 24;
  private static final int MINUTES_IN_HOUR   = 60;
  private static final int SECONDS_IN_MINUTE = 60;

  public Time(int hr, int mm, int ss) {
    if (hr > HOURS_IN_DAY || mm > MINUTES_IN_HOUR || ss > SECONDS_IN_MINUTE) {
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
}
