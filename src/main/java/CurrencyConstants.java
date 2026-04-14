import java.util.HashMap;

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

    }

}