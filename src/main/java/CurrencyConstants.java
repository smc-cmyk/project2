import java.util.HashMap;

/**
 *
 * File containing the constants for currenchy conversion.
 * Creates and populates HashMaps with historical currency
 * conversion data.
 * Also contains date of retrieval of data..
 *
 * @author Sean McFerran
 * @version 0.1.0
 * @since 04/14/2026
 */

public class CurrencyConstants {

    //TIMESTAMP FOR DATA RETRIEVAL
    public static final String dateOfRetrieval = "April 14, 2026, 10:00AM PST";

    //ONE US DOLLAR IS EQUAL TO...
    public static final double usdToEuro = 0.85;
    public static final double usdToYen = 158.72;
    public static final double usdToPound = 0.74;
    public static final double usdToYuan = 6.82;
    public static final double usedToCad = 1.38;

    //ArrayList for AVERAGES of historical data. 1970, 1980, 1990, 2000, 2010, 2020, TODAY
    public HashMap<Integer, Double> hUsdToEuro = new HashMap<>();
    public HashMap<Integer, Double> hUsdToYen = new HashMap<>();
    public HashMap<Integer, Double> hUsdToPound = new HashMap<>();
    public HashMap<Integer, Double> hUsdToYuan = new HashMap<>();
    public HashMap<Integer, Double> hUsdToCad = new HashMap<>();

    /**
     * Add data to populate HashMaps.
     */
    public void addingData() {
        //Euro did not exist until 1999
        hUsdToEuro.put(2000, 1.086);
        hUsdToEuro.put(2010, 0.755);
        hUsdToEuro.put(2020, 0.877);
        hUsdToEuro.put(2026, usdToEuro);
        hUsdToYen.put(1970, 360);
        hUsdToYen.put(1980, 226.63);
        hUsdToYen.put(1990, 125);
        hUsdToYen.put(2000, 107.8);
        hUsdToYen.put(2010, 87.77);
        hUsdToYen.put(2020, 106.75);
        hUsdToYen.put(2026, usdToYen);
        hUsdToPound.put(1970, 0.417);
        hUsdToPound.put(1980, 0.43);
        hUsdToPound.put(1990, 0.56);
        hUsdToPound.put(2000, 0.66);
        hUsdToPound.put(2010, 0.648);
        hUsdToPound.put(2020, 0.78);
        hUsdToPound.put(2026, usdToPound);
        hUsdToYuan.put(1970, 2.46);
        hUsdToYuan.put(1980, 1.5);
        hUsdToYuan.put(1990, 4.78);
        hUsdToYuan.put(2000, 8.279);
        hUsdToYuan.put(2010, 6.77);
        hUsdToYuan.put(2020, 6.9);
        hUsdToYuan.put(2026, usdToYuan);
        hUsdToCad.put(1970, 1.044);
        hUsdToCad.put(1980, 1.169);
        hUsdToCad.put(1990, 1.167);
        hUsdToCad.put(2000, 1.486);
        hUsdToCad.put(2010, 1.03);
        hUsdToCad.put(2020, 1.342);
        hUsdToCad.put(2026, usdToCad);
    }

}