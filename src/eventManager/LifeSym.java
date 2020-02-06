package eventManager;

import human.Human;

/**
 * LifeSym runs the entire program as it exists, currently as tests.
 */
public class LifeSym{
    public static void main(String[]args){
        Human human = new Human(); // creating a new human object

        // loop that terminates when a condition that kills the human is met
        while (human.isAlive){
            human.dehydr();
            human.drink();
            human.hunger();
            human.eat();
            human.checkLife();

            // outputs for visual testing
            System.out.println("Thirst: " + human.thirstLev);
            System.out.println("Hunger: " + human.hungerLev);
        }
    }
}


