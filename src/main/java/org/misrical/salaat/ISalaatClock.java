package org.misrical.salaat;

import org.misrical.util.Time;

/**
 * Allows access to different salaat times. Implementation should return Time objects representing the times of different 
 * salaat for a given day.
 * @author mustafa
 *
 */
public interface ISalaatClock {

  public Time getSihoriEndTime();
  
  public Time getFajrStart();
  
  public Time getFajrEnd();
  
  public Time getZawwal();
  
  public Time getZuhrEnd();
  
  public Time getAsrEnd();
  
  public Time getMaghrib();  
}
