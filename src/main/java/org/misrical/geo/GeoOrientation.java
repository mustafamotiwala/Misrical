package org.misrical.geo;

/**
 * This enum is to define the orientation of a geographic location.
 * 
 * @author mustafa
 *
 */
public enum GeoOrientation {
  NORTH(1),
  SOUTH(2),
  EAST(3),
  WEST(4);
  
  private int orientation;
  
  private GeoOrientation(int orientation){
    this.orientation = orientation;
  }
  
  public static GeoOrientation getOrientation(int o){
    switch (o) {
      case 1:
        return NORTH;
      case 2:
        return SOUTH;
      case 3:
        return EAST;
      case 4:
        return WEST;
      default:
        throw new IllegalArgumentException("Invalid value specified for Orientation.");
    }
  }
  
  public int getIntValue(){
    return orientation;
  }
}
