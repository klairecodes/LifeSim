package eventManager;
import human.Human;

import java.util.Iterator;
import java.util.Stack;

/**
 * represents a progressbar, or meter, of some aspect
 */
public class ProgressBar {
    Stack progress = new Stack<String>();

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
            progress.push(" ");
        }
    }

    /**
     * adds to the progressbar
     * @param addVal
     */
    public void addToBar(float addVal) {
        int meterMax = Human.meterMax;
        int percentAdd = (int) (addVal / meterMax);
        int amtAdd = (int) ((addVal / meterMax) - (addVal % meterMax));

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
        testBar.emptyBar();
        testBar.addToBar(42);
        System.out.println(testBar.toString());
    }
}

