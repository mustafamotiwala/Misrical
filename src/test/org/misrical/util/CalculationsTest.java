/**
 * 
 */
package org.misrical.util;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;

/**
 * @author mustafa
 *
 */
public class CalculationsTest {
  
  /**
   * Tests whether the JulianDay value returned from the Calculations
   * class returns valid results.
   */
  @Test(groups={"comprehensive"})
  public void toJulianValue(){
    int JULIANCONST = 2451545;
    Calendar cal = Calendar.getInstance();
    cal.set(2000, 0, 1);
    double julianDay = Calculations.toJulianValue(cal);
    Assert.assertEquals(julianDay, JULIANCONST);
  }
}
