package ca.bcit.comp2522.bank;

/**
 * The Date class represents a date in a specific format, encapsulating
 * the day, month, and year.
 *
 * <p>
 * This class provides methods for creating and validating dates,
 * as well as retrieving information such as the day of the week
 * and string representations of the date in various formats.
 * </p>
 *
 * @author Mansib Talukder
 * @version 2024
 */
public class Date {

    // Days of months
    private static final int FULL_MONTH         = 31;
    private static final int THIRTY_DAY_MONTH   = 30;
    private static final int FEB_LEAP           = 29;
    private static final int FEB_NON_LEAP       = 28;

    private static final int MIN_YEAR       = 1800;
    private static final int MIN_DAY        = 1;
    private static final int CURRENT_YEAR   = 2024;
    private static final int CENTURY_2000   = 2000;
    private static final int CENTURY_1900   = 1900;

    // Months
    private static final int JANUARY    = 1;
    private static final int FEBRUARY   = 2;
    private static final int MARCH      = 3;
    private static final int APRIL      = 4;
    private static final int MAY        = 5;
    private static final int JUNE       = 6;
    private static final int JULY       = 7;
    private static final int AUGUST     = 8;
    private static final int SEPTEMBER  = 9;
    private static final int OCTOBER    = 10;
    private static final int NOVEMBER   = 11;
    private static final int DECEMBER   = 12;

    // Leap year divisors
    private static final int LEAP_YEAR_DIVISOR  = 4;
    private static final int HUNDRED_YEARS      = 100;
    private static final int FOUR_HUNDRED_YEARS = 400;
    private static final int ZERO_REMAINDER     = 0;
    private static final int FIRST_DOUBLE_DIGIT = 10;

    // Month Codes
    private static final int JAN_CODE = 1;
    private static final int FEB_CODE = 4;
    private static final int MAR_CODE = 4;
    private static final int APR_CODE = 0;
    private static final int MAY_CODE = 2;
    private static final int JUN_CODE = 5;
    private static final int JUL_CODE = 0;
    private static final int AUG_CODE = 3;
    private static final int SEP_CODE = 6;
    private static final int OCT_CODE = 1;
    private static final int NOV_CODE = 4;
    private static final int DEC_CODE = 6;

    // Century adjustments
    private static final int CENTURY_1800_ADJUSTMENT = 2;
    private static final int CENTURY_1900_ADJUSTMENT = 0;
    private static final int CENTURY_2000_ADJUSTMENT = 6;

    // Day of the week codes
    private static final int SAT = 0;
    private static final int SUN = 1;
    private static final int MON = 2;
    private static final int TUE = 3;
    private static final int WED = 4;
    private static final int THU = 5;
    private static final int FRI = 6;

    private static final int MODULO_DIVISOR         = 7;
    private static final int TWELVES_DIVISOR        = 12;
    private static final int FOURS_DIVISOR          = 4;
    private static final int LEAP_YEAR_ADJUSTMENT   = 6;
    
    private final int day;
    private final int month;
    private final int year;
    
    /**
     * Constructor method for Date class.
     * @param day   Day
     * @param month Month
     * @param year  Year
     */
    public Date (final int day, final int month, final int year) {
        validateDate(day, month, year);

        this.day    = day;
        this.month  = month;
        this.year   = year;
    }
    
    /**
     * Getter method for day.
     * @return Day
     */
    public int getDay() {
        return this.day;
    }
    
    /**
     * Getter method for month.
     * @return Month
     */
    public int getMonth() {
        return this.month;
    }
    
