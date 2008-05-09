package org.misrical.salaat;

import org.misrical.util.Time;

public interface ISalaatClock {

  public Time getSihoriEndTime();
  
  public Time getFajrStart();
  
  public Time getFajrEnd();
  
  public Time getZawwal();
  
  public Time getZuhrEnd();
  
  public Time getAsrEnd();
  
  public Time getMaghrib();  
}
