public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public static final double SHOT_COST = 0.5;
    public static final double SYRUP_COST = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + addSizePrice();
        if (extraShot) price += SHOT_COST;
        if (extraSyrup) price += SYRUP_COST;
        return price;
    }


    @Override
    public String toString() {
        return getName() + ", " + getSize() + ", Extra shot: " + extraShot + ", Extra syrup: " + extraSyrup + ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Coffee other = (Coffee) obj;
        return this.extraShot == other.extraShot && this.extraSyrup == other.extraSyrup;
    }

    public boolean hasExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean hasExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}
