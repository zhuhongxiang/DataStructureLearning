package BasicLearning;

/**
 * The <CODE>TemperatureConversion</CODE> Java application prints a table
 * converting Celsius to Fahrenheit degrees
 *
 * @author zhx
 */
public class TemperatureConversion {
    /**
    * The main method prints a Celsius to Fahrenheit conversion table
    * The bounds of the table range from -50C to +50C in 10 degree increments
    **/
    public static void main(String[] args) {
        final double TABLE_BEGIN = -50.0;
        final double TABLE_END = 50.0;
        final double TABLE_STEP = 10.0;

        double celsius;
        double fahrenheit;

        System.out.println("TEMPERATURE CONVERSION");
        System.out.println("----------------------");
        System.out.println("Celsius     Fahrenheit");

        for (celsius = TABLE_BEGIN; celsius < TABLE_END; celsius+=TABLE_STEP) {
            fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%6.2fC",celsius);
            System.out.printf("%14.2fF\n",fahrenheit);
        }
    }

    /**
     * Convert a temperature from Celsius degrees to Fahrenheit degrees
     * @param celsius
     *  a temperature in Celsius degrees
     * @precondition
     *  celsius > -273.15
     * @return
     *  the temperature celsius converted to Fahrenheit
     * @throws IllegalArgumentException
     *  Indicates that celsius is less than smallest Celsius temperature(-273.15)
     */
    private static double celsiusToFahrenheit(double celsius) {
        final double MINMUM_CELSIUS = -273.15;
        if (celsius < MINMUM_CELSIUS) {
            throw new IllegalArgumentException("Argument" + celsius + "is too small");
        }
        return (9.0/5.0)*celsius +32;
    }
}
