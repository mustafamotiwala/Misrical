package org.misrical.chronos;

import java.util.Calendar;

import static java.lang.Math.*;

import org.misrical.geo.IGeoLocation;
import org.misrical.util.Calculations;

/**
 * This class calculates the length of day in hours/minutes for
 * a given day. Takes a Calendar object as input.
 *
 * @author mustafa
 */
public class DayLengthCalculator {

    private final long JAN012000 = 2451545L;
    private final double CYCLE_CONST = 0.0009;

    public DayLengthCalculator() {
    }

    /**
     * Calculates the length of a given day. Uses the Calendar object to pass in
     * the target date. The hour, if not specified in the Calendar object, will default
     * to 12.00 NOON. Reason being, we need to convert the dates between Julian & Gregorian
     * and hour of the day impacts the generated Julian Day.
     * Ref:
     * http://users.electromagnetic.net/bu/astro/sunrise-set.php
     *
     * @param cal      - Gregorian calendar day for which the day length is to be calculated.
     * @param location - a lat/long position for which the DayLength is to be calculated.
     * @return - A DayLength object with with the Sunrise and Sunset for the given day.
     */
    public DayLength getLengthOfDay(Calendar cal, IGeoLocation location) {
//        double latitudeNorth = location.getLatitude().getDegrees();
//        double longitudeWest = location.getLatitude().getDegrees();

//        latitudeNorth = location.getLatitude().getOrientation() == GeoOrientation.NORTH ? latitudeNorth : latitudeNorth * -1; //for degrees to the south, inverse sign.
//        longitudeWest = location.getLongitude().getOrientation() == GeoOrientation.WEST ? longitudeWest : longitudeWest * -1; //for degrees to the east, inverse sign.

        Calendar gregorianDate = makeDefensiveCopy(cal);
        double julianDay = Calculations.toJulianValue(gregorianDate);
        long julianCycle = round((julianDay - JAN012000 - CYCLE_CONST) - (location.getLongitude().getDegrees() / 360));
        double approxSolarNoon = JAN012000 + CYCLE_CONST + location.getLongitude().getDegrees() / 360 + julianCycle;
        double meanSolarAnomaly = (357.5291 + 0.98560028 * (approxSolarNoon - JAN012000)) % 360;
        double equationOfCenter = (1.9148 * sin(meanSolarAnomaly)) + (0.0200 * sin(2 * meanSolarAnomaly)) + (0.0003 * sin(3 * meanSolarAnomaly));
        double longitudeOfSun = (meanSolarAnomaly + 102.9372 + equationOfCenter + 180) % 360;
        double julianSolarNoon = approxSolarNoon + (0.0053 * sin(meanSolarAnomaly)) - (0.0069 * sin(2 * longitudeOfSun));
        double sunDeclination = Math.asin(sin(longitudeOfSun) * sin(23.45));
        double hourAngle = Math.acos((sin(-0.83) - sin(location.getLatitude().getDegrees()) * sin(sunDeclination)) / (cos(location.getLatitude().getDegrees()) * cos(sunDeclination)));
        approxSolarNoon = JAN012000 + CYCLE_CONST + ((hourAngle + location.getLongitude().getDegrees()) / 360) + julianCycle;
        double julianSunSet = approxSolarNoon + (0.0053 * sin(meanSolarAnomaly)) - (0.0069 * sin(2 * longitudeOfSun));
        double julianRise = julianSolarNoon - (julianSunSet - julianSolarNoon);

        assert julianSunSet > julianRise : "The sunset value for " + julianDay + " is higher than the sunrise value";

        return new DayLength(julianRise, julianSunSet);
    }

    /**
     * This method creates a safe copy of the passed in Calendar object.
     *
     * @param cal Calendar to be copied.
     * @return a copy of the passed in Calendar object.
     */
    private Calendar makeDefensiveCopy(Calendar cal) {
        Calendar returnVal = Calendar.getInstance();
        returnVal.setTimeInMillis(cal.getTimeInMillis());
        return returnVal;
    }
}
