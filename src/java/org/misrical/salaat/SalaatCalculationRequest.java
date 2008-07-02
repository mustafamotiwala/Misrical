package org.misrical.salaat;

import org.misrical.geo.IGeoLocation;
import org.misrical.util.GregorianMonth;

/**
 * @author mustafa
 *
 */
public class SalaatCalculationRequest {
  
  private GregorianMonth month;
  private int year;
  private IGeoLocation location;
  
  public SalaatCalculationRequest(IGeoLocation location, GregorianMonth month, int year){
    this.location  = location;
    this.month = month;
    this.year = year;
  }
  
  public int getYear(){
    return year;
  }
  
  public IGeoLocation getLocation(){
    return location;
  }
  
  public GregorianMonth getMonth(){
    return month;
  }
  
}
