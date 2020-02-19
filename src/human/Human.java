package human;
import java.lang.Enum;

/**
 * The human class defines a human and all the processes associated with it.
 */
import sustenance.food.Food;
import sustenance.food.drink.Drink;

public class Human {
    public static int meterMax = 1000; // the maximum size of a meter shown to the user
    public boolean isAlive; // whether the human is alive or not.
    public int thirstLev; // level of thirst/dehydration
    public int hungerLev; // level of hunger/starvation

    // constructor
    public Human() {
        meterMax = 1000;
        isAlive = true;
        thirstLev = 1000;

        hungerLev = 1000;
    }

    // method to check whether the human is alive or not.
    public void checkLife() {
        if (thirstLev <= 0) {
            isAlive = false;
        }
        if (hungerLev <= 0) {
            isAlive = false;
        }
    }

    // steadily dehydrates the human
    public void dehydr() {
        thirstLev -= 100;
    }

    // the act of drinking and restoring hydration
    public int drink() {
        thirstLev -= Drink.ALLIGATORADE.getValue();
        return thirstLev;
    }

    // steadily starves the human
    public void hunger() {
        hungerLev -= 20;
    }

    // the act of eating and restoring sustenance.
    public int eat() {
        hungerLev += Food.PEA.getValue();
        return hungerLev;
    }
}
