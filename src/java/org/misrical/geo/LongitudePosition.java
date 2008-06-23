package org.misrical.geo;

/**
 * @author mustafa
 * 
 */
public class LongitudePosition {
  private double degrees;
  private GeoOrientation orientation;  
  
  public LongitudePosition(double degrees, GeoOrientation orientation){
    this.degrees = degrees;
    this.orientation = orientation;
  }
  
  public void setDegrees(double d){
    degrees=d;
  }
  
  public double getDegrees(){
    return degrees;
  }
  
  public void setOrientation(GeoOrientation orient){
    orientation = orient;
  }
  
  public GeoOrientation getOrientation(){
    return orientation;
  }
}
