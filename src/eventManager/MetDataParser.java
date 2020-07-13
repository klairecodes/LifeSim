package eventManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parses a specifically formatted data file for the required values for each MET
 * Input Data format: ID MET CATEGORY [ACTIVITIES]
 */
public class MetDataParser {
    private static Integer id;
    private static Double metVal;
    private static String category;
    private static String[] activities;
    private static final String[] categoryOptions = {
            "bicycling", "conditioning exercise", "dancing",
            "fishing and hunting", "home activities", "home repair", "inactivity", "lawn and garden", "miscellaneous",
            "music playing", "occupation", "running", "self care", "sexual activity", "sports", "transportation",
                    "walking", "water activities", "winter activities", "religious activities", "volunteer activities"
            };

    /**
     * Parses through the file, extracts the data and puts it in a MET class, then adds all METs to a List
     * @param filename the file containing all of the MET data, from the Compendium of Physical Activity
     * @return a list structure containing all the met data listed in the file
     */
    public static List getMetData(String filename) {
        try {
            File metFile = new File(filename);
            Scanner sc = new Scanner(metFile);
            List<Met> metData = new ArrayList<Met>();

            while (sc.hasNextLine()) {
                parseLine(sc.nextLine());
                Met met = new Met(id, metVal, category, activities);
                metData.add(met);
            }
            return metData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Gets the individual list of activities that are under a MET value // if list has one element, split it and just
     * take the last item. Lots of manipulations
     * @param metLine the entire line of the data file
     */
    public static void parseLine(String metLine) {
        // temporarily setting private state. May not be best practice
        id = Integer.parseInt(metLine.split(" ")[0]);
        metVal = Double.parseDouble(metLine.split(" ")[1]);

        StringBuilder lineSB = new StringBuilder();
        lineSB.append(metLine);

        /* find the category in the line, set it, and then remove from string builder. This ensures no strange activity
           parsing occurs
        */
        for (String option : categoryOptions) {
            int optionIdx = lineSB.indexOf(option);
            if (optionIdx != -1) {
                category = option;
                lineSB.delete(optionIdx, optionIdx + option.length() + 1);
                break;
            }
        }
        StringBuilder cleanLine = edgeCaseHandler(lineSB);

        // Finding where the number values end in order to chop them off
        int removeIndex = findNumEnd(cleanLine);
        cleanLine.delete(0, removeIndex);

        // Getting the final correctly formatted array of activities
        activities = cleanLine.toString().split(" ,");
    }

    /**
     * Finds where the number values end in an input line
     * @param cleanLine the line worked on
     * @return index of the first non number, or non space, or non period
     */
    private static int findNumEnd(StringBuilder cleanLine) {
        int deleteIdx = 0;
        String cleanString = cleanLine.toString();
        for (int i = 0; i < cleanString.length(); i++) {
            char c = cleanString.charAt(i);
            if (c == '.' || c == ' ') {
            } else if (Character.isDigit(c)) {
            } else {
                deleteIdx = i;
                break;
            }
        }
        return deleteIdx;
    }

    /**
     Attempts to remove edge cases: "(e.g., ... )" from dataset and restores ideal formatting
     @param lineSB the StringBuilder of the line of the file being worked on
     **/
    private static StringBuilder edgeCaseHandler(StringBuilder lineSB) {
        String[] edgeCases = {"(e.g.,", "(", ")"}; // unique strings that are unnecessary and/or in the way
        for (int i = 0; i < 4; i++) {
            int edgeIdx = lineSB.indexOf(edgeCases[0]);
            if (edgeIdx != -1) {
                lineSB.delete(edgeIdx, edgeIdx + 7);
                lineSB.replace(edgeIdx - 1, edgeIdx, ", ");
            }
            int edgeParenClosedIdx = lineSB.indexOf(edgeCases[1]);
            if (edgeParenClosedIdx != -1) {
                lineSB.delete(edgeParenClosedIdx, edgeParenClosedIdx+1);
            }
            int edgeParenOpenIdx = lineSB.indexOf(edgeCases[2]);
            if (edgeParenOpenIdx != -1) {
                lineSB.delete(edgeParenOpenIdx, edgeParenOpenIdx+1);
            }
        }
        return lineSB;
    }

}