    /**
     * Getter method for Year.
     * @return Year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * This method validates the date for the constructor.
     * Years valid only between {@value MIN_YEAR} to {@value CURRENT_YEAR}.
     * Months valid only between {@value JANUARY} - {@value DECEMBER}.
     * Valid days according to months.
     *
     * @param day   Day
     * @param month Month
     * @param year  Year
     */
    private static void validateDate(final int day, final int month, final int year) {
        // Validate the year
        if (year < MIN_YEAR || year > CURRENT_YEAR) {
            throw new IllegalArgumentException("Invalid Year: " + year);
        }

        // Validate the month
        if (month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException("Invalid Month: " + month);
        }

        // Validate the day (day must be >= 1)
        if (day < MIN_DAY) {
            throw new IllegalArgumentException("Invalid Day: " + day);
        }

        // Check for February
        if (month == FEBRUARY) {
            final boolean leapYear;
            final int maxDays;
            
            leapYear = isLeapYear(year);
            maxDays = leapYear ? FEB_LEAP : FEB_NON_LEAP;
            if (day > maxDays) {
                throw new IllegalArgumentException("Invalid Day: " + day +
                        " for February in " + (leapYear ? "a leap year." : "a non-leap year."));
            }
            return;
        }

        // Check for months with 30 days
        if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) {
            if (day > THIRTY_DAY_MONTH) {
                throw new IllegalArgumentException("Invalid Day: " + day +
                        ". Month " + month + " only has " + THIRTY_DAY_MONTH + " days.");
            }
            return;
        }

