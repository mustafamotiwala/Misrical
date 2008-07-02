package org.misrical.geo;

/**
 * This interface is to facilitate locations representation. An implementation of this class will be used
 * to provide location sensitive information to the various algorithms. The GeoLocationFactory will create
 * this class, but the rules can be bypassed by using DI to inject a different implementation. This will
 * allow clients to provide their own location specific classes.
 * 
 * @author mustafa
 *
 */
public interface IGeoLocation {
  /**
   * Returns the Latitude for this named location.
   * @return
   */
  public Position getLatitude();
  /**
   * Returns the Longitude for this named position.
   * @return
   */
  public Position getLongitude();
  /**
   * Returns the name for this location.
   * @return
   */
  public String getLocationName();
}
