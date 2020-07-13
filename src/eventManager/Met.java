package eventManager;


import java.lang.Double;

import static java.lang.Character.isDigit;

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
//        System.out.println("#########################");
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
     * take the last item. Lots of manipulations
     * TODO: try to do this in less steps
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
        StringBuilder cleanLine = edgeCaseHandler(lineSB);

        int removeIndex = findNumEnd(cleanLine);
        cleanLine.delete(0, removeIndex);
        System.out.println(cleanLine);

        // Rebuilding the line to now be split by commas
        this.activities = cleanLine.toString().split(" ,");


//        activities = activityArray;
    }

    /**
     * Finds where the number values end in an input line
     * @param cleanLine the line worked on
     * @return index of the first non number, or non space, or non period
     */
    private int findNumEnd(StringBuilder cleanLine) {
        int deleteIdx = 0;
        String cleanString = cleanLine.toString();
        for (int i = 0; i < cleanString.length(); i++) {
            Character c = cleanString.charAt(i);
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
     @param lineSB the stringbuilder of the line of the file being worked on
     **/
    private StringBuilder edgeCaseHandler(StringBuilder lineSB) {
        // TODO: Make an array of edge cases to loop through, do it more than once per line if it happened once, and get the formatting correct
        String[] edgeCases = {"(e.g.,", ")"};
        for (int i = 0; i < 3; i++) {
            int edgeIdx = lineSB.indexOf(edgeCases[0]);
            if (edgeIdx != -1) {
                lineSB.delete(edgeIdx, edgeIdx + 7);
                lineSB.replace(edgeIdx - 1, edgeIdx, ", ");
            }
            int edgeParenIdx = lineSB.indexOf(edgeCases[1]);
            if (edgeParenIdx != -1) {
                lineSB.delete(edgeParenIdx, edgeParenIdx+1);
            }
        }
        return lineSB;
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
        StringBuilder sb = new StringBuilder();
        for (String activity : activities) {
            sb.append(activity);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        return String.format("ID: %d MET: %.1f Category: %s Activities: %s", id, met, category, sb.toString());
    }
}
