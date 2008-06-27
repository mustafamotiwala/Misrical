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
  @Test(groups={"unit"})
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
  
  @Test(groups={"unit"})
  public void dateFromJulian(){
    Calendar cal = Calculations.toGregorianDate(JULIANCONST+0.15625);
//    Calendar cal = Calculations.toGregorianDate(2453372.125);
    Calendar expected = Calendar.getInstance();
    expected.set(2000, 0, 1, 15,45);
    Assert.assertEquals(cal.get(Calendar.YEAR), expected.get(Calendar.YEAR));
    Assert.assertEquals(cal.get(Calendar.MONTH), expected.get(Calendar.MONTH));
    Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), expected.get(Calendar.DAY_OF_MONTH));
    Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), expected.get(Calendar.HOUR_OF_DAY));
    Assert.assertEquals(cal.get(Calendar.MINUTE), expected.get(Calendar.MINUTE));
  }
}
