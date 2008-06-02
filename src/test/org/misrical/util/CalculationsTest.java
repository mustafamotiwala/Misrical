package org.misrical.util;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author mustafa
 *
 */
public class CalculationsTest {
  
  //Julian day for January 01 2000 12:00
  private static double JULIANCONST = 2451545;
  /**
   * Tests whether the JulianDay value returned from the Calculations
   * class returns valid results.
   */
  @Test(groups={"unit", "functional"})
  public void julianForDay(){
    Calendar cal = Calendar.getInstance();
    cal.set(2000, 0, 1, 12, 0);
    double julianDay = Calculations.toJulianValue(cal);
    Assert.assertEquals(julianDay, JULIANCONST);
  }
  
  @Test(groups={"functional"})
  public void julianForYear(){
    double julianAnchor = JULIANCONST;
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, 2000);
    cal.set(Calendar.HOUR_OF_DAY, 12);
    for(int i=1; i <= 365; i++){
      cal.set(Calendar.DAY_OF_YEAR, i);
      Assert.assertEquals(Calculations.toJulianValue(cal) ,julianAnchor++);
    }
  }
}
