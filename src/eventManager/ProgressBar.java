package eventManager;
import human.Human;

import java.util.Iterator;
import java.util.Stack;

/**
 * represents a progressbar, or meter, of some aspect
 */
public class ProgressBar {
    Stack progress = new Stack<String>();
    int meterMax = Human.meterMax;

    // constructor
    public ProgressBar() {
    }

    /**
     * converts a progressbar Stack structure to a string
     * @return
     */
    @Override
    public String toString() {
        Iterator progressiter = progress.iterator();
        String result = "";
        while (progressiter.hasNext()) {
            Object item = progressiter.next();
            result += item;
        }
        return result;
    }
    /**
     * fills a progressbar to maximum
     */
    private void fullBar() {
        for (int i = 0; i < 10; i++) {
            progress.push("#");
        }
    }

    /**
     * empties a progressbar
     */
    private void emptyBar() {
        for (int i = 0; i < 10; i++) {
            progress.pop();
        }
        for (int i = 0; i < 10; i++) {
            progress.push("");
        }
    }

    /**
     * adds to the progressbar
     * @param addVal
     */
    public void addToBar(float addVal) {
//        int meterMax = Human.meterMax;
        float percentAdd = (addVal / meterMax) * 100;
        float amtAdd = percentAdd / 10;

        System.out.println(amtAdd);
        for (int i = 0; i < amtAdd; i++) {
            progress.push("#");
        }
    }

    public void subToBar(float subVal) {
        int meterMax = Human.meterMax;
        int percentSub = (int) (subVal / meterMax);

        progress.pop();
    }

    /**
     * checks whether a progressbar is too large or too small (negatives)
     */
    public void validateBar() {
        ;
    }

    public static void main(String[] args) {
//        ProgressBar PB = new ProgressBar();
//
//        System.out.println(PB.progress);
//        PB.fullBar();
//        System.out.println(PB.progress);
//        System.out.println("Progress: [" + PB.toString() + "]");
        ProgressBar testBar = new ProgressBar();
        testBar.fullBar();
        System.out.println("Full bar: " + testBar.toString());
        testBar.emptyBar();
        System.out.println("Empty bar: " + testBar.toString());
        testBar.addToBar(420);
        System.out.println("Addto bar: " + testBar.toString());
    }
}

