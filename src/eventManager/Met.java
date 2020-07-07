package eventManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Met {
    private int id;
    private float met;
    private String category; // major activity
    private String[] activities; // specific actions

    public Met(File data) throws FileNotFoundException {
        Scanner sc = new Scanner(data);

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
        }

    }
}
