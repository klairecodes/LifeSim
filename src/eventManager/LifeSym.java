package eventManager;

import human.Human;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LifeSym runs the entire program as it exists, currently as tests.
 */
public class LifeSym{
    public static List getMetData(String filename) throws FileNotFoundException {
        File metFile = new File(filename);
        Scanner sc = new Scanner(metFile);
        List<Met> metData = new ArrayList<Met>();

        while (sc.hasNextLine()){
            Met met = new Met(sc.nextLine());
            metData.add(met);
        }
        return metData;
    }

    public static void main(String[]args){
        Human human = new Human(); // creating a new human object
        ProgressBar bar = new ProgressBar(); // creating a new progressbar object
        try {
//            List<Met> metValues = getMetData("res/MET.txt");
            List<Met> metValues = getMetData("res/testMET.txt");
//            System.out.println(metValues.get(821));
            for (Met metItem : metValues) {
                System.out.println(metItem);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // loop that terminates when a condition that kills the human is met
//        while (human.isAlive){
//            human.dehydr();
//            human.drink();
//            human.hunger();
//            human.eat();
//            human.checkLife();
//
//            // outputs for visual testing
//            System.out.println("Thirst: " + human.thirstLev);
//            System.out.println("Hunger: " + human.hungerLev);
//            bar.addToBar((float) 420.0);
//            System.out.println(bar.toString());
//        }
        System.out.println("Finished.");
    }
}


