package sustenance.food.drink;

/**
 * An enum that stores various drinks and their hydrate values.
 */
public enum Drink {
    WATER(100),
    ALLIGATORADE(90),
    SPROTE(40),
    BEBSI(20),
    GINGER_ALE(20),
    SELTZER(100),
    ROOT_BEER(40);

    // a value that represents how hydrating a drink is to a human
    private int hydrateVal;

    // constructor
    Drink(int hydrateVal) {
        this.hydrateVal = hydrateVal;
    }

    /**
     * returns the int value stored in a Drink enum
     * @return
     */
    public int getValue() {
        return hydrateVal;
    }
}
