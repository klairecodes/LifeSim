package eventManager;


import java.lang.Double;

import static java.lang.Character.isDigit;

public class Met {
    private Integer id;
    private Double met;
    private String category; // major activity
    private String[] activities; // specific actions

    /**
     * Creates a met object storing information associated with each activity
     */
    public Met(Integer id, Double met, String category, String[] activities) {
        this.id = id;
        this.met = met;
        this.category = category;
        this.activities = activities;
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