        // Check for months with 31 days
        if (day > FULL_MONTH) {
            throw new IllegalArgumentException("Invalid Day: " + day +
                    ". Month " + month + " only has " + FULL_MONTH + " days.");
        }
    }

    /**
     * Helper method to check Leap Year.
     * @param year Year
     * @return true or false
     */
    private static boolean isLeapYear (final int year) {
        return ((year % LEAP_YEAR_DIVISOR == ZERO_REMAINDER) &&
                (year % HUNDRED_YEARS != ZERO_REMAINDER) ||
                (year % FOUR_HUNDRED_YEARS == ZERO_REMAINDER));
    }

    /**
     * Returns the date in YYYY-MM-DD format.
     * @return Date
     */
    public String getYYYYMMDD() {
        return year + "-" + ((month < FIRST_DOUBLE_DIGIT) ? "0" : "") + month +
                "-" + ((day < FIRST_DOUBLE_DIGIT) ? "0" : "") + day;
    }

    /**
     * This method calculates the day of the week for the given date.
     *
     * <p>
     * To get the day of the week, do the following seven steps for dates in the 1900s:
     * e.g. October 31 1977:
     * step 1: calculate the number of twelves in 77: 6
     * step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 = 5
     * step 3: calculate the number of fours in step 2: 5/4 = 1.25, so 1
     * step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 = 43
     * step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 = 44
     * step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)
     * step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday
     * </p>
     *
     * <p>
     * Extra notes:
     * a) for January/February dates in leap years, add 6 at the start
     * b) for all dates in the 2000s, add 6 at the start
     * c) for all dates in the 1800s, add 2 at the start
     * </p>
     *
     * <p>
     * Another example:
     * e.g. March 15 2021:
     * step 0: add 6 for dates in the 2000s: NUMBER IS 6
     * step 1: there is 1 twelve in 21; NUMBER IS 1
     * step 2: 21/12 = 1 remainder 9; NUMBER IS 9
     * step 3: there are 2 fours in 9: NUMBER IS 2
     * step 4: NUMBER IS 15
     * step 5: month code for march is 4: NUMBER IS 4
     * step 6: Add all numbers 6+1+9+2+15+4 = 37 NUMBER is 2: 37 mod 7 is 2
     * step 7: 37%7 = 2; 2 means monday
     * </p>
     *
     * The algorithm works for dates between {@value MIN_YEAR} and {@value CURRENT_YEAR}.
     * @return String representing the day of the week (e.g., "Monday").
     */
    public String getDayOfTheWeek() {
        
        int centuryAdjustment;
        int lastTwoDigitsOfYear;
        int twelves;
        int remainder;
        int fours;
        int total;
        int dayOfWeekCode;

        // Step 0: Add a century-specific value
        centuryAdjustment = getCenturyAdjustment(year);

        // Step 1: Calculate the number of twelves in the last two digits of the year
        lastTwoDigitsOfYear = year % HUNDRED_YEARS;
        twelves = lastTwoDigitsOfYear / TWELVES_DIVISOR;

        // Step 2: Calculate the remainder from the number of twelves
        remainder = lastTwoDigitsOfYear % TWELVES_DIVISOR;

        // Step 3: Calculate the number of fours in the remainder
        fours = remainder / FOURS_DIVISOR;

        // Step 4: Add the day of the month to the previous values
        total = day + twelves + remainder + fours;

        // Step 5: Add the month code
        total += getMonthCode(month);

        // Step 6: Handle January and February in leap years
        if (isLeapYear(year) && (month == JANUARY || month == FEBRUARY)) {
            total += LEAP_YEAR_ADJUSTMENT;
        }

        // Add the century adjustment from step 0
        total += centuryAdjustment;

        // Step 7: Modulo the total by 7 to get the day of the week
        dayOfWeekCode = total % MODULO_DIVISOR;

        // Return the day of the week based on the calculated code
        return getDayName(dayOfWeekCode);
    }

    /**
     * Helper method to get the month code.
     * @param month The month number
     * @return The corresponding month code.
     */
    private static int getMonthCode(final int month) {
        return switch (month) {
            case JANUARY -> JAN_CODE;
            case FEBRUARY -> FEB_CODE;
            case MARCH -> MAR_CODE;
            case APRIL -> APR_CODE;
            case MAY -> MAY_CODE;
            case JUNE -> JUN_CODE;
            case JULY -> JUL_CODE;
            case AUGUST -> AUG_CODE;
            case SEPTEMBER -> SEP_CODE;
            case OCTOBER -> OCT_CODE;
            case NOVEMBER -> NOV_CODE;
            case DECEMBER -> DEC_CODE;
            default -> throw new IllegalArgumentException("Invalid Month: " + month);
        };
    }

    /**
     * Helper method to get the century adjustment for the given year.
     * @param year The year
     * @return The corresponding century adjustment.
     */
    private static int getCenturyAdjustment(final int year) {
        if (year >= CENTURY_2000) {
            return CENTURY_2000_ADJUSTMENT;
        } else if (year >= CENTURY_1900) {
            return CENTURY_1900_ADJUSTMENT;
        } else {
            return CENTURY_1800_ADJUSTMENT;
        }
    }

    /**
     * Helper method to get the name of the day of the week.
     * @param dayOfWeekCode The calculated code for the day of the week.
     * @return The name of the day.
     */
    private static String getDayName(final int dayOfWeekCode) {
        return switch (dayOfWeekCode) {
            case SAT -> "Saturday";
            case SUN -> "Sunday";
            case MON -> "Monday";
            case TUE -> "Tuesday";
            case WED -> "Wednesday";
            case THU -> "Thursday";
            case FRI -> "Friday";
            default -> throw new IllegalArgumentException("Invalid Day of the Week Code: " + dayOfWeekCode);
        };
    }

    /**
     * This method returns the name of the month.
     * @return name of the month
     */
    public String getMonthString() {
        return switch (month) {
            case JANUARY -> "January";
            case FEBRUARY -> "February";
            case MARCH -> "March";
            case APRIL -> "April";
            case MAY -> "May";
            case JUNE -> "June";
            case JULY -> "July";
            case AUGUST -> "August";
            case SEPTEMBER -> "September";
            case OCTOBER -> "October";
            case NOVEMBER -> "November";
            case DECEMBER -> "December";
            default -> throw new IllegalArgumentException("Invalid Month: " + month);
        };
    }

    /**
     * toString() method override for Date class.
     * This method returns the date in MonthName Day Year format.
     * E.g. 31-1-2000 will return January 31, 2000.
     *
     * @return Date
     */
    @Override
    public String toString(){
        final StringBuilder sb;
        final String        string;
        
        sb = new StringBuilder();
        
        sb.append(this.getMonthString());
        sb.append(" ");
        sb.append(this.getDay());
        sb.append(", ");
        sb.append(this.getYear());
        
        string = sb.toString();
        
        return string;
    }

}
