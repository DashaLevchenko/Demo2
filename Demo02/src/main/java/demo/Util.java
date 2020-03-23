package demo;

public class Util {

    private Util() {
    }

    /**
     * Calculate percent of values
     *
     * @param presentValue current animal points
     * @param maxValue constant max animal points
     * @return cast result to double and return
     */
    public static double calculatePercent(int presentValue, int maxValue) {

        return (double) presentValue / maxValue;
    }


}
