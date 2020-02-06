package sustenance.food;

/**
 * An enum that stores various foods and their nourishment values.
 */
public enum Food {
    TOMATO(100),
    ONION(110),
    PEANUTS(220),
    PEA(10);

    // a value that represents how much nourishment (calories) is restored by a food to a human.
    private int nourishVal = 10;

    // constructor
    Food(int nourishVal) {
        this.nourishVal = nourishVal;
    }

    /**
     * returns the int value stored in a Food enum.
     * @return
     */
    public int getValue() {
        return nourishVal;
    }
}
