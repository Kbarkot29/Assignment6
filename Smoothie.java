public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;

    public static final double PROTEIN_COST = 1.5;
    public static final double FRUIT_COST = 0.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
    	double price = BASE_PRICE +  addSizePrice();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) price += PROTEIN_COST;
        return price;
    }

    @Override
    public String toString() {
        return getName() + ", " + getSize() + ", Fruits: " + numOfFruits + ", Protein: " + addProtein +
               ", Price: $" + String.format("%.2f", calcPrice());
    }
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Smoothie other = (Smoothie) obj;
        return this.numOfFruits == other.numOfFruits && this.addProtein == other.addProtein;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean isAddProtein() {
        return addProtein;
    }

    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }
}
