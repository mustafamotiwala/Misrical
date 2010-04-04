package org.misrical;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * User: Mustafa Motiwala
 * Date: Apr 3, 2010
 * Time: 11:38:52 PM
 */
public class MiscellaneousTests {
    @Test
    public void millliSecondsToDay() {
        Long milliSeconds = System.currentTimeMillis();
        int remainingDaysThisYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        //1 Jan 1970
        int numYearsSinceEpoch = Calendar.getInstance().get(Calendar.YEAR) - 1970;
        int leapYearsSinceEpoch = numYearsSinceEpoch / 4;
        numYearsSinceEpoch -= leapYearsSinceEpoch;
        int daysSince = 365 * numYearsSinceEpoch;
        daysSince += 366 * leapYearsSinceEpoch; //14610
        daysSince += remainingDaysThisYear - 1; //(1st of Jan already accounted for)
        System.out.println("Number Of Years since 1970:" + numYearsSinceEpoch);
        System.out.println("Number of Leap Years since 1970:" + leapYearsSinceEpoch);
        System.out.println("Days since 1st Jan this year:" + remainingDaysThisYear);
        Assert.assertEquals((milliSeconds / (86400000)), daysSince);
    }
}
