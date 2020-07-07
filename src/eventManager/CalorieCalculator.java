package eventManager;

/**
 *
 */
public class CalorieCalculator {
    /**
     * Calculates the calories burned doing a specific activity
     * @param kilograms the weight of the person
     * @param mins amount of time spent doing activity
     * @param met "metabolic equivalent" the ratio of the work metabolic rate to the resting metabolic rate. See:
     *            https://sites.google.com/site/compendiumofphysicalactivities/
     * @return the amount of calories burned
     */
    public static double calcPhysicalCal(double kilograms, int mins, double met) {
        return ((kilograms * met) / 60) * mins;
    }

    public static void main(String[] args) {
        System.out.println(calcPhysicalCal(81.65, 30, 2.8));
    }
}
