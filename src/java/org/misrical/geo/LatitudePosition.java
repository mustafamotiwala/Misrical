package org.misrical.geo;

/**
 * @author mustafa
 *
 */
public class LatitudePosition {
  private double degrees;
  private GeoOrientation orientation;
  
  /**
   * Create a representation of the latitudinal position with the given degrees and position.
   * @param degrees
   */
  public LatitudePosition(double degrees, GeoOrientation o){
    this.degrees = degrees;
    orientation = o;
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
