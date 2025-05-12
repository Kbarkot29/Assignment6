public class Alcohol extends Beverage {
    private boolean isWeekend;
    public static final double WEEKEND_COST = 0.6;

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (isWeekend) price += WEEKEND_COST;
        return price;
    }

    @Override
    public String toString() {
        return getName() + ", " + getSize() + ", Weekend: " + isWeekend + ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Alcohol other = (Alcohol) obj;
        return this.isWeekend == other.isWeekend;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}
