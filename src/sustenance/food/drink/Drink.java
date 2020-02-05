package sustenance.food.drink;

public enum Drink {
    WATER(100),
    GATORADE(90),
    SPROTE(40),
    BEBSI(20),
    GINGER_ALE(20),
    SELTZER(100),
    ROOT_BEER(40);

    private int hydrateVal;

    Drink(int hydrateVal) {
        this.hydrateVal = hydrateVal;
    }


}
