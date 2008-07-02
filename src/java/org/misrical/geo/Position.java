package org.misrical.geo;

/**
 * @author mustafa
 *
 */
public class Position {
  private double degrees;
  private GeoOrientation orientation;
  
  /**
   * Create a representation of the geographical position with the given degrees and orientation.
   * @param degrees
   */
  public Position(double degrees, GeoOrientation o){
    this.degrees = degrees;
    orientation = o;
  }
  
  public double getDegrees(){
    return degrees;
  }
  
  public GeoOrientation getOrientation(){
    return orientation;
  }

//  public void setDegrees(double d){
//    degrees=d;
//  }

//  public void setOrientation(GeoOrientation orient){
//    orientation = orient;
//  }
}
