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
        Iterator progressIter = progress.iterator();
        String result = "";
        while (progressIter.hasNext()) {
            Object item = progressIter.next();
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
        float percentAdd = (addVal / meterMax) * 100;
        float amtAdd = percentAdd / 10;

        System.out.println(amtAdd);
        for (int i = 0; i < amtAdd; i++) {
            progress.push("#");
        }
    }

    public void subToBar(float subVal) {
        float percentSub = (subVal / meterMax) * 100;
        float amtSub = percentSub / 10;

        System.out.println(amtSub);
        for (int i = 0; i < amtSub; i++) {
            progress.pop();
        }
    }

    /**
     * checks whether a progressbar is too large or too small (negatives)
     */
    public void validateBar() {
        int pgBarLen = progress.toString().length();

        if (pgBarLen < 0) {
            System.out.println("Empty bar.");
        }
        else if (pgBarLen > 10) {
            this.subToBar(pgBarLen - 10);
        }
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
        testBar.subToBar(300);
        testBar.validateBar();
        System.out.println("Addto bar: " + testBar.toString());
    }
}

