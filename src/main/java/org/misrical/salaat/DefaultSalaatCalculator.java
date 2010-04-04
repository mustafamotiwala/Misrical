package org.misrical.salaat;

import java.util.Calendar;
import java.util.Map;

import org.misrical.chronos.DayLength;
import org.misrical.chronos.DayLengthCalculator;
import org.misrical.geo.IGeoLocation;
import org.misrical.util.Time;

/**
 * The default implementation. Uses the {@link DayLengthCalculator} to calculate the length of a day, and then
 * uses the Rise and Set values to calculate the "Ghari" length and Noon times to determine the salaat times and durations.
 *
 * @author mustafa
 */
public class DefaultSalaatCalculator implements ISalaatCalculator {

    /* (non-Javadoc)
    * @see org.misrical.salaat.ISalaatCalculator#getSalatTime(java.util.Calendar, org.misrical.geo.IGeoLocation)
    */

    @Override
    public ISalaatClock getSalatTime(Calendar date, IGeoLocation location) {
        DayLengthCalculator calculator = new DayLengthCalculator();
        DayLength lengthDay = calculator.getLengthOfDay(date, location);
        SalaatClock returnVal = new SalaatClock();
        // TODO: Calculate sihori End time/Fajr start time.
        double sunRise = lengthDay.getSunrise();
        returnVal.endFajr = Time.buildFromDoubleValue(sunRise);
        double sunSet = lengthDay.getSunset();
        returnVal.maghrib = Time.buildFromDoubleValue(sunSet);
        double length = lengthDay.length();
        double zawwal = (length / 2D) + sunRise; //Midday = zawwal.
        returnVal.zawwal = Time.buildFromDoubleValue(zawwal);
        double ghariLength = length / 12; //Calculate the length of a day 'ghari' which is total daylength divided into twelve parts.
        returnVal.endZuhr = Time.buildFromDoubleValue(zawwal + (ghariLength * 2)); //Zuhr is for two gharis.
        returnVal.endAsr = Time.buildFromDoubleValue(zawwal + (ghariLength * 4)); //Asr lasts two gharis after zuhr ends
        return returnVal;
    }

    /* (non-Javadoc)
    * @see org.misrical.salaat.ISalaatCalculator#getSalatTimesForMonth(org.misrical.salaat.SalaatCalculationRequest)
    */

    @Override
    public Map<Integer, ISalaatClock> getSalatTimesForMonth(SalaatCalculationRequest request) {
        request.getMonth();
        // TODO Implement the method.
        return null;
    }
}

/**
 * Local class to hold the values for SalaatClock.
 *
 * @author mustafa
 */
class SalaatClock implements ISalaatClock {
    Time endSihori, startFajr, endFajr, zawwal, endZuhr, endAsr, maghrib;

    @Override
    public Time getAsrEnd() {
        return endAsr;
    }

    @Override
    public Time getFajrEnd() {
        return endFajr;
    }

    @Override
    public Time getFajrStart() {
        return startFajr;
    }

    @Override
    public Time getMaghrib() {
        return maghrib;
    }

    @Override
    public Time getSihoriEndTime() {
        return endSihori;
    }

    @Override
    public Time getZawwal() {
        return zawwal;
    }

    @Override
    public Time getZuhrEnd() {
        return endZuhr;
    }

}
