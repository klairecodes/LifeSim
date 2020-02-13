package eventManager;
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

    public static void main(String[] args) {
        ProgressBar PB = new ProgressBar();

        System.out.println(PB.progress);
        PB.fullBar();
        System.out.println(PB.progress);
        System.out.println("Progress: [" + PB.toString() + "]");
    }
}
