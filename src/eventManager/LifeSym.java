package eventManager;

import human.Human;
import sustenance.food.drink.Drink;

public class LifeSym{
    public static void main(String[]args){
        Human human = new Human();
        while (human.isAlive){
            human.dehydr();
            human.thirst();
            human.drink();
            System.out.println(human.thirstLev);
        }
    }
}


