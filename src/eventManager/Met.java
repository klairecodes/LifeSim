package eventManager;


import java.lang.Double;
import java.util.Arrays;

public class Met {
    private int id;
    private double met;
    private String category; // major activity
    private String[] activities; // specific actions

    /**
     * Creates a met object storing information associated with each activity
     * Input Data format: ID MET CATEGORY [ACTIVITIES]
     * @param metLine the entire line of the data file split by spaces
     */
    public Met(String metLine) {
        String[] metInfo = metLine.split(" ");
        this.id = Integer.parseInt(metInfo[0]);
        this.met = Double.parseDouble(metInfo[1]);
        String[] metActivities = metLine.split(", ");
        this.category = metInfo[2];
        this.activities = parseActivities(metActivities); // if list has one element, split it and just take the last item

        // debug
        System.out.println(id);
        System.out.print("Category: ");
        System.out.println(category);
        for (String item : activities) {
            System.out.print("Activity: ");
            System.out.println(item);
        }
    }

    /**
     * Gets the individual list of activities that are under a MET value
     * @param activities the part of the line of data that begins to list counted activities
     * @return an array of each listed activity
     */
    public String[] parseActivities(String[] activities) {
        String[] activityArray = new String[activities.length];
        if (this.category.equals("fishing")) { // edge case for string "fishing and hunting"
            activityArray[0] = "fishing and hunting";
        } else {
            String firstActivity = activities[0].split(" ")[3]; // getting the last item in first entry
            activityArray[0] = firstActivity;
        }
        for (int i = 1; i < activities.length; i++) {
            if (activities[i] != null) {
                activityArray[i] = activities[i];
            }
        }
        return activityArray;
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

    @Override
    public String toString() {
        return String.format("ID: %d MET: %.1f Category: %s", id, met, category);
    }
}
