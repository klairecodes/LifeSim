package human;
//import eventManager.Checkup;

import sustenance.food.drink.Drink;

public class Human {
    public static int meterMax;
    public boolean isAlive;
    public int thirstLev;

    public Human() {
        Human human = new Human();
        meterMax = 1000;
        isAlive = true;
        thirstLev = 1000;
    }

    public void thirst() {
        if (thirstLev <= 0) {
            isAlive = false;
        }
    }

    public void dehydr() {
        thirstLev -= 100;
    }

    public int drink() {
        int replenish = Drink.BEBSI;
        thirstLev += ;
        return thirstLev;
    }
}
