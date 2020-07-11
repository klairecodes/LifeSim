package eventManager;


import java.lang.Double;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Met {
    private final String[] categoryOptions = {"bicycling", "conditioning exercise", "dancing", "fishing and hunting", "home activities", "home repair", "inactivity", "lawn and garden", "miscellaneous", "music playing", "occupation", "running", "self care", "sexual activity", "sports", "transportation", "walking", "water activities", "winter activities", "religious activities", "volunteer activities"};
    private Integer id;
    private Double met;
    private String category; // major activity
    private String[] activities; // specific actions

    /**
     * Creates a met object storing information associated with each activity
     * Input Data format: ID MET CATEGORY [ACTIVITIES]
     * @param fileLine the entire line of the data file split by spaces
     */
    public Met(String fileLine) {
        String[] metInfo = fileLine.split(" ");
        this.id = Integer.parseInt(metInfo[0]);
        this.met = Double.parseDouble(metInfo[1]);
//        this.category = metInfo[2];
        parseSpaceItems(fileLine);

        // debug
        System.out.println("#########################");
//        System.out.println(fileLine);
//        System.out.print("ID: ");
//        System.out.println(id);
//        System.out.print("MET: ");
//        System.out.println(met);
//        System.out.print("Category: ");
//        System.out.println(category);
    }

    /**
     * Gets the individual list of activities that are under a MET value // if list has one element, split it and just
     * take the last item
     * @param metLine the entire line of the data file 
     */
    public void parseSpaceItems(String metLine) {
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

        StringBuilder cutLine = removeValueStrings(lineSB);

        // The list separated by commas in order to get values that include spaces
        String[] commaList = metLine.split(", ");
        // Getting the correct category
        String[] categoryArray = commaList[0].split(" "); // splitting the first item for category extraction

        // Getting the array of activities described
        String[] activityArray = new String[commaList.length];
        String firstActivity = commaList[0].split(" ")[3]; // getting the last item in first entry
        activityArray[0] = firstActivity;

        for (int i = 1; i < commaList.length; i++) {
            if (commaList[i] != null) {
                activityArray[i] = commaList[i];
            }
        }

        activities = activityArray;
    }

    /**
     * Removes the id and met values from the line looked at
     * @param builtLine the stringbuilder currently being worked on
     * @return a stringbuilder with the necessary values removed
     */
    private StringBuilder removeValueStrings(StringBuilder builtLine) {
        StringBuilder newLine = new StringBuilder();
        String[] lineArray = builtLine.toString().split(" ");

        for (int i = 0; i < lineArray.length; i++) {
            if (i > 1 && i != lineArray.length-1) {
                newLine.append(lineArray[i]);
                newLine.append(" ");
            } else if (i == lineArray.length-1) {
                newLine.append(lineArray[i]);
            }
        }
        System.out.println(newLine);
        return builtLine;

    }

    public int getId() {
        return id;
    }

    public double getMet() {
        return met;
    }

    public String getCategory() {
        return category;
    }

    public String[] getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return String.format("ID: %d MET: %.1f Category: %s", id, met, category);
    }
}
